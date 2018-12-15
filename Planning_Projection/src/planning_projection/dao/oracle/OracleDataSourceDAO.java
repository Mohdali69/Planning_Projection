/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.dao.oracle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource; 


/**
 *
 * @author Mohamed
 */
public class OracleDataSourceDAO extends OracleDataSource {
    
    public static OracleDataSourceDAO ods;
    
    private OracleDataSourceDAO () throws SQLException  {
    }
    
    public static OracleDataSourceDAO getOracleDataSourceDAO() throws FileNotFoundException{
       FileInputStream fichier = null; 
       
        try{
            
       Properties props = new Properties();
       fichier = new FileInputStream( ".\\src\\sortieminibus\\dao\\oracle\\connexion.properties");
            ods = new OracleDataSourceDAO();
            ods.setDriverType("thin");
            ods.setPortNumber(1521);
            ods.setServiceName("orcl.univ-lyon1.fr");
            ods.setUser("p1702053");
            ods.setPassword("295543");
            ods.setServerName("iutdoua-oracle.univ-lyon1.fr");
  
        }catch (Exception ex) {
            Logger.getLogger(OracleDataSourceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ods;
       
      
    
    }
    
}

