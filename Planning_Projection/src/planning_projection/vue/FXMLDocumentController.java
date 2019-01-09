/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.vue;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import planning_projection.dao.oracle.OracleDataSourceDAO;
import planning_projection.metier.Projection;   
import planning_projection.metier.Utilisateur;
import planning_projection.dao.oracle.OracleUtilisateurDAO;
import planning_projection.dao.oracle.OracleProjectionDAO;
import planning_projection.assets.Connexion;
import planning_projection.assets.ListeCombo;
import planning_projection.dao.oracle.OraclePlanningDAO;
import planning_projection.metier.Planning;
/**
 *
 * @author Asus
 */
public class FXMLDocumentController implements Initializable {
    
    private OracleUtilisateurDAO utilisateur;
    private OracleProjectionDAO projection;
    private OraclePlanningDAO planning ;
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
    private Pane AccueilPane;
    @FXML
    private Button buttonPlanning;
    @FXML
    private Button buttonProjection;
    @FXML
    private ProgressIndicator progressBar;
    @FXML
    private ComboBox<Planning> comboBox;
    @FXML
    private ListView<Projection> listeView;
    @FXML
    private Button afficheButton;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, InterruptedException {
            boolean log= false;
            progressBar.setProgress(0);
            Connexion con = new Connexion();
            ListeCombo LC = new ListeCombo();
            log = con.connexion(login.getText(),mdp.getText(),utilisateur);
            double i=0.0;
            
            if(log==true){
                while(i<10){
                    progressBar.setProgress(i/10);
                    sleep(50,5);
                    i+=1;
                }
                
                connexionPanel.setVisible(true);
                ConnexionPane.setVisible(false);
                AccueilPane.setVisible(true);


                
                comboBox= LC.Combo(comboBox, planning);
               

            }
            else{
                message.setText("Veuillez Verifier vos Ids");
            }
            
             
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AccueilPane.setVisible(false);
        utilisateur = new OracleUtilisateurDAO();//Création de l'Oracle Utilisateur DAO (permet de faire l'intermediaire entre la BD et l'APP) 
        projection = new OracleProjectionDAO();//Création de l'Oracle Projection DAO 
        planning = new OraclePlanningDAO();
        try {
            ods = OracleDataSourceDAO.getOracleDataSourceDAO();// Creation du Data Source Oracle
            utilisateur.setDataSource(ods);//Initialisation du Data Source
            utilisateur.setConnection(ods.getConnection());//
            projection.setDataSource(ods);
            projection.setConnection(ods.getConnection());
            planning.setDataSource(ods);
            planning.setConnection(ods.getConnection());
            
        }
        
       catch (FileNotFoundException ex) {    
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    /*
   
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

    @FXML
    private void choixComboBox(ActionEvent event) {
        
        
    }

    @FXML
    private void buttonTestList(ActionEvent event) {
        
    }

    @FXML
    private void buttonAfficheAction(ActionEvent event) {
        
        listeView.getItems().remove(0, listeView.getItems().size());
        int i=0;
        
        List<Projection> LProjection = new ArrayList();//Création d'une Liste de Projection
        LProjection=projection.getLesProjection();
        
            
            for(int t=0;t<LProjection.size();t++){
                
                if(LProjection.get(t).getNumPlanning()==comboBox.getSelectionModel().getSelectedItem().getNumPlanning()){
                    
                   listeView.getItems().add(LProjection.get(t));
                
                }
            }    
            
        
        
    }
}
