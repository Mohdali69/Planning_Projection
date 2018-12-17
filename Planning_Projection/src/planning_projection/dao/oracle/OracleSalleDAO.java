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
import planning_projection.dao.ISalleDAO;
import planning_projection.metier.Salle;

/**
 *
 * @author Mohamed
 */
public class OracleSalleDAO implements ISalleDAO{
    private static DataSource ds; 
    private static Connection connexionBD;
    
    @Override
    public void setDataSource(DataSource ds){
        OracleSalleDAO.ds = ds; 
    }
    
    @Override
    public void setConnection (Connection c) {
        OracleSalleDAO.connexionBD = c;
    }
   
    
    @Override 
    public List<Salle> getLesSalles() {
        ResultSet rset = null; 
        Statement stmt = null;
        List<Salle> listeSalle = null; 
        try {
              stmt= connexionBD.createStatement();
              listeSalle = new ArrayList<>();
              rset = stmt.executeQuery("SELECT * from SALLE");
              while(rset.next()){
                Salle newM = new Salle(rset.getString("nom"), rset.getInt("places"),rset.getInt("numSalle"));
                listeSalle.add(newM);
            }
            }catch(SQLException ex){
             Logger.getLogger(OracleSalleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        
        return listeSalle ;
        
        
        
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
