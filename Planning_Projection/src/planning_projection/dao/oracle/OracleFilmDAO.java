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
              rset = stmt.executeQuery("SELECT * from FILM");
              while(rset.next()){
                Film film = new Film(rset.getString("titre"), rset.getInt("durée"),rset.getString("realisateur"),rset.getString("pays"),rset.getInt("nbProjection"),rset.getInt("lendemain"),rset.getInt("numFilm"));
                listeFilm.add(film);
            }
            }catch(SQLException ex){
             Logger.getLogger(OracleFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        
        return listeFilm ;
        
        
        
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
