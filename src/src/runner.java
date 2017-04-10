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
        switch(input){
            case("Sine"):{a = new Sine();break;}
            case("Sawtooth"):{a = new Sawtooth();int i = 0;break;}
            default:{a = new Sine();}
        }
        Sine t = new Sine(a.getSamples());
        StdAudio.play(a.getSamples());
        StdAudio.play(t.getSamples());
    }
}


