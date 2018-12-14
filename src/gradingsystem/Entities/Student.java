package gradingsystem.Entities;

import java.io.Serializable;
import java.util.*;

public class Student implements Serializable{
    private static int idCounter = 0;
    private int id;
    private String name;
    private String email;
    private String number;
    private Departement department;
    private float gpa;


    private ArrayList<GradedCourse> gradedCourses = new ArrayList<GradedCourse>(); 
    private static ArrayList<Student> students = new ArrayList<Student>();



    public Student(String name, String email, String number, Departement department) {
        this.idCounter += 1;
        this.id = idCounter;
        this.name = name;
        this.email = email;
        this.number = number;
        this.department = department;

        students.add(this);
    }
    
    public static void setIdCounter(int idCounter){
        Student. idCounter = idCounter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(Departement department) {
        this.department = department;
    }

    public void setGradedcourses(ArrayList<GradedCourse> gradedCourses) {
        this.gradedCourses = gradedCourses;
    }

    public static void setStudents(ArrayList<Student> students) {
        Student.students = students;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    
    public float getGpa() {
        return gpa;
    }
    
    public static int getIdCounter(){
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Departement getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public ArrayList<GradedCourse> getGradedcourses() {
        return gradedCourses;
    }


    public static ArrayList<Student> getStudents() {
        return students;
    }

    public void assignCourse(GradedCourse gc){
       
       this.gradedCourses.add(gc); 
    }
    
    public void removeStudent(){
        students.remove(this);
    }
    
    public void removeGradedCourse(int i){
        this.gradedCourses.remove(i);
    }



    @Override
    public String toString(){

       String st = "ID: " + this.getId() +"\n" + "Name: " + this.getName() + "\n" +
                   "Email: " + this.getEmail() + "\n" + "Phone Number: " + this.getNumber()+ "\n" + "Department: " + this.getDepartment().getName();

       return st;
    }  
   
}
     
