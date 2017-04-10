/**
 * An operator object in the shape
 * of a sine wave.
 * @author Adam Ido
 */
public class Sine implements Operator {
    private double freq;
    private double amplitude;
    private double[] waveform;

    public Sine() {
        freq = 440;
        amplitude = 1;
        waveform = new double[44000];

        for(int i = 0; i < waveform.length; i++) {
            waveform[i] = amplitude * Math.sin((i / waveform.length) * Math.PI);
        }
    }

    public double getFreq() { return freq; }
    public double getAmplitude() { return amplitude; }
    public double[] getSamples() { return waveform; }
}