import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;

/**
 * Updates if the key is pressed
 *
 */
public class PressedKey implements Runnable{
    private boolean isPressed;
    private int keycode;
    private char keys;
    private int key;
    public PressedKey(int key, char keys) {
        isPressed = false;
        this.keys = keys;
        this.keycode = key;


    }
    public void press(){
        StdDraw.enableDoubleBuffering();
        if(StdDraw.isKeyPressed(this.keycode)){
            this.isPressed = true;
            //System.out.println(this.keys);

            StdDraw.clear();

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
            StdDraw.picture(.48, .65, "url.jpg", 1.2, .7); //use last 2 param to scale

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
            StdDraw.text(0.35, 0.25, "Press WASD on Keyboard to Play a Sound!");

            //credits
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0.1, 0.8, "By:");
            StdDraw.text(0.1, 0.7, "Alex");
            StdDraw.text(0.1, 0.6, "Nate");
            StdDraw.text(0.1, 0.5, "Adam");

            StdDraw.text(.5,.5, ""+this.keys);

            StdDraw.show();
            StdDraw.pause(10);

            try {
                AudioPlayer.queue.put(this.keycode);
            }
            catch (Exception e){
                System.out.print("hel");
            }
        }
    }
    public int getKey(){return this.keycode;}
    public void run() {
       Timer time = new Timer();
        TimerTask key = new TimerTask() {
            @Override
            public void run() {
                press();
            }
        };
        time.schedule(key, 1, 20);
    }
}
