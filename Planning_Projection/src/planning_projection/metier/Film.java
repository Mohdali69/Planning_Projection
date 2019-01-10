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
public class Film {
    private String titre;
    private int durée;
    private String realisateur;
    private String pays;
    private String competition;
    private int nbProjection;
    private int lendemain;
    private int numFilm;
    
    public Film(String titre,int durée,String realisateur,String pays,String comp,int nbProjection,int lendemain,int numFilm){
        this.titre=titre;
        this.realisateur=realisateur;
        this.durée=durée;
        this.lendemain=lendemain;
        this.numFilm=numFilm;
        this.nbProjection=nbProjection;
        this.competition = comp;
        this.pays=pays;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the durée
     */
    public int getDurée() {
        return durée;
    }

    /**
     * @param durée the durée to set
     */
    public void setDurée(int durée) {
        this.durée = durée;
    }

    /**
     * @return the realisateur
     */
    public String getRealisateur() {
        return realisateur;
    }

    /**
     * @param realisateur the realisateur to set
     */
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    /**
     * @return the pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * @param pays the pays to set
     */
    public void setPays(String pays) {
        this.pays = pays;
    }

    /**
     * @return the competition
     */
    public String getCompetition() {
        return competition;
    }

    /**
     * @param competition the competition to set
     */
    public void setCompetition(String competition) {
        this.competition = competition;
    }

    /**
     * @return the nbProjection
     */
    public int getNbProjection() {
        return nbProjection;
    }

    /**
     * @param nbProjection the nbProjection to set
     */
    public void setNbProjection(int nbProjection) {
        this.nbProjection = nbProjection;
    }

    /**
     * @return the lendemain
     */
    public int getLendemain() {
        return lendemain;
    }

    /**
     * @param lendemain the lendemain to set
     */
    public void setLendemain(int lendemain) {
        this.lendemain = lendemain;
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
