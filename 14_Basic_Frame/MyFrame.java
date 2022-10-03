import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
    MyFrame()
    {
        this.setTitle("My First Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420, 420);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("./freeIcon.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(89, 242, 12));
    }
}
