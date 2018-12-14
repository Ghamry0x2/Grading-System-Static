package gradingsystem.Entities;

import java.io.Serializable;

public class Course implements Serializable{
    
    private static int idCounter = 0;
    private int id;
    private String name;

    public Course(String name) {
        idCounter += 1;
        this.id = idCounter;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Course.idCounter = idCounter;
    }

    
}
