/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.vue;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

    private ListeCombo LC;
    @FXML
    private ImageView buttonRetour;
    @FXML
    private ListView<Film> ListeFilm;
    @FXML
    private ListView<Salle> ListeSalle;
    private TextField textDate;
    @FXML
    private TextField textHeure;
    @FXML
    private Button Raf;
    @FXML
    private ComboBox<Planning> comboBoxPane2;
    @FXML
    private TextField textJour;
    @FXML
    private Label labelok;
    @FXML
    private TextField textMois;
    @FXML
    private TextField textAnnee;

    @FXML
    private ImageView buttonDeco;



    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, InterruptedException {
        //Test de la Connexion
            boolean log= false;
            progressBar.setProgress(0);
            Connexion con = new Connexion();
            LC= new ListeCombo();
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
        // Initialisation des divers DAO et des Panels
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
            ListeCombo LC2 =new ListeCombo();
            comboBoxPane2 = LC2.Combo(comboBoxPane2, planning);
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
        //Genère un Planning à Partir d'une methode prédéfinie
        comboBox.getItems().remove(0, planning.getLesPlannings().size());
        Planning p = new Planning(planning.getLesPlannings().size());
        planning.creerPlanning(p);
        
        comboBox= LC.Combo(comboBox, planning);
        //La Methode prédéfinie
        GenerationPlanning GP = new GenerationPlanning();
        GP.generation(p.getNumPlanning());
    }

    @FXML
    private void buttonAfficheAction(ActionEvent event) {
        //Affiche les Projection en Fonction du Planning Choisis
        listeView.getItems().remove(0, listeView.getItems().size());
        int i=0;
        
        List<Projection> LProjection = new ArrayList();//Création d'une Liste de Projection
        LProjection=projection.getLesProjection();
        
        
            
            for(int t=0;t<LProjection.size();t++){
                //Si le Planning Choisis Correspond au Planning de la Projection alors il l'ajoute à la ListeView
                if(LProjection.get(t).getNumPlanning()==comboBox.getSelectionModel().getSelectedItem().getNumPlanning()){
                   
                       listeView.getItems().add(LProjection.get(t));
                 
                }
            }    
            
        
        
    }
    //Animation de la Connection
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
            AccueilPane.setOpacity(1);
            ConnexionPane.setOpacity(0);
            ProjectionPane.setOpacity(0);
        }
       //Animation de l'Accueil 
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
       //Animation de la Projection
       public void makeFadeOutPro(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(ProjectionPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadProjection();
            }
        });
        fadeTransition.play();
        
           
       }
       
       public void loadProjectionPane(){ 
           ProjectionPane.setVisible(true);
           ProjectionPane.setOpacity(1);
           ConnexionPane.setOpacity(0);
        }
       public void loadProjection(){ 
           
           AccueilPane.setOpacity(1);
           ProjectionPane.setOpacity(0);
           ConnexionPane.setOpacity(0);
           ProjectionPane.setVisible(false);
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
       //Affichage du Pannel Connexion
       public void loadDecoPane(){
           
           AccueilPane.setOpacity(0);
           ConnexionPane.setOpacity(1);
           ProjectionPane.setOpacity(0);
           AccueilPane.setVisible(false);
           progressBar.setProgress(0);
           login.setText("");
           mdp.setText("");
        }

    @FXML
    private void buttonProjectionAction(ActionEvent event) {
        //Appel de la Transition Accueil et Projection
        makeFadeOutProjection();
        comboBoxPane2.getItems().remove(0, comboBoxPane2.getItems().size());
        ListeCombo LC2 =new ListeCombo();
        comboBoxPane2 = LC2.Combo(comboBoxPane2, planning);
        rafraichirListes(event);
        
    }

    @FXML
    private void ListClicked(MouseEvent event) {
        //Lorsque l'on Click dans la ListView nous donne le Film et La Salle Correspondant
        List<Film> LFilm = new ArrayList();
        LFilm = film.getLesFilms();
        List<Salle> LSalle = new ArrayList();
        LSalle = salle.getLesSalles();
        //Affiche le Film Choisis
        for(int j=0;j<LFilm.size();j++){
            if(LFilm.get(j).getNumFilm()==listeView.getSelectionModel().getSelectedItem().getNumFilm()){
                filmLabelNom.setText(LFilm.get(j).getTitre());
                filmLabelDurée.setText(Integer.toString(LFilm.get(j).getDurée()));
                filmLabelRealisateur.setText(LFilm.get(j).getRealisateur());
                filmLabelPays.setText(LFilm.get(j).getPays());
                filmLabelCompet.setText(LFilm.get(j).getCompetition());
            }
            
        }
        //Affiche la Salle Choisis 
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
        //Supprime une Projection de la BD et Rafraichi la ListeView
        projection.supprimerAdministratif(listeView.getSelectionModel().getSelectedItem());
        buttonAfficheAction(event);
        
    }

    @FXML
    private void buttonDeconnexion(MouseEvent event) {
        //Appel la Transition entre le Panel Accueil et Login
        makeFadeOutDeco();
    }

    @FXML
    private void buttonRetourAffiche(MouseEvent event) {
        //Appel la Transition entre le Panel Projection et Accueil
        makeFadeOutPro();
    }

    @FXML
    private boolean buttonEntrezAction(ActionEvent event) {
        List<Projection> listeP = projection.getLesProjection(comboBoxPane2.getSelectionModel().getSelectedItem());
        List<Film> listeF = film.getLesFilms();
        Salle salle = ListeSalle.getSelectionModel().getSelectedItem();
        int duree=0;
        int jour;
        Date d;
        String heure;
        int mois ;
        int annee;
        String Jheure = textHeure.getText()+"h0";
        Date day = new Date(119,Integer.parseInt(textMois.getText())-1,Integer.parseInt(textJour.getText()));
        for(int k = 0; k<listeP.size(); k++){
            d = listeP.get(k).getDate();
            
            heure = listeP.get(k).getHeures(); //format HHhMM
            jour = d.getDay(); //format JJ
            mois = d.getMonth(); // format MM
            annee = d.getYear(); // format YYYY
            
            if(day.equals(d) && Jheure.equals(heure) && salle.getNumSalle()==listeP.get(k).getNumSalle()){
                
                labelok.setText("La projection ne peut être ajoutée, vérification des contraintes échouée.");
                return false;
                
            }
           
        }
        
        
        java.sql.Date date = new java.sql.Date(day.getTime()); 
        int nbPlanning = (comboBoxPane2.getSelectionModel().getSelectedItem().getNumPlanning()+1)*1000;
        nbPlanning += listeP.size()+1;
        Projection pro = new Projection(nbPlanning,Jheure,date,comboBoxPane2.getSelectionModel().getSelectedItem().getNumPlanning(),ListeFilm.getSelectionModel().getSelectedItem().getNumFilm(),ListeSalle.getSelectionModel().getSelectedItem().getNumSalle());
        projection.creerProjection(pro);
        return true;
        
    }

    @FXML
    private void rafraichirListes(ActionEvent event) {
        
        //Appel la methode ListeCombo qui rempli la ComboBox depuis la BD
        ListeCombo LC2 = new ListeCombo();
        
        //comboBoxPane2 = LC2.Combo(comboBoxPane2, planning);
        
         //Suppression à chaque fois que l'on appuie sur le button (pas avoir de doublon)
        ListeFilm.getItems().remove(0, ListeFilm.getItems().size());
        ListeSalle.getItems().remove(0, ListeSalle.getItems().size());
        
        List<Film> LFilm = new ArrayList();//Création d'une Liste de Film
        LFilm=film.getLesFilms();//Import de la BD 
        List<Salle> LSalle = new ArrayList();//Création d'une Liste de Salle
        LSalle=salle.getLesSalles();//Import de la BD 
        
        //Remplis la ListeView de Film depuis la BD
        for(int ta=0;ta<LFilm.size();ta++){
            
             ListeFilm.getItems().add(LFilm.get(ta));
        }
        //Remplis l'autre ListeView de Salle depuis la BD
        for(int to=0;to<LSalle.size();to++){
            ListeSalle.getItems().add(LSalle.get(to));
        }
        
    }
    
}
