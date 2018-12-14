package gradingsystem.controller;

import gradingsystem.Entities.Departement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Hossam
 */


public class DisplayDepartmentController {
    static public DefaultListModel getDepartmentsNames(){
        DefaultListModel noIdea = new DefaultListModel();
        ArrayList<Departement> ds = Departement.getDepartements();
        for(int i=0; i<ds.size(); i++){
            noIdea.addElement(ds.get(i).getName());
        }
        return noIdea;
    }
    
    
    static public String[] getDepartmentInfo(int i){
        
        Departement d =  Departement.getDepartements().get(i);
        String[] str = new String[2];
        str[0] = d.getName();
        str[1] = d.getDescription();
        return str;
    }
    
}
