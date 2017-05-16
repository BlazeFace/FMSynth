import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * Created by nate on 4/10/17.
 */

public class AudioPlayer implements Runnable{
    public Operator a;
    public Operator b;
    public Operator c;
    volatile BlockingQueue<PressedKey> queue = new LinkedBlockingQueue<>();
    public AudioPlayer(Operator a, Operator b, Operator c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public AudioPlayer(){
        this.a = new Sine(450);
        this.b = new Sine(600);
        this.c = new Sine(200);
    }
    private void mod(int freq){
        c.changeFreq(freq);
        b.changeFreq(freq);
        a.changeFreq(freq);
        b.modulate(c.getSamples());
        a.modulate(b.getSamples());
    }
    public void run(){
        while(true) {
            PressedKey msg;
            while ((msg = queue.poll()) != null) {
                if (msg.getKey() == 65) {
                    mod(200);
                    System.out.print("SUCCESSS");
                }
            }

        }
    }
    public static void main(String[] args) {

        (new Thread(new AudioPlayer(), "sound")).start();
        (new Thread(new PressedKey(65, 'a'), "keyListen")).start();
        (new Thread(new PressedKey(87, 'w'), "keyListen")).start();
        (new Thread(new PressedKey(83, 's'),"keyListen")).start();
        (new Thread(new PressedKey(68, 'd'),"keyListen")).start();
    }
}
