import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class runner {
    public static void main(String[] args){
    String[] operators = {"Sin","Sawtooth"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "FMSynth", JOptionPane.QUESTION_MESSAGE, null, // Use
                // default
                // icon
                operators, // Array of choices
                operators[1]); // Initial choice
        switch(input){
            case("Sin"):{Sine a = new Sine(); int i = 0;
                while(i < 5){StdAudio.play(a.getSamples()); i++;}break;}

            case("Sawtooth"):{Sawtooth a = new Sawtooth();int i = 0;
                while(i < 5){StdAudio.play(a.getSamples()); i++;}break;}
        }
    }
}


