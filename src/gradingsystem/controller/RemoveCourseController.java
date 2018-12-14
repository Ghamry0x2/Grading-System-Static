package gradingsystem.controller;

import gradingsystem.Entities.Departement;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Hossam
 */

public class RemoveCourseController {
    public static void removeCourse(int selectedDept, int selectedCourse){
        Departement d = Departement.getDepartements().get(selectedDept);
        d.removeCourse(selectedCourse);
    }
}
