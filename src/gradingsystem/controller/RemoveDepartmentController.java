package gradingsystem.controller;

import gradingsystem.Entities.Departement;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Hossam
 */

public class RemoveDepartmentController {
    public static void removeDepartment(int selectedIndex){
        Departement d = Departement.getDepartements().get(selectedIndex);
        d.removeDepartment();
    }
}
