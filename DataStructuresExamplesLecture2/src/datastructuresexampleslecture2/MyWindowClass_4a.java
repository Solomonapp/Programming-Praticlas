import java.awt.*;
import javax.swing.*;

public class MyWindowClass_4a extends JFrame
{
    
    public MyWindowClass_4a()
    {
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(360, 500));
        
        JButton tbutton = new JButton("Top");
        add(tbutton, BorderLayout.PAGE_START);
        
        JButton bbutton = new JButton("Bottom");
        add(bbutton, BorderLayout.PAGE_END);
        
        JButton lbutton = new JButton("Left");
        lbutton.setPreferredSize(new Dimension(200, 100));
        add(lbutton, BorderLayout.LINE_START);
        
        JButton rbutton = new JButton("Right");
        add(rbutton, BorderLayout.LINE_END);
        
        JButton cbutton = new JButton("Centre");
        cbutton.setPreferredSize(new Dimension(200, 100));
        add(cbutton, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }


    public static void main(String[] args)
    {
        MyWindowClass_4a myWindow = new MyWindowClass_4a();
    }

}
