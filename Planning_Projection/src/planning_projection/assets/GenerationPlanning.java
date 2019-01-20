/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planning_projection.assets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import planning_projection.dao.oracle.OracleDataSourceDAO;
import planning_projection.dao.oracle.OracleFilmDAO;
import planning_projection.dao.oracle.OraclePlanningDAO;
import planning_projection.dao.oracle.OracleProjectionDAO;
import planning_projection.metier.Film;
import planning_projection.metier.Planning;
import planning_projection.metier.Projection;

/**
 *
 * @author Admin
 */
public class GenerationPlanning {
    OracleDataSourceDAO ods ;
    OracleFilmDAO OFD = new OracleFilmDAO();
    OraclePlanningDAO OPlD = new OraclePlanningDAO();
    OracleProjectionDAO OPD = new OracleProjectionDAO();

    public GenerationPlanning() {
    }
    
    // Initialise la connexion à la base de donnée 
    public OracleFilmDAO initializeConnexionFilm(){
        try {
            ods = OracleDataSourceDAO.getOracleDataSourceDAO();
            OFD.setDataSource(ods);
            try {
                OFD.setConnection(ods.getConnection());
            } catch (SQLException ex) {
                Logger.getLogger(GenerationPlanning.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(GenerationPlanning.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return OFD;
    }
    
    public OraclePlanningDAO initializeConnexionPlanning(){
        try {
            ods = OracleDataSourceDAO.getOracleDataSourceDAO();
            OPlD.setDataSource(ods);
            try {
                OPlD.setConnection(ods.getConnection());
            } catch (SQLException ex) {
                Logger.getLogger(GenerationPlanning.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(GenerationPlanning.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return OPlD;
    }
    
    public OracleProjectionDAO initializeConnexionProjection(){
        try {
            ods = OracleDataSourceDAO.getOracleDataSourceDAO();
            OPD.setDataSource(ods);
            try {
                OFD.setConnection(ods.getConnection());
            } catch (SQLException ex) {
                Logger.getLogger(GenerationPlanning.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(GenerationPlanning.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return OPD;
    }
    
    //Algorithme Principal de la génération de planning
    public Planning generation(int numPlanning){
        Date day = new Date(119,4,13,8,0);
        
        java.sql.Date date = new java.sql.Date(day.getTime()); 
        
        List<Film> LMDay = new ArrayList<>();
        int nLM = 0;
        int nHC =0;
        int compteur = 1;
        
        List<Film> LM = new ArrayList();
        List<Film> UCR = new ArrayList();
        List<Film> HC = new ArrayList();
        List<Film> CM = new ArrayList();
        
        OFD = initializeConnexionFilm();
        LM = OFD.getLM();
        UCR = OFD.getUCR();
        HC = OFD.getHC();
        CM = OFD.getCM();
        OPD = initializeConnexionProjection();
        
        
        Random ran = new Random();
        OPlD=initializeConnexionPlanning();
        int nbPlanning = OPlD.getLesPlannings().size();
        nbPlanning *=1000;
        int i = nbPlanning;
        
        boolean test = false;
        
        for(compteur= 1; compteur<=15;compteur++){
            day.setHours(8);
            day.setMinutes(0);
            nLM = 0;
            nHC = 0;
            LMDay.clear();
            i++;
            
            if(compteur <=11){
                
                    
                
                    for(Film movie : LM){
                        
                        if(movie.getNbProjection()==0 && movie.getLendemain()==0){
                            
                            if(day.getHours()<=23 && day.getMinutes()<30){
                                String heure = day.getHours() +"h"+ day.getMinutes();
                                Projection p = new Projection(i, heure, day, numPlanning, movie.getNumFilm(), 0 ); //le numSalle des LM est 0
                                OPD.creerProjection(p);
                                day=addMin(day, movie.getDurée());
                                nLM++;
                                LMDay.add(movie);
                                movie.setNbProjection(movie.getNbProjection()+1);
                                i++;
                            }//end if 
                            
                        }//end if
                        
                        if(movie.getLendemain()==1){
                            
                            if(day.getHours()<=23 && day.getMinutes()<30){
                                String heure = day.getHours() +"h"+ day.getMinutes();
                                Projection p = new Projection(i, heure, day, numPlanning, movie.getNumFilm(), 0 );
                                OPD.creerProjection(p);
                                day = addMin(day, movie.getDurée());
                                movie.setNbProjection(movie.getNbProjection()+1);
                                movie.setLendemain(2);
                                i++;
                            }//end if
                            
                            
                        }//end if
                        
                        if(nLM>=2){
                            break;
                        }
                    }//end for
                    
                    for(Film movie : LMDay){
                        
                        if(day.getHours()<=23 && day.getMinutes()<30){
                            String heure = day.getHours() +"h"+ day.getMinutes();
                            Projection p = new Projection(i, heure, day, numPlanning, movie.getNumFilm(), 0 );
                            OPD.creerProjection(p);
                            day = addMin(day, movie.getDurée());
                            movie.setNbProjection(movie.getNbProjection()+1);
                            movie.setLendemain(1);
                            i++;
                        }//end if
                        
                    }//end for   
                //}//end while, les LM Sont placés, seances, deuxiemes séances et séance du lendemain   
            }//end if
            
            if(compteur>=2 && compteur<=11){
                
                for(Film movie : UCR){
                    
                    if(movie.getNbProjection()==0 && movie.getLendemain()==0){
                        
                        if(day.getHours()<=23 && day.getMinutes()<30){
                            
                            String heure = day.getHours() +"h"+ day.getMinutes();
                            Projection p = new Projection(i, heure, day, numPlanning, movie.getNumFilm(), 1 ); //le numSalle des UCR est 1
                            OPD.creerProjection(p);
                            day = addMin(day, movie.getDurée());
                            movie.setNbProjection(movie.getNbProjection()+1);
                            movie.setLendemain(1);
                            i++;
                            break;
                        }//end if
                        
                    }//end if
                    
                    if(movie.getLendemain()==1){
                        
                        if(day.getHours()<=23 && day.getMinutes()<30){
                            
                            String heure = day.getHours() +"h"+ day.getMinutes();
                            Projection p = new Projection(i, heure, day, numPlanning, movie.getNumFilm(), 1 ); //le numSalle des UCR est 1
                            OPD.creerProjection(p);
                            day = addMin(day, movie.getDurée());
                            movie.setNbProjection(movie.getNbProjection()+1);
                            movie.setLendemain(2);
                            i++;
                        }//end if
                        
                    }//end if
                    
                }//end for   
            }//end if les UCR sont placés, principale + lendemain
            
            if(compteur == 12){
                
                for(Film movie : CM){
                    
                    if(movie.getNbProjection()==0){
                        
                        if(day.getHours()<=23 && day.getMinutes()<30){
                            
                            String heure = day.getHours() +"h"+ day.getMinutes();
                            Projection p = new Projection(i, heure, day, numPlanning, movie.getNumFilm(), 2 ); //le numSalle des CM est 2
                            OPD.creerProjection(p);
                            day = addMin(day, movie.getDurée());
                            movie.setNbProjection(movie.getNbProjection()+1);

                            i++;
                        }// end if
                    }//end if
                    
                }// end for
                
            }//end if
            for(Film movie : HC){
                        
                        if(movie.getNbProjection()==0 && movie.getLendemain()==0){
                            
                            if(day.getHours()<=23 && day.getMinutes()<30){
                                String heure = day.getHours() +"h"+ day.getMinutes();
                                Projection p = new Projection(i, heure, day, numPlanning, movie.getNumFilm(), 0 ); //le numSalle des HC est 0
                                OPD.creerProjection(p);
                                day=addMin(day, movie.getDurée());
                                nHC++;
                                
                                movie.setNbProjection(movie.getNbProjection()+1);
                                i++;
                            }//end if 
                            
                        }//end if
                        
                        
                        
                        if(nHC>=1){
                            break;
                        }
                    }//end for
            day = addDay(day);
            
        }//end for
        return null;
    }
    
    // méthode d'ajout d'un jour à une date d
    public Date addDay(Date d){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 1);
        d =c.getTime();
        return d;
    }
    
    //methode d'ajout de min minutes a une date d
    public Date addMin(Date d, int min){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.MINUTE, min);
        d =c.getTime();
        return d;
    }
}
