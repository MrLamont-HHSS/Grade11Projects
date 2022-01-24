
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


/**
 *
 * @author lamonta
 */
public class HangmanScreen  implements Runnable, ActionListener{

  // Class Variables  
  
BufferedImage img;
PicturePanel pic;

public HangmanScreen(){
    pic = new PicturePanel();
    img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
    pic.setImage(img);
    
}

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("HangMan");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    
    frame.add(pic);
    
  }
  
  public Graphics getGraphics(){
      return this.pic.getGraphics();
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

  }
  
  

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    HangmanScreen  gui = new HangmanScreen ();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
    
    Graphics g = gui.getGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 800, 600);
    
    
   
    
    
    
  }
}

