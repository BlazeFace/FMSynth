import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class runner {
    public static void main(String[] args){
    String[] operators = {"Sine","Sawtooth"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
                // default
                // icon
                operators, // Array of choices
                operators[1]); // Initial choice
        System.out.println(input);
    }
}
