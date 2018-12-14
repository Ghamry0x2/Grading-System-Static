package gradingsystem.controller;

import gradingsystem.Entities.Course;
import gradingsystem.Entities.Departement;
import gradingsystem.Entities.GradedCourse;
import gradingsystem.Entities.Student;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Hossam
 */
public class AddGradedCourseController {
    static public DefaultComboBoxModel getCourse(int selectedStudent){
        Student s = Student.getStudents().get(selectedStudent);
        Departement d = s.getDepartment();
        ArrayList<Course> cs = d.getCourses();
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        for(int i=0; i<cs.size(); i++){
            cbm.addElement(cs.get(i).getName());
        }
        return cbm;
    }
    
    static public String addCourse(int selectedStudent, int selectedCourse, float grade){
        Student s = Student.getStudents().get(selectedStudent);
        Departement d = s.getDepartment();
        Course c = d.getCourses().get(selectedCourse);
        GradedCourse gc = new GradedCourse(c, grade);
        s.assignCourse(gc);
        return c.getName();
    }
}
