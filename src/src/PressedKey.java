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
        if(StdDraw.isKeyPressed(this.keycode)){
            this.isPressed = true;
            //System.out.println(this.keys);
            StdDraw.clear();
            StdDraw.text(.5,.5, ""+this.keys);

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
