package gradingsystem.GUI;

import gradingsystem.controller.AddDepartmentController;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class NewDepartment extends JFrame{   
    
    private JLabel lblName = new JLabel("Name : ");
    private JLabel lblDescription = new JLabel("Description : ");
    
    private JTextField txtName = new JTextField("Enter Name Here...");
    private JTextArea txtDescription = new JTextArea("Enter Description Here...", 6,15);
    private JScrollPane scrollDescription = new JScrollPane( txtDescription ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
    
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    
    private DefaultListModel dlm;
    
    
    public NewDepartment(DefaultListModel d){
        dlm = d;
        init();        
    }
    
    private void init(){
        this.setTitle("Add New Department");
        this.setBounds(300, 300, 600, 380);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/department.png")).getImage()); 
        //this.setIconImage(new ImageIcon(getClass().getResource("/icons/SpongeBob.png")).getImage());
        
        Container c = this.getContentPane();
        
        //-----Allignment-----
        
        c.setLayout(null);
        
        lblName.setBounds(100,15,100,30);
        lblDescription.setBounds(100,55,100,30);
        
        c.add(lblName);
        c.add(lblDescription);
        
        txtName.setBounds(210,15,300,30);
        scrollDescription.setBounds(210,55,300,230);    
        
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        
//        txtDescription.setBorder(BorderFactory.createEtchedBorder());
        
        c.add(txtName);
        c.add(scrollDescription);

        
        btnOk.setBounds(260,295,100,30);
        btnCancel.setBounds(370,295,100,30);
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
        
        
        txtDescription.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if( txtDescription.getText().equals("Enter Description Here...") )
                    txtDescription.setText("");
            }
        });
        
        btnOk.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtName.getText().equals("") || txtName.getText().equals("Enter Name Here...")){
                    JOptionPane.showMessageDialog(NewDepartment.this, "Enter Department Name!");
                    txtName.requestFocus();
                    return;
                }
                if(txtDescription.getText().equals("") || txtDescription.getText().equals("Enter Description Here...")){
                    JOptionPane.showMessageDialog(NewDepartment.this, "Enter Department Description!");
                    txtDescription.requestFocus();
                    return;
                }
                
                String s = AddDepartmentController.addDepartment(txtName.getText(), txtDescription.getText());
                dlm.addElement(s);
                
                NewDepartment.this.dispatchEvent(new WindowEvent(NewDepartment.this, WindowEvent.WINDOW_CLOSING));
            }
                
        });
        
        btnCancel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewDepartment.this.dispatchEvent(new WindowEvent(NewDepartment.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
  
}
