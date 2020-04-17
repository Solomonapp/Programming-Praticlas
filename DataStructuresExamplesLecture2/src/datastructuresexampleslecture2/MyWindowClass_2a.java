import java.awt.*;
import javax.swing.*;

public class MyWindowClass_2a extends JFrame
{
    public MyWindowClass_2a()
    {
        GridLayout layoutObj = new GridLayout();
        setPreferredSize(new Dimension(360, 500));
        setLayout(layoutObj);
        
        JButton[] buttons = new JButton[5];
        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Button " + i);
            add(buttons[i]);
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }


    public static void main(String[] args)
    {
        MyWindowClass_2a myWindow = new MyWindowClass_2a();
    }

}
