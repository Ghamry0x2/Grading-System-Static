package gradingsystem.controller;

import gradingsystem.Entities.Student;

/**
 *
 * @author Dell
 */

public class RemoveStudentController {
    public static void removeStudent(int selectedStudent){
        Student s = Student.getStudents().get(selectedStudent);
        s.removeStudent();
    }
}
