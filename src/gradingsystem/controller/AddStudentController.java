package gradingsystem.controller;

import gradingsystem.Entities.Departement;
import gradingsystem.Entities.Student;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */

public class AddStudentController {
    public static String addStudent(String name, String email, String number, int selectedDept){
        Student s = new Student(name, email, number, Departement.getDepartements().get(selectedDept));
        return s.getName();
    }
    
    static public DefaultComboBoxModel getDepartmentsNames(){
        DefaultComboBoxModel noIdea = new DefaultComboBoxModel();
        ArrayList<Departement> ds = Departement.getDepartements();
        for(int i=0; i<ds.size(); i++){
            noIdea.addElement(ds.get(i).getName());
        }
        return noIdea;
    }
}
