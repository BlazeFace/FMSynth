
/**
 * An operator object in the shape
 * of a cosine wave.
 * @author Alex Doro
 */
public class Cosine implements Operator {
    private double freq;
    private double amplitude;
    private double[] waveform;

    public Cosine() {
        freq = 440;
        amplitude = 1;
        waveform = new double[44000];

        for(int i = 0; i < waveform.length; i++) {
            waveform[i] = amplitude * Math.cos((i / waveform.length) * Math.PI);
        }
    }

    public double getFreq() { return freq; }
    public double getAmplitude() { return amplitude; }
}