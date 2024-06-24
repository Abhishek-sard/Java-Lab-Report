import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArithmeticOperations extends JFrame {
    private JTextField number1Field, number2Field;
    private JComboBox<String> operationBox;
    private JLabel resultLabel;

    public ArithmeticOperations() {
        setTitle("Arithmetic Operations");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Number 1:"));
        number1Field = new JTextField();
        panel.add(number1Field);

        panel.add(new JLabel("Number 2:"));
        number2Field = new JTextField();
        panel.add(number2Field);

        panel.add(new JLabel("Operation:"));
        String[] operations = {"+", "-", "*", "/"};
        operationBox = new JComboBox<>(operations);
        panel.add(operationBox);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        panel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        panel.add(resultLabel);

        add(panel);
    }

    private class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double number1 = Double.parseDouble(number1Field.getText());
                double number2 = Double.parseDouble(number2Field.getText());
                String operation = (String) operationBox.getSelectedItem();
                double result = 0;

                switch (operation) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                }

                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArithmeticOperations frame = new ArithmeticOperations();
            frame.setVisible(true);
        });
    }
}
