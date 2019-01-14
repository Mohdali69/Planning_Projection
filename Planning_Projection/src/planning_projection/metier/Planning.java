/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Planning {
    private int numPlanning;
    private List<Projection> listeProjection = new ArrayList<>();

   
    
    public Planning(int numPlanning){
        this.numPlanning=numPlanning;
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
    
     public List<Projection> getListeProjection() {
        return listeProjection;
    }

    public void setListeProjection(List<Projection> listeProjection) {
        this.listeProjection = listeProjection;
    }
    public String toString(){
        return "Planning "+numPlanning;
    }
    
}
