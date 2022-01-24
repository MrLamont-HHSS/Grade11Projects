
import jaco.mp3.player.MP3Player;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author lamonta
 */
public class Marioish extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "My Game";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    Rectangle player = new Rectangle(200, 350, 50, 50);
    Rectangle ground = new Rectangle(0, 400, 400, 200);
    Rectangle block = new Rectangle(250, 250, 100, 50);
    
    BufferedImage marioPic;

    boolean left = false;
    boolean right = false;
    int speed = 5;
    
    int gravity = 1;
    int dy = 0;
    
    boolean jump = false;
    boolean onGround = false;
    File jumpFile = new File("marioJump.mp3");
    MP3Player jumpSound = new MP3Player(jumpFile);

    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public Marioish(){
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
        
        // Set things up for the game at startup
        setup();

       // Start the game loop
        gameTimer = new Timer(desiredTime,this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        g.fillRect(ground.x, ground.y, ground.width, ground.height);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(block.x, block.y, block.width, block.height);
        g.setColor(Color.RED);
        g.drawImage(marioPic, player.x, player.y, player.width, player.height, null);
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void setup() {
        try {
            // Any of your pre setup before the loop starts should go here
            marioPic = ImageIO.read(new File("mario.png"));
        } catch (IOException ex) {
            Logger.getLogger(Marioish.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void loop() {
        // move left or right
        if(left){
            player.x = player.x - speed;
        }else if(right){
            player.x = player.x + speed;
        }
        
        if(jump && dy == 0 && onGround){
            dy = -20;
            onGround = false;
            jumpSound.play();
        }
        
        // turning on the gravity
        dy = dy + gravity;
        
        player.y = player.y + dy;
        // does the player hit the ground
        if(player.intersects(ground)){
            Rectangle intersect = player.intersection(ground);
            if(intersect.height < intersect.width){
                // stop gravity
                dy = 0;
                // pick the player back up
                player.y = ground.y - player.height;
                // on the ground
                onGround = true;
               
            }else if(left){
                player.x = player.x + intersect.width;
            }
        }
        
        // intersection with block
        if(player.intersects(block)){
            Rectangle overlap = player.intersection(block);
            // fix up or down
            if(overlap.height < overlap.width){
                // is it the top or bottom
                if(player.y < block.y){
                    // on top of box
                    dy = 0;
                    onGround = true;
                    player.y = player.y - overlap.height;
                }else{
                    player.y = player.y + overlap.height;
                    dy = 0;
                    
                }
            }else{
                // left or right
                if(player.x < block.x){
                    player.x = player.x - overlap.width;
                }else{
                    player.x = player.x + overlap.width;
                }
            }
        }
        
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {

        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_A){
                left = true;
            }else if(key == KeyEvent.VK_D){
                right = true;
            }else if(key == KeyEvent.VK_SPACE){
                jump = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_A){
                left = false;
            }else if(key == KeyEvent.VK_D){
                right = false;
            }else if(key == KeyEvent.VK_SPACE){
                jump = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        loop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        Marioish game = new Marioish();
    }
}


