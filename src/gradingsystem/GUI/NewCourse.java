package gradingsystem.GUI;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import gradingsystem.controller.AddCourseController;

public class NewCourse extends JFrame{   
    
    private JLabel lblName = new JLabel("Name : ");
    
    private JTextField txtName = new JTextField("Enter Name Here...");
    
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    
    private int selectedIndex;
    
    private DefaultListModel dlm;
    
    
    
   // New Course Variables 
    private String name = "None";
    
    
    
    public NewCourse(int selectedIndex, DefaultListModel d){
        this.selectedIndex = selectedIndex;
        dlm = d;
        init();        
    }
    
    private void init(){
        this.setTitle("Add New Course");
        this.setBounds(300, 300, 600, 140);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/course.png")).getImage()); 
        //this.setIconImage(new ImageIcon(getClass().getResource("/icons/SpongeBob.png")).getImage());
        
        Container c = this.getContentPane();
        
        //-----Allignment-----
        
        c.setLayout(null);
        
        lblName.setBounds(100,15,100,30);
        
        c.add(lblName);
        
        txtName.setBounds(210,15,300,30);
        
        c.add(txtName);

        
        btnOk.setBounds(260,55,100,30);
        btnCancel.setBounds(370,55,100,30);
        c.add(btnOk);
        c.add(btnCancel);
        
        
        //-----Action Listeners-----
        
        
        txtName.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtName.getText().equals("Enter Name Here...") )
                    txtName.setText("");
            }
        });
        
        btnOk.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(! txtName.getText().equals("") && ! txtName.getText().equals("Enter Name Here...") ) {
                    String s = AddCourseController.addCourse(txtName.getText(), selectedIndex);
                    dlm.addElement(s);
                    NewCourse.this.dispatchEvent(new WindowEvent(NewCourse.this, WindowEvent.WINDOW_CLOSING));
                }
                else {
                    JOptionPane.showMessageDialog(NewCourse.this, "Enter Course Name!");
                    txtName.requestFocus();
                }
            }
        });
        
        btnCancel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewCourse.this.dispatchEvent(new WindowEvent(NewCourse.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
  
    
    
    // Move this method to the controller class
//    public static void addNewCourse(NewCourse nc){
//        students.add(nc);
//        try {
//            FileWriter fw = new FileWriter("Courses.csv", true);
//            PrintWriter pw = new PrintWriter(fw, true);
//            pw.println(ns.name);
//            pw.close();
//            fw.close();
//        }
//        catch(IOException e){
//            
//        }
//    }

    @Override
    public String getName() {
        return name;
    } 
    
    @Override
    public String toString() {
        String s;
        
        s = "Name : " + name + "\n";
        return s;
    }
}
