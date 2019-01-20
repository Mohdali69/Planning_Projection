/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import planning_projection.assets.ListeCombo;
import planning_projection.dao.oracle.OracleDataSourceDAO;
import planning_projection.dao.oracle.OracleFilmDAO;
import planning_projection.dao.oracle.OracleProjectionDAO;
import planning_projection.dao.oracle.OracleSalleDAO;
import planning_projection.metier.Film;
import planning_projection.metier.Projection;
import planning_projection.metier.Salle;
import planning_projection.vue.FXMLDocumentController;

/**
 *
 * @author Asus
 */
public class SalleTest {
    
    OracleDataSourceDAO ods;
    OracleSalleDAO salle;
    public SalleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        salle = new OracleSalleDAO();
        try{
            ods = OracleDataSourceDAO.getOracleDataSourceDAO();
            salle.setDataSource(ods);
            salle.setConnection(ods.getConnection());
        }catch (FileNotFoundException | SQLException ex) {
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
    public void Allgood() {
        List<Salle> LSalle = new ArrayList();
        LSalle=salle.getLesSalles();
        List<Salle> LSalle2 = new ArrayList();        
        assertEquals(LSalle.size(),5);
    }
    @Test
    public void Allbad() {
        List<Salle> LSalle = new ArrayList();
        LSalle=salle.getLesSalles();
        List<Salle> LSalle2 = new ArrayList();        
        assertThat(LSalle.size(),not(equalTo(0)));
    }
}
