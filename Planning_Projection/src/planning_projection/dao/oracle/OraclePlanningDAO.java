/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.dao.oracle;

import java.sql.CallableStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import planning_projection.metier.Planning;
import planning_projection.dao.IPlanningDAO;

/**
 *
 * @author Mohamed
 */
public class OraclePlanningDAO implements IPlanningDAO{
    private static DataSource ds; 
    private static Connection connexionBD;
    
    @Override
    public void setDataSource(DataSource ds){
        OraclePlanningDAO.ds = ds; 
    }
    
    @Override
    public void setConnection (Connection c) {
        OraclePlanningDAO.connexionBD = c;
    }
   
    //Recupère les Plannings de la BD
    @Override 
    public List<Planning> getLesPlannings() {
        ResultSet rset = null; 
        Statement stmt = null;
        List<Planning> listePlanning = null; 
        try {
              stmt= connexionBD.createStatement();
              listePlanning = new ArrayList<>();
              rset = stmt.executeQuery("SELECT * from Planning");
              while(rset.next()){
                Planning newM = new Planning(rset.getInt("numPlanning"));
                listePlanning.add(newM);
            }
            }catch(SQLException ex){
             Logger.getLogger(OraclePlanningDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        
        return listePlanning ;
        
        
        
    }
    //Créer une Projection de la BD
    @Override
    public void creerPlanning(Planning Planning){ 
        PreparedStatement state = null;
        try{
            state=OraclePlanningDAO.connexionBD.prepareStatement("INSERT INTO Planning (numPlanning) VALUES (?)");
            state.setInt(1,Planning.getNumPlanning());
            state.execute();
            state.close();
        }catch(SQLException ex){
           Logger.getLogger(OraclePlanningDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    //Supprime un Planning de la BD
    @Override
   public void supprimerPlanning(Planning Planning) {
         PreparedStatement state = null;
        try{
            state=OraclePlanningDAO.connexionBD.prepareStatement("DELETE FROM Planning WHERE numPlanning = ?");
            state.setInt(1,Planning.getNumPlanning());
            state.execute();
            state.close();
        }catch(SQLException ex){
           Logger.getLogger(OraclePlanningDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public int procedure() throws SQLException{
       String sql = "{? = call nombre_bus";
       CallableStatement state = connexionBD.prepareCall(sql);
       state.registerOutParameter(1,Types.INTEGER);
       state.execute();
       int resultat = state.getInt(1);
       return resultat;
   }
    
    
}
