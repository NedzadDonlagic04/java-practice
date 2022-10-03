import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
    MyFrame(String appName)
    {
        this(appName, false, 500, 500, true);
    }

    MyFrame(String appName, boolean resizable, int width, int height, boolean visibility)
    {
        this.setTitle(appName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(resizable);
        this.setSize(width, height);
        this.setVisible(visibility);
    }

    public void setIcon(String path)
    {
        ImageIcon image = new ImageIcon(path);
        this.setIconImage(image.getImage());
    }

    public void setBackground(int r, int g, int b)
    {
        this.getContentPane().setBackground(new Color(r, g, b));
    }
}
