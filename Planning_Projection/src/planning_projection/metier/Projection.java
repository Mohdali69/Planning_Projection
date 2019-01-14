/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.metier;

import java.util.Date;
import planning_projection.metier.Film;
/**
 *
 * @author Asus
 */
public class Projection {
    private String heures;
    private int numProjection;
    private Date date;
    private int numPlanning;
    private int numFilm;
    private int numSalle;
    private Film film;
    
           
    public Projection(int numProjection,String heures,Date date,int numPlanning,int numFilm, int numSalle){
        this.numProjection=numProjection;
        this.heures=heures;
        this.date=date;
        this.numFilm=numFilm;
        this.numPlanning=numPlanning;
        this.numSalle=numSalle;
    }

    /**
     * @return the heures
     */
    public String getHeures() {
        return heures;
    }

    /**
     * @param heures the heures to set
     */
    public void setHeures(String heures) {
        this.heures = heures;
    }

    /**
     * @return the numProjection
     */
    public int getNumProjection() {
        return numProjection;
    }
    @Override
    public String toString(){
        
        return "Date :" + date +"\n"+"Heure :" + heures +"\n"+"NumProjection :"+numProjection +"\n"+ "NumPlanning :" + numPlanning +"\n" +"NumFilm :" + numFilm + "\n Salle : " + this.numSalle+"\n";
    }

    /**
     * @param numProjection the numProjection to set
     */
    public void setNumProjection(int numProjection) {
        this.numProjection = numProjection;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }
    /**
     * @return the numPlanning
     */
    public int getNumPlanning() {
        return numPlanning;
    }

    /**
     * @param numPlanning the numPlanning to set
     */
    public void setNumPlanning(int numPlanning) {
        this.numPlanning = numPlanning;
    }

    /**
     * @return the numFilm
     */
    public int getNumFilm() {
        return numFilm;
    }

    /**
     * @param numFilm the numFilm to set
     */
    public void setNumFilm(int numFilm) {
        this.numFilm = numFilm;
    }
   
}
