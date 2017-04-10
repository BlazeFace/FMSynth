/**
 * An operator object in the shape
 * of a sawtooth.
 * with help from princeton edu
 */
public class Sawtooth implements Operator {
    private double[] samples;
    private double freq;
    private double amplitude;

    public Sawtooth() {

freq = 0.005;
amplitude = 1;
int r = 0;

        int n = 44000;

        samples = new double[44000];

        double xprev;

        for (double t = 0.0; t <= 6 * Math.PI; t += 0.005) {


            double x = 0.0;
            for (int k = 1; k <= n; k++) {
                x += Math.sin(k * t) / k;
            }
            x = x * 2 / Math.PI;
            xprev = x;
            samples[r] = xprev;
            r++;
        }
    }

    public double getFreq() {return freq; }
    public double getAmplitude() { return amplitude; }
    public double[] getSamples() { return samples; }
}