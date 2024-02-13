import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Coins implements ActionListener {

    JLabel label1, label2, label3, label4, label5;
    JTextField textField1;
    JButton Next;

    int selectedProduct;

    public Coins(int selectedProduct) {
        this.selectedProduct = selectedProduct;

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 50, 800, 800);
        frame.setTitle("Calculation Page");

        Container c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        label1 = new JLabel("Please enter coins as follows:");
        label1.setVisible(true);
        label1.setBounds(30, 60, 300, 20);
        Font font1 = new Font("Arial", Font.BOLD, 15);
        label1.setFont(font1);
        c.add(label1);

        label2 = new JLabel("num of 5 cents coins,num of 10 cents coins,num of 20 cents coins,num of 50 cents coins,num of 100 cents coins");
        label2.setVisible(true);
        label2.setBounds(50, 90, 800, 20);
        Font font2 = new Font("Arial", Font.BOLD, 12);
        label2.setFont(font2);
        c.add(label2);

        label3 = new JLabel("Example: If you would like to enter 2 ten cents coins: 0,2,0,0,0");
        label3.setVisible(true);
        label3.setBounds(60, 130, 500, 20);
        Font font3 = new Font("Arial", Font.BOLD, 17);
        label3.setFont(font3);
        c.add(label3);

        label4 = new JLabel("Please enter coins :");
        label4.setVisible(true);
        label4.setBounds(60, 200, 300, 20);
        Font font4 = new Font("Arial", Font.BOLD, 18);
        label4.setFont(font4);
        c.add(label4);

        textField1 = new JTextField();
        textField1.setVisible(true);
        textField1.setBounds(300, 200, 100, 27);
        c.add(textField1);

        Next = new JButton(" Next ");
        Next.setVisible(true);
        Next.setBounds(270, 300, 200, 50);
        Font font10 = new Font("Times New Roman", Font.BOLD, 20);
        Next.setFont(font10);
        Next.addActionListener(this);
        c.add(Next);

        label5 = new JLabel("");
        label5.setVisible(true);
        label5.setBounds(60, 370, 600, 200);
        Font font11 = new Font("Arial", Font.BOLD, 18);
        label5.setFont(font11);
        c.add(label5);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String userEnteredCoins = textField1.getText();
            if (!userEnteredCoins.isEmpty()) {
                int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
                VendingMachineRequest request = new VendingMachineRequest(selectedProduct, enteredCoins);
                SimpleVendingMachineController controller = new SimpleVendingMachineController();
                CoinBundle change = controller.calculateChange(request);

                // Update label5 with change information
                label5.setText("<html>Your change is: " + change.getTotal() + " cents split as follows:<br>" +
                        "&nbsp;&nbsp;&nbsp;100 cents coins: " + change.number100CentsCoins + "<br>" +
                        "&nbsp;&nbsp;&nbsp;50 cents coins: " + change.number50CentsCoins + "<br>" +
                        "&nbsp;&nbsp;&nbsp;20 cents coins: " + change.number20CentsCoins + "<br>" +
                        "&nbsp;&nbsp;&nbsp;10 cents coins: " + change.number10CentsCoins + "<br>" +
                        "&nbsp;&nbsp;&nbsp;5 cents coins: " + change.number5CentsCoins + "</html>");
            } else {
                // Handle case where no coins are entered
                label5.setText("No coins entered");
            }
        } catch (NumberFormatException e1) {
            // Handle invalid coin format
            label5.setText("Invalid coin format");
        } catch (Exception e1) {
            // Handle other exceptions
            label5.setText("Error: " + e1.getMessage());
        }
    }

    public static void main(String[] args) {
        new Coins(1);  // Pass the selected product as an argument
    }
}
