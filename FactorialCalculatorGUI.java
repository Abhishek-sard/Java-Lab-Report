import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactorialCalculatorGUI extends JFrame {
    private JTextField numberField;
    private JLabel resultLabel;

    public FactorialCalculatorGUI() {
        setTitle("Factorial Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel enterLabel = new JLabel("Enter a number:");
        numberField = new JTextField();
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel();

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = numberField.getText();
                try {
                    int number = Integer.parseInt(input);
                    if (number < 0) {
                        resultLabel.setText("Factorial is not defined for negative numbers.");
                    } else {
                        int result = factorial(number);
                        resultLabel.setText("Factorial of " + number + " is: " + result);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input! Please enter a valid number.");
                }
            }
        });

        panel.add(enterLabel);
        panel.add(numberField);
        panel.add(calculateButton);

        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case: factorial of 0 or 1 is 1
        } else {
            return n * factorial(n - 1); // Recursive call to find factorial
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FactorialCalculatorGUI().setVisible(true);
            }
        });
    }
}
