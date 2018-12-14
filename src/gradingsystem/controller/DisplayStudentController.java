package gradingsystem.controller;

import gradingsystem.Entities.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;



/**
 *
 * @author Hossam
 */

public class DisplayStudentController {
    static public DefaultListModel getStudentsNames(){
        DefaultListModel noIdea = new DefaultListModel();
        ArrayList<Student> ss = Student.getStudents();
        for(int i=0; i<ss.size(); i++){
            noIdea.addElement(ss.get(i).getName());
        }
        return noIdea;
    }
    
    static public String[] getStudentInfo(int selectedStudent){
        Student s = Student.getStudents().get(selectedStudent);
        String[] str = {s.getId()+ "", s.getName(), s.getEmail(), s.getNumber(), s.getDepartment().getName()};
        return str;
    }
}
