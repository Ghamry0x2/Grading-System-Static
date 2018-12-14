package gradingsystem.Entities;

import java.io.Serializable;

public class GradedCourse implements Serializable {
    private Course course;
    private float grade;

    public GradedCourse(Course c, float grade) {
        course = c;
        this.grade = grade;
    }

    public float getGrade() {
        return this.grade;
    }

    public Course getCourse() {
        return course;
    }
    
  
}
