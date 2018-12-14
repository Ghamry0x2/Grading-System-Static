package gradingsystem;

import gradingsystem.Entities.*;
import gradingsystem.GUI.GUI;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author Hossam
 */


public class GradingSystem {
    public static void main(String[] args) {
        loadFile();
        
        GUI g = new GUI();
        g.setVisible(true);
        
        g.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveFile();
            }
        });
    }
    
    private static void loadFile(){
        try {
            FileInputStream fis = new FileInputStream("data.hig");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Departement.setIdCounter((int)ois.readObject());
            Departement.setDepartements((ArrayList<Departement>)ois.readObject());
            Student.setIdCounter((int)ois.readObject());
            Student.setStudents((ArrayList<Student>)ois.readObject());
            Course.setIdCounter((int)ois.readObject());
        }
        catch(Exception e){
            System.out.println("Couldn't read file");
        }
    }
    
    private static void saveFile(){
        File f = new File("data.hig");
        if(!f.exists()){
            try {
                f.createNewFile();
            }
            catch(Exception e){
                System.out.println("oopss");
            }
        }
        try {
            FileOutputStream ois = new FileOutputStream(f, false);
            ObjectOutputStream oos = new ObjectOutputStream(ois);
            oos.writeObject(Departement.getIdCounter());
            oos.writeObject(Departement.getDepartements());
            oos.writeObject(Student.getIdCounter());
            oos.writeObject(Student.getStudents());
            oos.writeObject(Course.getIdCounter());
            ois.close();
            oos.close();
        }
        catch(IOException e){
            System.out.println(e.getCause());
        }
    }
}
