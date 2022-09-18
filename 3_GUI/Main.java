import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name: ");
        String surname = JOptionPane.showInputDialog("Enter your surname: ");
        
        int age = Integer.parseInt( JOptionPane.showInputDialog("Enter your age: ") );

        String output = "Hello " + name + ' ' + surname + ".\nYou are " + age + " years old.";

        JOptionPane.showMessageDialog(null, output);
    }
}
