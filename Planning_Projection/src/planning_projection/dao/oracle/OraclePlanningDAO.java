/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.dao.oracle;

import java.sql.CallableStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import planning_projection.dao.IPlanningDAO;
import planning_projection.metier.Projection;

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
   
    
    @Override 
    public List<Projection> getLesProjection() {
        ResultSet rset = null; 
        Statement stmt = null;
        List<Projection> listeMiniBus = null; 
        try {
              stmt= connexionBD.createStatement();
              listeMiniBus = new ArrayList<>();
              rset = stmt.executeQuery("SELECT * from MINIBUS");
              while(rset.next()){
                MiniBus newM = new MiniBus(rset.getInt("NOMINIBUS"), rset.getInt("CAPACITE"));
                listeMiniBus.add(newM);
            }
            }catch(SQLException ex){
             Logger.getLogger(OraclePlanningDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        
        return listeMiniBus ;
        
        
        
    }
    
    @Override
    public void creerProjection(Projection Projection){ 
        PreparedStatement state = null;
        try{
            state=OraclePlanningDAO.connexionBD.prepareStatement("INSERT INTO MINIBUS (NOMINIBUS,CAPACITE) VALUES (?,?)");
            state.setInt(1,Projection.getNumeroMiniBus());
            state.setInt(2,Projection.getCpt());
            state.execute();
            state.close();
        }catch(SQLException ex){
           Logger.getLogger(OraclePlanningDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }

    @Override
   public void supprimerAdministratif(Projection Projection) {
         PreparedStatement state = null;
        try{
            state=OraclePlanningDAO.connexionBD.prepareStatement("DELETE FROM MINIBUS WHERE NOMINIBUS = ? AND CAPACITE = ?");
            state.setInt(1,Projection.getNumeroMiniBus());
            state.setInt(2,Projection.getCpt());
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
