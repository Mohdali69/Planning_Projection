/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.dao.oracle;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
 


/**
 *
 * @author Mohamed
 */
public class OracleDataSourceDAO extends MysqlDataSource {
    
    public static OracleDataSourceDAO ods;
    
    private OracleDataSourceDAO () throws SQLException  {
    }
    
    public static OracleDataSourceDAO getOracleDataSourceDAO() throws FileNotFoundException, IOException{
       FileInputStream fichier = null; 
       
         try {
            
            
            Properties props = new Properties();
            fichier = new FileInputStream("C:\\wamp64\\www\\Projet_CPOA\\Planning_Projection\\src\\planning_projection\\dao\\oracle\\connexion.properties");
            props.load(fichier);
            props.setProperty("port", "3306");
            props.setProperty("databasename", "p1700102");
            props.setProperty("user", "p1700102");
            props.setProperty("pwd", "294150");
            props.setProperty("serveur", "iutdoua-web.univ-lyon1.fr");
            ods = new OracleDataSourceDAO();
            ods.setPortNumber(new Integer(props.getProperty("port")));
            ods.setUser(props.getProperty("user"));
            ods.setDatabaseName(props.getProperty("databasename"));
            ods.setPassword(props.getProperty("pwd"));
            ods.setServerName(props.getProperty("serveur"));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OracleDataSourceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(OracleDataSourceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                fichier.close();
            } catch (IOException ex) {
                Logger.getLogger(OracleDataSourceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        return ods;
       
      
    
    }
    
}

