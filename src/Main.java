import java.awt.*;
import javax.swing.*;

/**
 * Created by nxex3708 on 3/20/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        // from Oracle's tutorial
        // https://docs.oracle.com/javase/tutorial/uiswing/start/compile.html
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Test!");
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);
    }
}
