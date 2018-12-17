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
import java.util.Iterator;
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
            L=y1.getUsers();
            boolean connexion = false;
             
            
            /*
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
            Iterator<Utilisateur> iter;
            iter = L.iterator();
            while(iter.hasNext()){
                Utilisateur user = iter.next();
                if(user.getUser().equals(login.getText()) && user.getPassword().equals(mdp.getText())){
                    i=1;
                }
                else{
                    i=2;
                }
            }*/System.out.println(L);
            for( Utilisateur user : L){
                if(user.getUser().equals(login.getText())){
                    if(user.getPassword().equals(mdp.getText())){
                        connexion = true;//code connexion
                        message.setText("Connexion Reussie");
                    }
                    else{
                        connexion = false;//traitement erreur mdp
                        message.setText("Mauvais Mot de Passe");
                    }
                }
                else{
                    connexion = false;//traitement erreur login 
                    message.setText("Mauvais Login");
                }
            }
            System.out.println("Im here");
            
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
