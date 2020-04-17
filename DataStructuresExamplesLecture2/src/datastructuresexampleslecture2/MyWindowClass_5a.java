import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyWindowClass_5a extends JFrame
{
    public MyWindowClass_5a() 
    {
        setLayout(new GridLayout(5,1));
        setPreferredSize(new Dimension(360, 500));
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel1.setBorder(new TitledBorder(new EtchedBorder(), "Panel 1"));            
        add(panel1);
        JButton[] panel1buttons = new JButton[3];
        for(int i = 0; i < panel1buttons.length; i++) {
            panel1buttons[i] = new JButton("Button " + i);
            panel1.add(panel1buttons[i]);
        }
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.TRAILING));
        panel2.setBorder(new TitledBorder(new EtchedBorder(), "Panel 2"));            
        add(panel2);
        JButton[] panel2buttons = new JButton[3];
        for(int i = 0; i < panel2buttons.length; i++) {
            panel2buttons[i] = new JButton("Button " + i);
            panel2.add(panel2buttons[i]);
        }

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel3.setBorder(new TitledBorder(new EtchedBorder(), "Panel 3"));            
        add(panel3);
        JButton[] panel3buttons = new JButton[3];
        for(int i = 0; i < panel3buttons.length; i++) {
            panel3buttons[i] = new JButton("Button " + i);
            panel3.add(panel3buttons[i]);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
    }


    public static void main(String[] args)
    {
        MyWindowClass_5a myWindow = new MyWindowClass_5a();
    }

}
