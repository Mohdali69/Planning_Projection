/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.dao;

import java.sql.Connection;
import java.util.List;
import planning_projection.metier.Utilisateur;

/**
 *
 * @author Asus
 */
public interface IUtilisateurDAO {
    
    public void setConnection(Connection c);
    
    public void setDataSource(javax.sql.DataSource ds);
    
    public List<Utilisateur> getUser();
    
}
