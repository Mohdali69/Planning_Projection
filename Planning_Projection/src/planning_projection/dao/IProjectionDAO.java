/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.dao;

import java.sql.Connection;
import java.util.List;
import planning_projection.metier.Projection;


/**
 *
 * @author Mohamed
 */
public interface IProjectionDAO {
    public void setConnection(Connection c);
    
    public void setDataSource(javax.sql.DataSource ds);
    
    public List<Projection> getLesProjection();
    
    public void creerProjection(Projection Projection);
    
    public void supprimerAdministratif(Projection Projection);
}
