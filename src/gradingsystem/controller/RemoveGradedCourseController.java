package gradingsystem.controller;

import gradingsystem.Entities.Student;

/**
 *
 * @author Hossam
 */

public class RemoveGradedCourseController {
    public static void removeGradedCourse(int selectedStudent, int selectedCourse){
        Student s = Student.getStudents().get(selectedStudent);
        s.removeGradedCourse(selectedCourse);
    } 
}
