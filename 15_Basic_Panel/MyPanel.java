import javax.swing.JPanel;
import java.awt.Color;

public class MyPanel extends JPanel {
    MyPanel(int x, int y, int width, int height)
    {
        this.setBounds(x, y, width, height);
    }
    
    public void setBackground(int r, int g, int b)
    {
        this.setBackground(new Color(r, g, b));
    }
}
