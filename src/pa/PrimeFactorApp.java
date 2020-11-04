package pa;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class PrimeFactorApp implements ActionListener {
    private JFrame frame;
    private JButton button1;
    private JLabel label;
    private JLabel label1;
    private JTextField number;

    public PrimeFactorApp(int x, int y) {
        frame = new JFrame("Factoring App");
        label = new JLabel("Enter a number to factorize: ");
        number = new JTextField("");
        label1 = new JLabel("");
        button1 = new JButton("Find Prime Factorization");

        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(label);
        frame.add(number);
        frame.add(label1);
        frame.add(button1);

        button1.addActionListener(this);
        frame.setSize(x, y);
        frame.setLayout(new GridLayout(5, 1, 20, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public static boolean a(String s)
    {
        boolean answer = false;
        try{
            Long.parseLong(s);
            answer=true;
        }
        catch (NumberFormatException et){

        }
        return answer;
    }


    public void actionPerformed(ActionEvent e) {
        boolean b = a(number.getText());

        if (b && Long.parseLong(number.getText()) > 999999999) {
            label1.setText("Input number can be no longer than 999999999");
        } else if (b && Long.parseLong(number.getText()) > 1) {
            long nm = Long.parseLong(number.getText());
            primenum(nm);
        } else {
            label1.setText("Invalid input");
        }
    }
    public void primenum (long nm){
        long in = Long.parseLong(number.getText());
        nm = Long.parseLong(number.getText());
        String out=("");
        for (int i = 2; i < nm; i++) {
            while (nm % i == 0) {
                nm = nm / i;
                out += (i + "x");

            }

        }
        label1.setText("The prime factorizartion of " + in + " is " + out
                + "" + nm);

    }

    public static void main(String[] args) {
        new PrimeFactorApp(600,400);
    }
}

