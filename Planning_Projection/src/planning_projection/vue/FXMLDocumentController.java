/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.vue;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import planning_projection.dao.oracle.OracleDataSourceDAO;
import planning_projection.metier.Projection;
import planning_projection.metier.Utilisateur;
import planning_projection.dao.oracle.OracleUtilisateurDAO;
import planning_projection.dao.oracle.OraclePlanningDAO;
/**
 *
 * @author Asus
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private Button button;
    @FXML
    private TextField login;
    @FXML
    private TextField mdp;
    @FXML
    private Label message;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        OracleUtilisateurDAO y1 = new OracleUtilisateurDAO();
        OracleDataSourceDAO ods;
        List<Utilisateur> L = new ArrayList();
        try {
            ods = OracleDataSourceDAO.getOracleDataSourceDAO();
            y1.setDataSource(ods);
            y1.setConnection(ods.getConnection());
            L=y1.getUser();
            int i=1;
            boolean l =false ;
            System.out.println("Im here");
            
            while(i<=L.size()){
                if(login.getText().equals(L.get(i).getUser()) && mdp.getText().equals(L.get(i).getPassword())){
                    l=true;
                    i=L.size();
                    
                }
                else{
                    i++;
                    System.out.println(L.get(i).getUser());
                }
            }
            
            if(l==true){
                message.setText("Vous avez les bon id");
            }
            else if(l==false){
                message.setText("Veuillez Verifié vos Identifiants");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
