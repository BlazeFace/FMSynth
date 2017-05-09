import java.lang.Object;
import java.awt.Font;

/**
 * an interface for our fm synth
 * @AlexD 
 * @Jeff Traer-Bernstein for mouse point
 */

public class FMSynthInterface {
    public static void main(String[] args) {

        StdDraw.enableDoubleBuffering();
        
        while (true) {
          
            // mouse click
            if (StdDraw.mousePressed()) StdDraw.setPenColor(StdDraw.CYAN);
            else                        StdDraw.setPenColor(StdDraw.BLUE);

            // mouse location
            StdDraw.clear();
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            StdDraw.filledCircle(x, y, 0.01);
            
           //keys 
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(.005);
            StdDraw.rectangle(.05, .1, .05, .1);
            StdDraw.rectangle(.15, .1, .05, .1);
            StdDraw.rectangle(.25, .1, .05, .1);
            StdDraw.rectangle(.35, .1, .05, .1);
            StdDraw.rectangle(.45, .1, .05, .1);
            StdDraw.rectangle(.55, .1, .05, .1);
            StdDraw.rectangle(.65, .1, .05, .1);
            StdDraw.rectangle(.75, .1, .05, .1);
            StdDraw.rectangle(.85, .1, .05, .1);
            StdDraw.rectangle(.95, .1, .05, .1);
            
            //picture
            StdDraw.picture(.5, .65, "url.jpg", 1, .7); //use last 2 param to scale
            
            //headboard
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledRectangle(.5, .25, .5, .05);
            if (StdDraw.mousePressed()) StdDraw.setPenColor(StdDraw.GREEN);
            else                        StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(.8, .25, .05, .02);
            
            //title & box
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.setPenRadius(.01);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0.5, 0.9, "FM Synthesizer");
            StdDraw.rectangle(.5, .9, .15, .05);
            
            //piano text
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0.35, 0.25, "Press Keys Below to Play a Sound!");
            
           //credits
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0.1, 0.8, "By:");
            StdDraw.text(0.1, 0.7, "Alex");
            StdDraw.text(0.1, 0.6, "Nate");
            StdDraw.text(0.1, 0.5, "Adam");
            
            
              
            StdDraw.show();
            StdDraw.pause(10);
            
        }
    }
}
