public class Main {
    public static void main(String[] args)
    {
        MyFrame frame = new MyFrame("Java App");
        frame.setIcon("./java-icon.png");
        frame.setBackground(89, 242, 12);

        MyPanel top = new MyPanel(0, 0, 500, 250);
        top.setBackground(255, 0, 0);

        MyPanel bottom = new MyPanel(0, 250, 500, 250);
        bottom.setBackground(0, 0, 255);

        frame.add(top);
        frame.add(bottom);
    }
}