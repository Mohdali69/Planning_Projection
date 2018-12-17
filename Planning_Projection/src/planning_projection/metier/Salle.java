/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.metier;

/**
 *
 * @author Asus
 */
public class Salle {
    private String nom;
    private int places;
    private int numSalle;
    
    public Salle(String nom,int places,int numSalle){
        this.nom=nom;
        this.numSalle=numSalle;
        this.places=places;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the places
     */
    public int getPlaces() {
        return places;
    }

    /**
     * @param places the places to set
     */
    public void setPlaces(int places) {
        this.places = places;
    }

    /**
     * @return the numSalle
     */
    public int getNumSalle() {
        return numSalle;
    }

    /**
     * @param numSalle the numSalle to set
     */
    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }
    
}
