package gradingsystem.controller;

import gradingsystem.Entities.Course;
import gradingsystem.Entities.Departement;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Hossam
 */

public class AddCourseController {

    public static String addCourse(String CourseName, int departmentIndex){
        Course c = new Course(CourseName);
        Departement d = Departement.getDepartements().get(departmentIndex);
        d.addCourse(c);
        return c.getName();
    }
    
}
