/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.assets;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import planning_projection.metier.Projection;
import planning_projection.dao.oracle.OracleProjectionDAO;
import planning_projection.dao.oracle.OracleDataSourceDAO;
import planning_projection.dao.oracle.OraclePlanningDAO;
import planning_projection.metier.Planning;

/**
 *
 * @author Asus
 */
public class ListeCombo {
    
    public ListView Liste (ListView listeView,OracleProjectionDAO projection){
                List<Projection> LProjection = new ArrayList();//Création d'une Liste de Projection
                LProjection=projection.getLesProjection();
        
                for(int ta=0;ta<LProjection.size();ta++){
                    
                    System.out.println(LProjection.get(ta).toString());
                    listeView.getItems().add(LProjection.get(ta));
                    System.out.println(listeView.getItems().toString());
                }
        return listeView;
}
    public ComboBox Combo (ComboBox comboBox,OraclePlanningDAO planning){
        List<Planning> LPlanning = new ArrayList();
        LPlanning = planning.getLesPlannings();
        
        for(int tab=0;tab<LPlanning.size();tab++){
            comboBox.getItems().add(LPlanning.get(tab));
        }
       return comboBox;
    }
    
}
