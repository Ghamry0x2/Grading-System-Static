package gradingsystem.Entities;

import java.io.Serializable;
import java.util.*;

public class Departement implements Serializable {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String description;
    
    private ArrayList<Course> courses = new ArrayList<Course>();
    private static ArrayList<Departement> departements = new ArrayList<Departement>();



    public Departement(String name, String description) {
        this.idCounter += 1;
        this.id = idCounter;
        this.name = name;
        this.description = description;

        departements.add(this);
    }

    public static void setIdCounter(int idCounter) {
        Departement.idCounter = idCounter;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }


    public static void setDepartements(ArrayList<Departement> depts) {
        departements = depts;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public static ArrayList<Departement> getDepartements() {
        return departements;
    }
    
    public void removeDepartment(){
        departements.remove(this);
    }

    public void addCourse(Course c){

       courses.add(c);
    }

    public void removeCourse(int i){
        courses.remove(i);
    }
    
    @Override
   public String toString(){
   
       String st = "ID: " + this.getId() +"\n" + "Name: " + this.getName() + "\n" +
                    "Description: " + this.getDescription();
   
       return st;
   }  

}
