import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventListenerDemo extends JFrame {
    private JTextArea textArea;
    private JButton button;

    public EventListenerDemo() {
        setTitle("Event Listener Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        textArea = new JTextArea();
        textArea.setFocusable(true);
        button = new JButton("Click Me");

        // Set layout and add components
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        // Add listeners
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button clicked!\n");
            }
        });

        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textArea.append("Key typed: " + e.getKeyChar() + "\n");
            }
        });

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.append("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")\n");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EventListenerDemo frame = new EventListenerDemo();
            frame.setVisible(true);
        });
    }
}

