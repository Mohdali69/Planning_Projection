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
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import planning_projection.dao.oracle.OracleDataSourceDAO;
import planning_projection.metier.Projection;   
import planning_projection.metier.Utilisateur;
import planning_projection.dao.oracle.OracleUtilisateurDAO;
import planning_projection.dao.oracle.OracleProjectionDAO;
import planning_projection.assets.Connexion;
import planning_projection.assets.GenerationPlanning;
import planning_projection.assets.ListeCombo;
import planning_projection.dao.oracle.OracleFilmDAO;
import planning_projection.dao.oracle.OraclePlanningDAO;
import planning_projection.dao.oracle.OracleSalleDAO;
import planning_projection.metier.Film;
import planning_projection.metier.Planning;
import planning_projection.metier.Salle;
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
    private Pane ProjectionPane;
    private OracleFilmDAO film;
    private OracleSalleDAO salle;
    @FXML
    private Button afficherProjectionButton;
    @FXML
    private Label filmLabelNom;
    @FXML
    private Label filmLabelDurée;
    @FXML
    private Label filmLabelRealisateur;
    @FXML
    private Label filmLabelPays;
    @FXML
    private Label filmLabelCompet;
    @FXML
    private Label salleLabelNom;
    @FXML
    private Label salleLabelNum;
    @FXML
    private Label salleLabelPlaces;
    @FXML
    private Button buttonSuppromer;
    @FXML
    private ImageView buttonDeconnexion;
    @FXML
    private Rectangle rectangle;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, InterruptedException {
            boolean log= false;
            progressBar.setProgress(0);
            Connexion con = new Connexion();
            ListeCombo LC = new ListeCombo();
            log = con.connexion(login.getText(),mdp.getText(),utilisateur);
            double i=0.0;
            
            if(log==true){
                while(i<=10){
                    progressBar.setProgress(i/10);
                    sleep(50,5);
                    i+=1;
                }
                
                makeFadeOutCon();
                
                

                
                comboBox= LC.Combo(comboBox, planning);
               

            }
            else{
                message.setText("Veuillez Verifier vos Ids");
            }
            
             
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ProjectionPane.setVisible(false);
        AccueilPane.setVisible(false);
        film = new OracleFilmDAO();
        utilisateur = new OracleUtilisateurDAO();//Création de l'Oracle Utilisateur DAO (permet de faire l'intermediaire entre la BD et l'APP) 
        projection = new OracleProjectionDAO();//Création de l'Oracle Projection DAO 
        planning = new OraclePlanningDAO();
        salle = new OracleSalleDAO();
        try {
            ods = OracleDataSourceDAO.getOracleDataSourceDAO();// Creation du Data Source Oracle
            utilisateur.setDataSource(ods);//Initialisation du Data Source
            utilisateur.setConnection(ods.getConnection());//
            projection.setDataSource(ods);
            projection.setConnection(ods.getConnection());
            planning.setDataSource(ods);
            planning.setConnection(ods.getConnection());
            film.setDataSource(ods);
            film.setConnection(ods.getConnection());
            salle.setDataSource(ods);
            salle.setConnection(ods.getConnection());
        }
        
       catch (FileNotFoundException ex) {    
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
  

    @FXML
    private void choixComboBox(ActionEvent event) {
        
        
    }

    @FXML
    private void buttonTestList(ActionEvent event) {
        GenerationPlanning GP = new GenerationPlanning();
        GP.generation(0);
    }

    @FXML
    private void buttonAfficheAction(ActionEvent event) {
        
        listeView.getItems().remove(0, listeView.getItems().size());
        int i=0;
        
        List<Projection> LProjection = new ArrayList();//Création d'une Liste de Projection
        LProjection=projection.getLesProjection();
        //List<Film> LFilm = new ArrayList();
        //LFilm = film.getLesFilms();
        
            
            for(int t=0;t<LProjection.size();t++){
                
                if(LProjection.get(t).getNumPlanning()==comboBox.getSelectionModel().getSelectedItem().getNumPlanning()){
                   //if(LProjection.get(t).getNumFilm()==LFilm.get(t).getNumFilm()){
                       listeView.getItems().add(LProjection.get(t));
                   //}
                }
            }    
            
        
        
    }
    public void makeFadeOutCon() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(ConnexionPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadAccueilPane();
            }
        });
        fadeTransition.play();
        
        
       
    }
        public void loadAccueilPane() {
            AccueilPane.setVisible(true);
            ConnexionPane.setVisible(false);
        }
        
       public void makeFadeOutProjection(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(AccueilPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadProjectionPane();
            }
        });
        fadeTransition.play();
        
           
       }
       
       public void loadProjectionPane(){ 
           ProjectionPane.setVisible(true);
           ConnexionPane.setVisible(false);
        }
       public void makeFadeOutDeco(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(AccueilPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadDecoPane();
            }
        });
        fadeTransition.play();
        
           
       }
       public void loadDecoPane(){
           AccueilPane.setVisible(false);
           ConnexionPane.setVisible(true);
        }

    @FXML
    private void buttonProjectionAction(ActionEvent event) {
        makeFadeOutProjection();
    }

    @FXML
    private void ListClicked(MouseEvent event) {
        List<Film> LFilm = new ArrayList();
        LFilm = film.getLesFilms();
        List<Salle> LSalle = new ArrayList();
        LSalle = salle.getLesSalles();
        
        for(int j=0;j<LFilm.size();j++){
            if(LFilm.get(j).getNumFilm()==listeView.getSelectionModel().getSelectedItem().getNumFilm()){
                filmLabelNom.setText(LFilm.get(j).getTitre());
                filmLabelDurée.setText(Integer.toString(LFilm.get(j).getDurée()));
                filmLabelRealisateur.setText(LFilm.get(j).getRealisateur());
                filmLabelPays.setText(LFilm.get(j).getPays());
                filmLabelCompet.setText(LFilm.get(j).getCompetition());
            }
            
        }
        for(int j=0;j<LSalle.size();j++){
           if(LSalle.get(j).getNumSalle()==listeView.getSelectionModel().getSelectedItem().getNumSalle()){
                salleLabelNom.setText(LSalle.get(j).getNom());
                salleLabelNum.setText(Integer.toString(LSalle.get(j).getNumSalle()));
                salleLabelPlaces.setText(Integer.toString(LSalle.get(j).getPlaces()));
            } 
        }
    }

    @FXML
    private void buttonSupprimerProjection(ActionEvent event) {
        projection.supprimerAdministratif(listeView.getSelectionModel().getSelectedItem());
        buttonAfficheAction(event);
        
    }

    @FXML
    private void buttonDeconnexion(MouseEvent event) {
        makeFadeOutDeco();
    }
    
}
