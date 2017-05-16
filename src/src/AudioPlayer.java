import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * Created by nate on 4/10/17.
 */

public class AudioPlayer implements Runnable{
    public Operator a;
    public Operator b;
    public Operator c;
    public static volatile BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
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
    public static BlockingQueue gQ() {
        return queue;
    }
    private void mod(int freq){
        c.changeFreq(freq);
        b.changeFreq(freq + 100);
        a.changeFreq(freq / 2);
        b.modulate(c.getSamples());
        a.modulate(b.getSamples());
    }
    public void run(){
        while(true) {
            Integer msg;
            int i = 0;
            while ((msg = queue.poll()) != null) {
                if (msg == 65) {
                    mod(200);
                    System.out.print("a ");
                    StdAudio.play(a.getSamples());

                    }
                if (msg == 87) {
                    mod( 400);
                    System.out.print("w ");
                    StdAudio.play(a.getSamples());
                }
                if (msg == 83) {
                    mod(600);
                    System.out.print("s ");
                    StdAudio.play(a.getSamples());
                }
                if (msg == 68) {
                    mod(800);
                    System.out.print("d ");
                    StdAudio.play(a.getSamples());
                }
                    }
            //System.out.print("NULL");
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
