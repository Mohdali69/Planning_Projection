/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.metier;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Projection {
    private String heures;
    private int numProjection;
    private Date date = new Date();
           
    public Projection(int numProjection,String heures,Date date){
        this.numProjection=numProjection;
        this.heures=heures;
        this.date=date;
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
   
}
