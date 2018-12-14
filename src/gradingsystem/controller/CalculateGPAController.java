package gradingsystem.controller;

import gradingsystem.Entities.GradedCourse;
import gradingsystem.Entities.Student;
import java.util.ArrayList;

/**
 *
 * @author Hossam
 */
public class CalculateGPAController {
    public static String calculateGPA(int selectedStudent){
        double gradeSum = 0;
        Student s = Student.getStudents().get(selectedStudent);
        ArrayList<GradedCourse> gcs = s.getGradedcourses();
        for(GradedCourse gc: gcs)
            gradeSum += gc.getGrade();
        gradeSum /= gcs.size();
        gradeSum = Math.round(gradeSum*100);
        
        s.setGpa((float)(gradeSum/100));
        
        return (gradeSum/100) + "";
    }
}
