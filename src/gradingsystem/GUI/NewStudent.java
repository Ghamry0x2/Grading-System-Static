package gradingsystem.GUI;

import gradingsystem.controller.AddStudentController;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class NewStudent extends JFrame{   
    
    private JLabel lblName = new JLabel("Name : ");
    private JLabel lblEmail = new JLabel("Email : ");
    private JLabel lblPhoneNumber = new JLabel("Phone Number : ");
    private JLabel lblDepartment = new JLabel("Department : ");
    
    private JTextField txtName = new JTextField("Enter Name Here...");
    private JTextField txtEmail = new JTextField("Enter Email Here...");
    private JNumberTextField txtPhoneNumber = new JNumberTextField("Enter Phone Number Here...");
    
    private DefaultComboBoxModel modelDepartments = AddStudentController.getDepartmentsNames();
    private JComboBox<String> comboDepartments = new JComboBox(modelDepartments);
    
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    
    private DefaultListModel dml;

    
    public NewStudent(DefaultListModel d){
        dml = d;
        init();        
    }
    
    private void init(){
        this.setTitle("Add New Student");
        this.setBounds(300, 300, 600, 260);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/student.png")).getImage()); 
        //this.setIconImage(new ImageIcon(getClass().getResource("/icons/SpongeBob.png")).getImage());
        
        Container c = this.getContentPane();
        
        //-----Allignment-----
        
        c.setLayout(null);
        
        lblName.setBounds(100,15,100,30);
        lblEmail.setBounds(100,55,100,30);
        lblPhoneNumber.setBounds(100,95,100,30);
        lblDepartment.setBounds(100,135,100,30);
        
        c.add(lblName);
        c.add(lblEmail);
        c.add(lblPhoneNumber);
        c.add(lblDepartment);
        
        txtName.setBounds(210,15,300,30);
        txtEmail.setBounds(210,55,300,30);
        txtPhoneNumber.setBounds(210,95,300,30);
        comboDepartments.setBounds(210,135,300,30);
        
        c.add(txtName);
        c.add(txtEmail);
        c.add(txtPhoneNumber);        
        c.add(comboDepartments);

        
        btnOk.setBounds(260,175,100,30);
        btnCancel.setBounds(370,175,100,30);
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
        
        txtPhoneNumber.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtPhoneNumber.getText().equals("Enter Phone Number Here...") )
                    txtPhoneNumber.setText("");
            }
        });
        
        txtEmail.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtEmail.getText().equals("Enter Email Here...") )
                    txtEmail.setText("");
            }
        });
        
        btnOk.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtName.getText().equals("") || txtName.getText().equals("Enter Name Here...") ) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Enter Student Name!");
                    txtName.requestFocus();
                    return;
                }
                if(txtEmail.getText().equals("") || txtEmail.getText().equals("Enter Email Here...") ) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Enter Student Email!");
                    txtEmail.requestFocus();
                    return;
                }
                if(txtPhoneNumber.getText().equals("") || txtPhoneNumber.getText().equals("Enter Phone Number Here...") ) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Enter Student Phone Number!");
                    txtPhoneNumber.requestFocus();
                    return;
                }
                
                if(comboDepartments.getSelectedIndex()== -1) {
                    JOptionPane.showMessageDialog(NewStudent.this, "Choose a Department!");
                    comboDepartments.requestFocus();
                    return;
                }
                
                String s =AddStudentController.addStudent(txtName.getText(), txtEmail.getText(), txtPhoneNumber.getText(), comboDepartments.getSelectedIndex());
                dml.addElement(s);
                
                NewStudent.this.dispatchEvent(new WindowEvent(NewStudent.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        btnCancel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewStudent.this.dispatchEvent(new WindowEvent(NewStudent.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }

   
}
