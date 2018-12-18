/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.vue;

import java.io.FileNotFoundException;
import static java.lang.Thread.sleep;
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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import planning_projection.dao.oracle.OracleDataSourceDAO;
import planning_projection.metier.Projection;   
import planning_projection.metier.Utilisateur;
import planning_projection.dao.oracle.OracleUtilisateurDAO;
import planning_projection.dao.oracle.OracleProjectionDAO;
import planning_projection.assets.Connexion;
/**
 *
 * @author Asus
 */
public class FXMLDocumentController implements Initializable {
    
    private OracleUtilisateurDAO utilisateur;
    private OracleDataSourceDAO ods;
    @FXML
    private Button button;
    @FXML
    private TextField login;
    @FXML
    private TextField mdp;
    @FXML
    private Label message;
    @FXML
    private AnchorPane connexionPanel;
    @FXML
    private Pane ConnexionPane;
    @FXML
    private ProgressBar ProgessBar;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, InterruptedException {
            boolean log= false;
            Connexion con = new Connexion();
            System.out.println("ZOB");
            log = con.connexion(login.getText(),mdp.getText(),utilisateur);
            if(log==true){
                ProgessBar.setProgress(50);
                sleep(2000,2);
                ProgessBar.setProgress(100);
                sleep(1000,2);
                connexionPanel.setVisible(true);
                ConnexionPane.setVisible(false);
            }
            else{
                message.setText("Veuillez Verifier vos Ids");
            }
             
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }/*
    public boolean connexion(String login,String mdp){
        boolean con=false;//Création d'un boolean afin de tester la connexion
        List<Utilisateur> LUtilisateur = new ArrayList();//Création d'une Liste d'Utilisateur
        LUtilisateur=utilisateur.getUsers();//Liste d'Utilisateur Rempli depuis la BD (getUsers() methode qui importe les données de la BD)
        for(Utilisateur user : LUtilisateur){//Utilisation d'un foreach afin de parcourir la List 
                if(user.getUser().equals(login)){//Si ce que l'on a ecrit correspond à ce que contient la List
                    if(user.getPassword().equals(mdp)){
                        con = true;//code connexion
                        message.setText("Connexion Reussie");
                        connexionPanel.setVisible(false);
                    }
                    else{//Sinon 
                        con = false;//traitement erreur mdp
                        message.setText("Mauvais Mot de Passe");
                    }
                }
                else{
                    con = false;//traitement erreur login 
                    message.setText("Mauvais Login");
                }
            }
        return con;
    }
*/
}
