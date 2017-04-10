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

        for(int i = 0; i < samples.length; i++) {
            samples[i] = amplitude * Math.sin((i / samples.length) * 2 * Math.PI);
        }
    }

    public double getFreq() { return freq; }
    public double getAmplitude() { return amplitude; }
    public double[] getSamples() { return samples; }
}