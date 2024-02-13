import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartPage implements ActionListener {

    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
    JTextField textField1;
    JButton Next;

    public StartPage() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 50, 800, 700);
        frame.setTitle("Start Page");
        
        Container c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        label1 = new JLabel("*********************************************");
        label1.setVisible(true);
        label1.setBounds(140, 50, 450, 20);
        Font font1 = new Font("Arial",Font.BOLD,25);
        label1.setFont(font1);
        c.add(label1);

        label2 = new JLabel(" WELCOME TO THE VENDING MACHINE");
        label2.setVisible(true);
        label2.setBounds(160, 70, 450, 20);
        Font font2 = new Font("Arial",Font.BOLD,20);
        label2.setFont(font2);
        c.add(label2);

        label3 = new JLabel("*********************************************");
        label3.setVisible(true);
        label3.setBounds(140, 100, 450, 20);
        Font font3 = new Font("Arial",Font.BOLD,25);
        label3.setFont(font3);
        c.add(label3);

        label4 = new JLabel("Products available :");
        label4.setVisible(true);
        label4.setBounds(200, 150, 450, 20);
        Font font4 = new Font("Arial",Font.BOLD,18);
        label4.setFont(font4);
        c.add(label4);

        label5 = new JLabel("1  TWIX - Price: 100");
        label5.setVisible(true);
        label5.setBounds(190, 200, 200, 20);
        Font font5 = new Font("Arial",Font.BOLD,18);
        label5.setFont(font5);
        c.add(label5);

        label6 = new JLabel("2  COKE - Price: 50");
        label6.setVisible(true);
        label6.setBounds(190, 230, 200, 20);
        Font font6 = new Font("Arial",Font.BOLD,18);
        label6.setFont(font6);
        c.add(label6);

        label7 = new JLabel("3  WATER - Price: 30");
        label7.setVisible(true);
        label7.setBounds(190, 260, 200, 20);
        Font font7 = new Font("Arial",Font.BOLD,18);
        label7.setFont(font7);
        c.add(label7);

        label8 = new JLabel("4  SANDWICH - Price: 150");
        label8.setVisible(true);
        label8.setBounds(190, 290, 230, 20);
        Font font8 = new Font("Arial",Font.BOLD,18);
        label8.setFont(font8);
        c.add(label8);

        label9 = new JLabel("Please select your product :");
        label9.setVisible(true);
        label9.setBounds(70, 370, 250, 20);
        Font font9 = new Font("Arial",Font.BOLD,18);
        label9.setFont(font9);
        c.add(label9);

        textField1 = new JTextField();
        textField1.setVisible(true);
        textField1.setBounds(350, 370, 100, 30);
        c.add(textField1);

        Next = new JButton(" Next ");
        Next.setVisible(true);
        Next.setBounds(240, 420, 200, 50);
        Font font10 = new Font("Times New Roman",Font.BOLD,20);
        Next.setFont(font10);
        Next.addActionListener(this);
        c.add(Next);

        label10 = new JLabel("");
        label10.setVisible(true);
        label10.setBounds(70, 500, 400, 20);
        Font font11 = new Font("Arial",Font.BOLD,18);
        label10.setFont(font11);
        c.add(label10);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            String userInput = textField1.getText();
            if (!userInput.isEmpty()) {
                int userInputInt = Integer.parseInt(userInput);
    
                if (userInputInt <= 4) {
                    Coins c = new Coins(userInputInt);
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                    currentFrame.dispose();
                } else {
                    label10.setText("Please Enter a Number between 1 to 4...!!");
                }
            } else {
                label10.setText("Please Enter a Number...!!");
            }
        } catch (NumberFormatException e1) {
            label10.setText("Please Enter a Valid Number...!!");
        } catch (Exception e1) {
            System.out.println(e1);
        }
    }
    

    public static void main(String[] args) {
        new StartPage();
    }
   

}
