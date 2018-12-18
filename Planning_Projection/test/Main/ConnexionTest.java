/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import planning_projection.assets.Connexion;
import planning_projection.dao.oracle.OracleDataSourceDAO;
import planning_projection.dao.oracle.OracleUtilisateurDAO;
import planning_projection.vue.FXMLDocumentController;

/**
 *
 * @author Asus
 */
public class ConnexionTest {
    String goodlogin = "test";
    String goodmdp = "test";
    String badlogin = "mauvais";
    String badmdp = "mauvais";
    
    OracleUtilisateurDAO utilisateur;
    OracleDataSourceDAO ods;
    public ConnexionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         utilisateur = new OracleUtilisateurDAO();//Création de l'Oracle Utilisateur DAO (permet de faire l'intermediaire entre la BD et l'APP) 
        try {
            ods = OracleDataSourceDAO.getOracleDataSourceDAO();// Creation du Data Source Oracle
            utilisateur.setDataSource(ods);//Initialisation du Data Source
            utilisateur.setConnection(ods.getConnection());//"
        }
        
       catch (FileNotFoundException ex) {    
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void goodallConnexion() { // Bon mdp et Bon Login
        Connexion con = new Connexion();
        boolean result = con.connexion(goodlogin,goodmdp,utilisateur);
        assertTrue(result);
    }
    @Test
    public void badallConnexion(){ // Mauvais Mdp et Mauvais Login
        Connexion con = new Connexion();
        boolean result = con.connexion(badlogin, badmdp, utilisateur);
        assertFalse(result);
    }
    @Test
    public void badloginConnexion(){ // Bon Mdp et Mauvais Login
        Connexion con = new Connexion();
        boolean result = con.connexion(goodlogin, badmdp, utilisateur);
        assertFalse(result);
    }
    @Test
    public void badmdpConnexion(){ // Mauvais Mdp et Bon Login
        Connexion con = new Connexion();
        boolean result = con.connexion(goodlogin, badmdp, utilisateur);
        assertFalse(result);
    }

}
