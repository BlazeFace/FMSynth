import java.lang.Math;

/**
 * An operator object in the shape
 * of a sawtooth.
 * with help from princeton edu
 */
public class Sawtooth  {
    private double[] samples;
    private double freq;
    private double amplitude;

    public Sawtooth() {

        freq = 440;
        amplitude = 1;
        samples = new double[44100];

        for(int i = 0; i < samples.length; i++) { //not right
            if (i % 2 == 0) {
                samples[i] = 1;
            } else {
                samples[i] = -1;
            }
        }
    }

    public double getFreq() {return freq; }
    public double getAmplitude() { return amplitude; }
    public double[] getSamples() { return samples; }
}