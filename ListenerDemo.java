import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListenerDemo extends JFrame {
    public ListenerDemo() {
        setTitle("Listener Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton button = new JButton("Click Me");
        button.addActionListener(e -> JOptionPane.showMessageDialog(this, "Button Clicked"));
        add(button, BorderLayout.SOUTH);

        JTextField textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                textField.setText("Key Pressed: " + e.getKeyChar());
            }
        });
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(ListenerDemo.this, "Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
            }
        });
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListenerDemo().setVisible(true));
    }
}
