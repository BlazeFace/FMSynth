import java.io.File;

/**
 * An operator object in the shape
 * of a sine wave.
 * @author Adam Ido
 */
public class Sine implements Operator {
    private double freq;
    private double amplitude;
    private double[] samples;

    public Sine() {
        freq = 440;
        amplitude = 1;
        samples = new double[44000];

        for(int i = 0; i < samples.length; i++){
            samples[i] = amplitude * Math.sin(((i * Math.PI * freq)/ samples.length) );
        }
    }
    public Sine(double[] samples) {
        freq = 440;
        amplitude = 1;

        for(int i = 0; i < samples.length; i++) {
            samples[i] = Math.sin(samples[i]);
        }
    }

    public double getFreq() { return freq; }
    public double getAmplitude() { return amplitude; }
    public double[] getSamples() { return samples; }
    public static void main(String[] args) {
        Sine a = new Sine();
        double[] b = a.getSamples();
       // for (double k : b) {
         //   System.out.print(k + " ");
        //}
        //StdAudio.save("byte.wav", a.getSamples());
        //File temp = new File("byte.wav");
        //System.out.print(temp.canRead());
    StdAudio.play(b);

    }
}