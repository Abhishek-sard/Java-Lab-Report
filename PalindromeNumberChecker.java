import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeNumberChecker extends JFrame {
    private JTextField numberField;
    private JLabel resultLabel;

    public PalindromeNumberChecker() {
        setTitle("Palindrome Number Checker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel enterLabel = new JLabel("Enter a number:");
        numberField = new JTextField();
        JButton checkButton = new JButton("Check");
        resultLabel = new JLabel();

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = numberField.getText();
                try {
                    int number = Integer.parseInt(input);
                    if (isPalindrome(number)) {
                        resultLabel.setText(number + " is a palindrome.");
                    } else {
                        resultLabel.setText(number + " is not a palindrome.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input! Please enter a valid number.");
                }
            }
        });

        panel.add(enterLabel);
        panel.add(numberField);
        panel.add(checkButton);

        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
    }

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        return originalNumber == reversedNumber;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PalindromeNumberChecker().setVisible(true);
            }
        });
    }
}
