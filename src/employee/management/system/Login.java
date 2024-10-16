
package employee.management.system;

/**
 *
 * @author ROHAN
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField tfUsername, tfPassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(50,30,100,40);
        add(lblUsername);
        
        tfUsername = new JTextField();
        tfUsername.setBounds(150,35,150,30);
        add(tfUsername);
        
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(50,80,100,40);
        add(lblPassword);
        
        tfPassword = new JTextField();
        tfPassword.setBounds(150,85,150,30);
        add(tfPassword);
        
        JButton login = new JButton("LOGIN"); //Button With Text
        login.setBounds(150, 150, 150, 50); //locating button
        login.setBackground(Color.BLACK); //background color of button
        login.setFont(new Font("SansSerif",Font.BOLD,20)); //style of font on button
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon image_1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg")); //Loading Image from the mentioned path
        Image image_2 = image_1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT); //Scaling Image as per frame
        ImageIcon image_3 = new ImageIcon(image_2); //converting Image to ImageIcon
        JLabel image = new JLabel(image_3);// creating Label of an Image
        image.setBounds(350,0,200,250); // setting location of image on frame
                //We can not put image directly on frame we have to convert it in label
        add(image);//adding label on frame
        
        
        setSize(600,300);
        setLocation(450,300);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) { 
        try{
            String username = tfUsername.getText(); //here getText() gives the value of textfield - gives username
            String password = tfPassword.getText(); //gives password
            Conn c = new Conn();
            String query ="select * from login where username = '"+ username +"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid Username or Password");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
