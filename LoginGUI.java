
package tms_project;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LoginGUI extends JFrame 
                   implements ActionListener{
   
    private static int WIDTH = 1400;
    private static int HEIGHT = 700;   
    
    JPasswordField PasswordPF;
    JTextField IDTF;
    JLabel IDL,PasswordL;
    JButton loginB, registerB;
    
    Container pane = getContentPane(); 
   
    String query; 
    
    int Id;
    
    public LoginGUI() throws IOException 
     {
         
        
        IDL = new JLabel(" Enter your ID: ",SwingConstants.RIGHT);
        PasswordL = new JLabel(" Enter Password: ",SwingConstants.RIGHT);
                
        setTitle("TMS Application"); 
        setLocation(130, 130);
        setSize(WIDTH,HEIGHT); 
          
        pane.setLayout(null);
       
        IDTF =  new JTextField(10);
        PasswordPF = new JPasswordField(10);
        
        loginB = new JButton("Login");
        loginB.addActionListener(this);
        registerB = new JButton("Register");
        registerB.addActionListener(this);
        
        IDL.setLocation(30, 50);
        IDTF.setLocation(190, 50);
        PasswordL.setLocation(30, 80);
        PasswordPF.setLocation(190, 80);
        
        loginB.setLocation(430, 50);
        registerB.setLocation(430,83);
        
        IDL.setSize(150, 30);
        IDTF.setSize(200, 30);
        PasswordL.setSize(150, 30);
        PasswordPF.setSize(200, 30);
        
        loginB.setSize(130, 30);
        registerB.setSize(130, 30);
        
        pane.add(IDL);
        pane.add(IDTF);
        pane.add(PasswordL);
        pane.add(PasswordPF);
        
        pane.add(loginB);
        pane.add(registerB);
        pane.setBackground(Color.WHITE);
                     
        setVisible(true);
        setAlwaysOnTop(true);
        setFocusableWindowState(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
     public void actionPerformed(ActionEvent e) 
     {
       int index = 0;
       if(e.getActionCommand().equals("Login"))
       {
        try{ 
           int Id = Integer.parseInt(IDTF.getText());
                  
           ConnectToOracle.ConnectToDBMS();
           try{
              query = "SELECT * FROM Register " 
                              + "WHERE memId = " + Id 
                              + " AND PassWord like '" + PasswordPF.getText()+ "'";
         
              ResultSet result = ConnectToOracle.s.executeQuery(query);             
              if(result.next()) { 
                   index = result.getInt(4); 
                    ConnectToOracle.closeDBMS();
                                }               
                 else JOptionPane.showMessageDialog(LoginGUI.this,"Username or PassWord is not correct ",
                                     "Record Confirmation",JOptionPane.INFORMATION_MESSAGE);
                
             }
          catch(Exception exp)
          {
                System.out.println(query);
                System.out.println("Error - Login - Database Management for creating tables() : " + exp);
           }  
             if(index == 1){
                       try {    
                           
                           ClientGUI ClientForm = new ClientGUI(Id);
                           } 
                       catch (IOException ex)
                         {
                           Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                         }
                                  }
             else if(index == 2){
                       try {   
                           ProviderGUI ProviderForm = new ProviderGUI();
                           } 
                       catch (IOException ex)
                         {
                           Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                         }
                                   }
              else if(index == 3){
                       try {   
                           CarrierGUI CarrierForm = new CarrierGUI(Id);
                           } 
                       catch (IOException ex)
                         {
                           Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                         }
                                   }
              else if(index == 4){
                       try {   
                           DriverGUI DriverForm = new DriverGUI(Id);
                           } 
                       catch (IOException ex)
                         {
                           Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                         }
                                   }
         }
         catch(Exception imeRef)
         {   
          JOptionPane.showMessageDialog(LoginGUI.this,"Please enter the correct number",
                                              "Incorrect Input",JOptionPane.ERROR_MESSAGE);
         } 
        }
        else if(e.getActionCommand().equals("Register"))
        {
            
          
          try {
              RegisterGUI RegisterForm = new RegisterGUI();
          } catch (IOException ex) {
              Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
          }
          
        }        
       
   
       
            
     }  
      public void paint(Graphics g) {
          
        super.paint(g);
        Image backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("the-benefits-of-tms.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        //g.setColor(Color.red);
        
        g.drawImage(backgroundImage, 100, 220, 1200,450,this);
        g.setColor(Color.red);
        g.draw3DRect(50, 50, 600, 150,true);
  }

     
}
