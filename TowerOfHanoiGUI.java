import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TowerOfHanoiGUI extends JFrame {
    private JLabel messageLabel;
    private int numDisks;
    private char source = 'A';
    private char destination = 'C';
    private char auxiliary = 'B';
    private int moveCount = 0;

    public TowerOfHanoiGUI(int numDisks) {
        this.numDisks = numDisks;
        setTitle("Tower of Hanoi");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        messageLabel = new JLabel();
        add(messageLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveCount = 0;
                moveTower(numDisks, source, destination, auxiliary);
            }
        });
        add(startButton, BorderLayout.SOUTH);
    }

    public void moveTower(int numDisks, char source, char destination, char auxiliary) {
        if (numDisks == 1) {
            moveCount++;
            messageLabel.setText("Move disk 1 from " + source + " to " + destination + ". Moves: " + moveCount);
            delay(1000);
        } else {
            moveTower(numDisks - 1, source, auxiliary, destination);
            moveCount++;
            messageLabel.setText("Move disk " + numDisks + " from " + source + " to " + destination + ". Moves: " + moveCount);
            delay(1000);
            moveTower(numDisks - 1, auxiliary, destination, source);
        }
    }

    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                int numDisks = 3; // Default number of disks
                try {
                    numDisks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of disks:"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Using default value (3).");
                }
                new TowerOfHanoiGUI(numDisks).setVisible(true);
            }
        });
    }
}
