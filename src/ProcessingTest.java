import processing.core.PApplet;

/**
 *
 * @author lamonta
 */
public class ProcessingTest extends PApplet {

  public void settings() {
    size(800, 600);
  }

  public void setup() {
    background(0);
    fill(255);
    int a = 0;
    int r = 2;
    while(r<50){
        float x = (float)(r*Math.cos(a)) +400;
        float y = (float)(r*Math.sin(a)) + 300;
        ellipse(x,y, 10, 10);
        r++;
        a+=25;
    }
  }

  public void draw() {
    //fill(255);
    //ellipse(mouseX, mouseY, 25, 25);
  }
  
  public static void main(String[] args) {
    PApplet.main("ProcessingTest", args);
  }
}
