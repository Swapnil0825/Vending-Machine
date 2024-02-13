import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Welcome extends JFrame implements ActionListener{

    Container c;
    JButton Start;

    public Welcome () {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        Start = new JButton("Start the Machine");
        Start.setVisible(true);
        Start.setBounds(100, 150, 200, 50);
        Font font1 = new Font("Times New Roman",Font.BOLD,20);
        Start.setFont(font1);
        Start.addActionListener(this);
        c.add(Start);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            StartPage s = new StartPage();
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
            currentFrame.dispose();
            
            
        } catch (Exception e1) {
           System.out.println(e1);
        }
        
    }
}

public class WelcomePage {
    public static void main(String[] args) {
        Welcome w = new Welcome();
        w.setVisible(true);
        w.setBounds(100, 50, 400, 400);
        w.setTitle("Welcome Page");     
        
    }

}
