import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class runner {
    public static void main(String[] args){
    String[] operators = {"Sine","Sawtooth"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...","FMSynth",
                JOptionPane.QUESTION_MESSAGE, null,
                operators, operators[1]);
        Operator a;
        Operator t;
        Operator b;
        switch(input) {
            case ("Sine"): {
                a = new Sine(100);
                break;
            }
            //case("Sawtooth"):{a = new Sawtooth();int i = 0;break;}
            default: {
                a = new Sine(440);
                t = new Sine(440);
                b = new Sine(440);
            }
        }
        int i = 0;
        double freq = 5;
        while(i < 10){
            freq -= 10;
            //StdAudio.play(b.getSamples()); i++;
            }
        //a.changeFreq(30);
        //StdAudio.play(a.getSamples());

    }
}


