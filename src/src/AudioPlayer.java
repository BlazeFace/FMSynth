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
        c.changeFreq(freq / 3);
        b.changeFreq(freq + 10);
        c.changeFreq(freq + 5);
        b.modulate(c.getSamples());
        a.modulate(b.getSamples());
    }
    public void run(){
        while(true) {
            Integer msg;
            int i = 0;
            while ((msg = queue.poll()) != null) {
                if (msg == 65) {
                    mod(50);
                    System.out.print("a ");
                    for(int j = 0; j < 100; j++) {
                        StdAudio.play(a.getSamples()[j]);
                    }
                    }
                if (msg == 87) {
                    mod( 75);
                    System.out.print("w ");

                    for(int j = 0; j < 100; j++) {
                        StdAudio.play(a.getSamples()[j]);
                    }
                }
                if (msg == 83) {
                    mod(100);
                    System.out.print("s ");
                    for(int j = 0; j < 100; j++) {
                        StdAudio.play(a.getSamples()[j]);
                    }
                }
                if (msg == 68) {
                    mod(125);
                    System.out.print("d ");
                    for(int j = 0; j < 100; j++) {
                        StdAudio.play(a.getSamples()[j]);
                    }
                }
                    }
            for(int j = 0; j < 100; j++) {
                StdAudio.play(a.getSamples()[j]);
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
