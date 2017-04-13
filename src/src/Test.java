/**
 * Created by nate on 4/10/17.
 */
public class Test implements Runnable{
    public double a;
    public double b;
    public double c;
    public void run(){
        Operator a = new Sine(440);
        Operator b = new Sine( 100);
       Operator c = new Sine(10);

       b.modulate(c.getSamples());
        a.modulate(b.getSamples());
        while(true) {
            StdAudio.play(a.getSamples());
        }
    }
    public static void main(String[] args) {
        (new Thread(new Test(), "sound")).start();
    }
}
