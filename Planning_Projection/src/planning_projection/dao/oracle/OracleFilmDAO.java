/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.dao.oracle;

import java.sql.CallableStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import planning_projection.dao.IFilmDAO;
import planning_projection.metier.Film;

/**
 *
 * @author Mohamed
 */
public class OracleFilmDAO implements IFilmDAO{
    private static DataSource ds; 
    private static Connection connexionBD;
    
    @Override
    public void setDataSource(DataSource ds){
        OracleFilmDAO.ds = ds; 
    }
    
    @Override
    public void setConnection (Connection c) {
        OracleFilmDAO.connexionBD = c;
    }
   
    
    @Override 
    public List<Film> getLesFilms() {
        ResultSet rset = null; 
        Statement stmt = null;
        List<Film> listeFilm = null; 
        try {
              stmt= connexionBD.createStatement();
              listeFilm = new ArrayList<>();
              rset = stmt.executeQuery("SELECT * from Film");
              while(rset.next()){
                Film film = new Film(rset.getString("titre"), rset.getInt("duree"),rset.getString("realisateur"),rset.getString("pays"),rset.getString("competition"),rset.getInt("nbProjections"),rset.getInt("lendemain"),rset.getInt("numFilm"));
                listeFilm.add(film);
            }
            }catch(SQLException ex){
             Logger.getLogger(OracleFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        
        return listeFilm ;   
    }
    
    public List<Film> getLM() {
        ResultSet rset = null; 
        Statement stmt = null;
        List<Film> listeLM = null; 
        try {
              stmt= connexionBD.createStatement();
              listeLM = new ArrayList<>();
              rset = stmt.executeQuery("SELECT * from Film where competition = 'Long-metrage'");
              while(rset.next()){
                Film film = new Film(rset.getString("titre"), rset.getInt("duree"),rset.getString("realisateur"),rset.getString("pays"),rset.getString("competition"),rset.getInt("nbProjections"),rset.getInt("lendemain"),rset.getInt("numFilm"));
                listeLM.add(film);
            }
            }catch(SQLException ex){
             Logger.getLogger(OracleFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        
        return listeLM ;  
    }
    
    public List<Film> getUCR() {
        ResultSet rset = null; 
        Statement stmt = null;
        List<Film> listeUCR = null; 
        try {
              stmt= connexionBD.createStatement();
              listeUCR= new ArrayList<>();
              rset = stmt.executeQuery("SELECT * from Film where competition = 'UCR'");
              while(rset.next()){
                Film film = new Film(rset.getString("titre"), rset.getInt("duree"),rset.getString("realisateur"),rset.getString("pays"),rset.getString("competition"),rset.getInt("nbProjections"),rset.getInt("lendemain"),rset.getInt("numFilm"));
                listeUCR.add(film);
            }
            }catch(SQLException ex){
             Logger.getLogger(OracleFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        
        return listeUCR ;
    }
    
    public List<Film> getHC() {
        ResultSet rset = null; 
        Statement stmt = null;
        List<Film> listeLM = null; 
        try {
              stmt= connexionBD.createStatement();
              listeLM = new ArrayList<>();
              rset = stmt.executeQuery("SELECT * from Film where competition = 'Hors-Competition'");
              while(rset.next()){
                Film film = new Film(rset.getString("titre"), rset.getInt("duree"),rset.getString("realisateur"),rset.getString("pays"),rset.getString("competition"),rset.getInt("nbProjections"),rset.getInt("lendemain"),rset.getInt("numFilm"));
                listeLM.add(film);
            }
            }catch(SQLException ex){
             Logger.getLogger(OracleFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        
        return listeLM ;  
    }

    public List<Film> getCM() {
        ResultSet rset = null; 
        Statement stmt = null;
        List<Film> listeCM = null; 
        try {
              stmt= connexionBD.createStatement();
              listeCM = new ArrayList<>();
              rset = stmt.executeQuery("SELECT * from Film where competition = 'Court-metrage'");
              while(rset.next()){
                Film film = new Film(rset.getString("titre"), rset.getInt("duree"),rset.getString("realisateur"),rset.getString("pays"),rset.getString("competition"),rset.getInt("nbProjections"),rset.getInt("lendemain"),rset.getInt("numFilm"));
                listeCM.add(film);
            }
            }catch(SQLException ex){
             Logger.getLogger(OracleFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        
        return listeCM ;
    }

   
   public int procedure() throws SQLException{
       String sql = "{? = call nombre_bus";
       CallableStatement state = connexionBD.prepareCall(sql);
       state.registerOutParameter(1,Types.INTEGER);
       state.execute();
       int resultat = state.getInt(1);
       return resultat;
   }
    
    
}
