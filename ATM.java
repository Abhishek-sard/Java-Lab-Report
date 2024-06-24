import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM extends JFrame implements ActionListener {
    private double balance = 0.0;
    
    private JLabel label;
    private JButton depositButton, withdrawButton, balanceButton, exitButton;
    private JTextField amountField;
    
    public ATM() {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        label = new JLabel("Enter amount:");
        amountField = new JTextField(15);
        
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        balanceButton = new JButton("Check Balance");
        exitButton = new JButton("Exit");

        // Add ActionListeners
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        balanceButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Layout
        setLayout(new GridLayout(5, 2));
        add(label);
        add(amountField);
        add(depositButton);
        add(withdrawButton);
        add(balanceButton);
        add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amountText = amountField.getText();
        double amount = 0.0;

        if (!amountText.isEmpty()) {
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (e.getSource() == depositButton) {
            if (amount > 0) {
                balance += amount;
                JOptionPane.showMessageDialog(this, "Deposited: $" + amount, "Transaction Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a positive amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == withdrawButton) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                JOptionPane.showMessageDialog(this, "Withdrew: $" + amount, "Transaction Successful", JOptionPane.INFORMATION_MESSAGE);
            } else if (amount > balance) {
                JOptionPane.showMessageDialog(this, "Insufficient balance.", "Transaction Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a positive amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == balanceButton) {
            JOptionPane.showMessageDialog(this, "Current balance: $" + balance, "Balance Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }

        amountField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATM atm = new ATM();
            atm.setVisible(true);
        });
    }
}
