package planning_projection.assets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import planning_projection.dao.oracle.OracleDataSourceDAO;
import planning_projection.metier.Utilisateur;
import planning_projection.dao.oracle.OracleUtilisateurDAO;
import planning_projection.vue.FXMLDocumentController;
/**
 *
 * @author Asus
 */

public class Connexion {
   
     //Methode qui permet de voir si nos id sont les bons et nous authentifie
    public boolean connexion(String login,String mdp,OracleUtilisateurDAO utilisateur){
        boolean con=false;//Création d'un boolean afin de tester la connexion
        List<Utilisateur> LUtilisateur = new ArrayList();//Création d'une Liste d'Utilisateur
        LUtilisateur=utilisateur.getUsers();//Liste d'Utilisateur Rempli depuis la BD (getUsers() methode qui importe les données de la BD)
        for(Utilisateur user : LUtilisateur){//Utilisation d'un foreach afin de parcourir la List 
                if(user.getUser().equals(login)){//Si ce que l'on a ecrit correspond à ce que contient la List
                    if(user.getPassword().equals(mdp)){
                        con = true;//code connexion
                        return con;
                    }
                    else{//Sinon 
                        con = false;//traitement erreur mdp
                    }
                }
                else{
                    con = false;//traitement erreur login 
                }
            }
        return con;
    }
    
    public static void affichePage(String urlName, String execDir)
      {
         try
         {
            Runtime r = Runtime.getRuntime();
            r.exec(execDir + " " + urlName);  // le lien est dans urlName
         }
            catch(FileNotFoundException fnfe) // si nom appli ( ici IE ) non trouvé
            {
               String info = execDir + "(fnfe)  non trouvé !!!";
               javax.swing.JOptionPane.showMessageDialog(null,info);
            }
            catch(IOException ioe)
            {
               String info = execDir 
                  + ioe;
               javax.swing.JOptionPane.showMessageDialog(null,info);
            }
      }
    
}
