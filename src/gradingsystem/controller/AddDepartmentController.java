package gradingsystem.controller;

import gradingsystem.Entities.Departement;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Hossam
 */
public class AddDepartmentController {
    public static String addDepartment(String name, String description){
        Departement d = new Departement(name, description);
        return d.getName();
    }
}
