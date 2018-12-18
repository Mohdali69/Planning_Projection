/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.assets;

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
   
     
    public boolean connexion(String login,String mdp,OracleUtilisateurDAO utilisateur){
        boolean con=false;//Création d'un boolean afin de tester la connexion
        List<Utilisateur> LUtilisateur = new ArrayList();//Création d'une Liste d'Utilisateur
        LUtilisateur=utilisateur.getUsers();//Liste d'Utilisateur Rempli depuis la BD (getUsers() methode qui importe les données de la BD)
        for(Utilisateur user : LUtilisateur){//Utilisation d'un foreach afin de parcourir la List 
                if(user.getUser().equals(login)){//Si ce que l'on a ecrit correspond à ce que contient la List
                    if(user.getPassword().equals(mdp)){
                        con = true;//code connexion
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
    
}
