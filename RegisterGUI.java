
package tms_project;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import sun.util.calendar.BaseCalendar;

public class RegisterGUI extends JFrame 
                   implements ActionListener,ItemListener{
   
    private static int WIDTH = 750;
    private static int HEIGHT = 450;   
    
    JTextField IdTF,NameTF,FamTF,SubDateTF,AddressTF, CityTF, TelNumTF, 
               PasswordTF, ZipCodeTF, EmailTF;
    
    JComboBox TypeCoB, ProvinceCoB;
    
    int Id;
    int Type = 1;
    String Province = "QC";
    Boolean select = false;
    
    JButton saveB, cancelB;
    Container pane = getContentPane(); 
    
    String query; 
   
    
    public RegisterGUI() throws IOException 
     {
        JLabel IdL,TypeL,NameL,FamL,SubDateL,AddressL, CityL, ProvinceL, 
               ProvL, TelNumL,PasswordL, ZipCodeL, EmailL; 
        
        IdL = new JLabel("your Id: ",SwingConstants.RIGHT);
        TypeL = new JLabel("Enter your Type: ",SwingConstants.RIGHT);
        NameL = new JLabel(" Enter your Name: ",SwingConstants.RIGHT);
        FamL = new JLabel(" Enter your Family: ",SwingConstants.RIGHT);
        SubDateL = new JLabel(" Subscribe Date: ",SwingConstants.RIGHT);
        TelNumL = new JLabel(" Enter your Phone: ",SwingConstants.RIGHT);
        CityL = new JLabel(" City: ",SwingConstants.RIGHT);
        ProvinceL = new JLabel(" Province: ",SwingConstants.RIGHT);
        AddressL = new JLabel(" Enter your Address: ",SwingConstants.RIGHT);
        ZipCodeL = new JLabel(" Enter your ZipCode: ",SwingConstants.RIGHT);
        EmailL = new JLabel(" Enter your Email: ",SwingConstants.RIGHT);
       
        PasswordL = new JLabel(" Enter Password: ",SwingConstants.RIGHT);
                
        setTitle("Shipment Order Form"); 
        setLocation(530, 230);
        setSize(WIDTH,HEIGHT); 
          
        pane.setLayout(null);
       
        IdTF =  new JTextField(10);
        IdTF.setEditable(false);
        IdTF.setForeground(Color.RED);
        IdTF.setBackground(Color.WHITE);
        
        NameTF =  new JTextField(10);
        FamTF = new JTextField(10);
        SubDateTF = new JTextField(10);
        
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
       
        SubDateTF.setText(ft.format(date));
        SubDateTF.setEditable(false);
        SubDateTF.setForeground(Color.RED);
        SubDateTF.setBackground(Color.WHITE);
        
        TelNumTF = new JTextField(10);
        AddressTF = new JTextField(10);
        CityTF = new JTextField(10);
        PasswordTF = new JTextField(10);
       
        ZipCodeTF = new JTextField(10);
        EmailTF = new JTextField(10);
        
        saveB = new JButton("Save");
        saveB.addActionListener(this);
        cancelB = new JButton("Cancel");
        cancelB.addActionListener(this);
        
        String[] Types = {"Client","Provider","Carrier","Driver"};
        TypeCoB = new JComboBox(Types);
        TypeCoB.addItemListener(this);
       
        String[] Provincestr = {"AB","BC","IP","MB","NB","NS","ON","QC","SK","NL"};
        ProvinceCoB = new JComboBox(Provincestr);
        ProvinceCoB.addItemListener(this);
        
        IdL.setLocation(30, 50);
        IdTF.setLocation(190, 50);
        TypeL.setLocation(30, 80);
        TypeCoB.setLocation(190, 80);
        NameL.setLocation(30, 110);
        NameTF.setLocation(190, 110);
        FamL.setLocation(30, 140);
        FamTF.setLocation(190, 140);
        SubDateL.setLocation(30, 170);
        SubDateTF.setLocation(190, 170);
        TelNumL.setLocation(30, 200);
        TelNumTF.setLocation(190, 200);
        AddressL.setLocation(30, 230);
        AddressTF.setLocation(190, 230);
        CityL.setLocation(400, 230);
        CityTF.setLocation(445, 230);
        ProvinceL.setLocation(550, 230);
        ProvinceCoB.setLocation(615, 230);
        ZipCodeL.setLocation(30, 260);
        ZipCodeTF.setLocation(190, 260);
        EmailL.setLocation(30, 290);
        EmailTF.setLocation(190, 290);
      
        PasswordL.setLocation(30, 320);
        PasswordTF.setLocation(190, 320);
        
        saveB.setLocation(500, 50);
        cancelB.setLocation(500,83);
        
        IdL.setSize(150, 30);
        IdTF.setSize(200, 30);
        TypeL.setSize(150, 30);
        TypeCoB.setSize(200, 30);
        NameL.setSize(150, 30);
        NameTF.setSize(200, 30);
        FamL.setSize(150, 30);
        FamTF.setSize(200, 30);
        SubDateL.setSize(150, 30);
        SubDateTF.setSize(200, 30);         
        AddressL.setSize(150, 30);
        AddressTF.setSize(200, 30);
        CityL.setSize(40, 30);
        CityTF.setSize(100,30);
        ProvinceL.setSize(60,30);
        ProvinceCoB.setSize(60, 30);
        TelNumL.setSize(150, 30);
        TelNumTF.setSize(200, 30);
        ZipCodeL.setSize(150, 30);
        ZipCodeTF.setSize(200, 30);
        EmailL.setSize(150, 30);
        EmailTF.setSize(200, 30);
      
        PasswordL.setSize(150, 30);
        PasswordTF.setSize(200, 30);
        
        saveB.setSize(130, 30);
        cancelB.setSize(130, 30);
        
        
        pane.add(IdL);
        pane.add(IdTF);
        pane.add(TypeL);
        pane.add(TypeCoB);
        pane.add(NameL);
        pane.add(NameTF);
        pane.add(FamL);
        pane.add(FamTF);
        pane.add(SubDateL);     
        pane.add(SubDateTF);     
        pane.add(TelNumL);
        pane.add(TelNumTF);
        pane.add(AddressL);
        pane.add(AddressTF);
        pane.add(CityL);
        pane.add(CityTF);
        pane.add(ProvinceL);
        pane.add(ProvinceCoB);
        pane.add(ZipCodeL);
        pane.add(ZipCodeTF);
        pane.add(EmailL);
        pane.add(EmailTF);
       
        pane.add(PasswordL);
        pane.add(PasswordTF);
        
        pane.add(saveB);
        pane.add(cancelB);
        //pane.setBackground(Color.LIGHT_GRAY);
                     
        setVisible(true);
        setAlwaysOnTop(true);
        setFocusableWindowState(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         System.out.println(Type + "   " + Province);
    }
    
     public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("Save"))
       {
         if(Type != 2) 
         {         
             try{
                ConnectToOracle.ConnectToDBMS();
                query = "SELECT  count(*) FROM Register ";
                ResultSet result = ConnectToOracle.s.executeQuery(query);
                if(result.next()) {
                           Id = 100001 + result.getInt(1);
                           IdTF.setText("" + Id);  
                           
                                  }
                else  System.out.println("  --- ERROR-----");                               
                ConnectToOracle.closeDBMS();         
                }
              catch(Exception exp)
              {
                 System.out.println("Error:  " + exp + "    " + query);
              }       
         }
         try{
            ConnectToOracle.ConnectToDBMS();

            query = "INSERT INTO Register VALUES (" + Id +
                                                  ",'" + FamTF.getText() + "'" + 
                                                  ",'" + NameTF.getText() + "'," + Type +
                                                  ",'" + AddressTF.getText() + "'" + 
                                                  ",'" + CityTF.getText() + "'" +
                                                  ",'" + Province  + "'" +
                                                  ",'" + ZipCodeTF.getText() + "'" +
                                                  ",'" + EmailTF.getText() + "'" +
                                                  ",'" + TelNumTF.getText() + "'" +
                                                  ",'" + SubDateTF.getText() + "'" +
                                                  ",'" + PasswordTF.getText() + "'" +
                                                  ",0)";
                        
            ConnectToOracle.s.executeUpdate(query);
            JOptionPane.showMessageDialog(RegisterGUI.this," Your registration was accepted ",
                                                 "Alert",JOptionPane.INFORMATION_MESSAGE);
            ConnectToOracle.closeDBMS();         
                }
         catch(Exception exp)
          {
            System.out.println("Error:  " + exp + "    " + query);
          }       
      }   
      else if(e.getActionCommand().equals("Cancel"))
           {
             select = false;
             TypeCoB.setSelectedIndex(0);
             ProvinceCoB.setSelectedIndex(0);
             IdTF.setText(""); 
             NameTF.setText(""); 
             FamTF.setText(""); 
             AddressTF.setText("");  
             CityTF.setText("");
             ZipCodeTF.setText("");
             TelNumTF.setText("");
             EmailTF.setText("");
             PasswordTF.setText("");
                      
           }  
      
             
     }  
      public void paint(Graphics g) {
          
        super.paint(g);
        /*
        Image backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("transportation-management.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        //g.setColor(Color.red);
        
        g.drawImage(backgroundImage, 100, 220, 700,450,this);*/
        g.setColor(Color.BLACK);
        g.draw3DRect(50, 50, 650, 365,true);
        g.draw3DRect(53, 53, 645, 360,true);
  }
      
    public void itemStateChanged(ItemEvent e) {
               
        
        Province = ProvinceCoB.getSelectedItem().toString();
        
        if(e.getStateChange() == ItemEvent.SELECTED && !select)         
        {
          Type = TypeCoB.getSelectedIndex() + 1;
          if(Type == 2) {
              String str = JOptionPane.showInputDialog(RegisterGUI.this, "Please enter your Employee Id: ", "Employee Id",JOptionPane.QUESTION_MESSAGE);
              try {
                Id = Integer.parseInt(str);
                ConnectToOracle.ConnectToDBMS();
                try{
                  query = "SELECT * FROM Employee " 
                                  + "WHERE EmployeeId = " + Id ;       
                  ResultSet result = ConnectToOracle.s.executeQuery(query);                                
                  if(result.next()) {      

                      IdTF.setText("" + result.getString(1));  
                      FamTF.setText(result.getString(2));
                      NameTF.setText(result.getString(3));
                      AddressTF.setText(result.getString(5));
                      select = true;
                      CityTF.setText(result.getString(6));
                      ProvinceCoB.setSelectedItem(result.getString(7));
                      ZipCodeTF.setText(result.getString(8));
                      TelNumTF.setText(result.getString(9));
                      EmailTF.setText(result.getString(10));
                                    }               
                   else JOptionPane.showMessageDialog(RegisterGUI.this,"Employee not found  ",
                                         "Record Confirmation",JOptionPane.INFORMATION_MESSAGE);                                                              
                   ConnectToOracle.closeDBMS();               
                  }
                catch(Exception exp)
                 {
                    System.out.println("Error - Database Management for creating tables() : " + exp);
                    JOptionPane.showMessageDialog(RegisterGUI.this,"Employee ID is not correct ",
                                         "Record Confirmation",JOptionPane.INFORMATION_MESSAGE);
                 }  
               }
              catch(Exception imeRef)
              {   
               JOptionPane.showMessageDialog(RegisterGUI.this,"Please enter the correct number",
                                                  "Incorrect Input",JOptionPane.ERROR_MESSAGE);
              } 
                      
             }
        
        }
        
    }

     
}
