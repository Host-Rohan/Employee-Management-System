 
package employee.management.system;
/**
 *
 * @author ROHAN
 */
import javax.swing.*; //for JFrame extention used in GUI
import java.awt.*; //for playing with layout and fonts
import java.awt.event.*; //for adding events to GUI
public class Splash extends JFrame implements ActionListener { 
    Splash(){
        getContentPane().setBackground(Color.WHITE); //Setting background color of Frame to WHITE
        setLayout(null); //To tell browser that we wan't to use custom layout
        
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM"); //Creation of object for JFrame 
        heading.setBounds(65, 30, 1200, 60); //Setting location of heading
        heading.setFont(new Font("Serif", Font.PLAIN, 60)); //setting font style -for heading
        heading.setForeground(Color.RED); //setting font color to red -for heading
        add(heading);  //adding content of Label to frame
        
        
        ImageIcon image_1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg")); //Loading Image from the mentioned path
        Image image_2 = image_1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT); //Scaling Image as per frame
        ImageIcon image_3 = new ImageIcon(image_2); //converting Image to ImageIcon
        JLabel image = new JLabel(image_3);// creating Label of an Image
        image.setBounds(50,100,1050,500); // setting location of image on frame
                //We can not put image directly on frame we have to convert it in lael
        add(image);//adding label on frame
        
        
        JButton clickMe = new JButton("Click Here To Continue"); //Button With Text
        clickMe.setBounds(400, 400, 300, 70); //locating button
        clickMe.setBackground(Color.BLACK); //background color of button
        clickMe.setFont(new Font("Dialog",Font.BOLD,20)); //style of font on button
        clickMe.setForeground(Color.WHITE); //changing font color on button
        clickMe.addActionListener(this); //adding click event to go to login frame
        image.add(clickMe); // adding button on frame in relative position w.r.t. image
        
        setSize(1170, 650); //setting size of frame
        setLocation(200, 100); //changing originating location of frame
        setVisible(true); //enabling visiblity of frame
        
        while(true){ //Running Infinite loop to create Dripping Effect
            heading.setVisible(false); //Setting initial visibility hidden
            try{
                Thread.sleep(500); //500 milliseconds of loop stopage
            }catch (Exception e){ //error handling
        
            }
            heading.setVisible(true); //Enabling Visiblity after 500 ms
            try{
                Thread.sleep(500);
            }catch (Exception e){
        
            }
        }
    }
   @Override //method override annotation
    public void actionPerformed(ActionEvent ae) { //overriding method for implementing actionListener from event class
        setVisible(false); //on click closing spash window
        new Login(); //creating object of login screen so it calls constructor of login page
    }
    public static void main(String args[]){ //main method
        new Splash();
    }

    
}
