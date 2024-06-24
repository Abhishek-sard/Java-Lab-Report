import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrickandTractor extends JFrame implements ActionListener {
    private JButton calculateButton;
    private JTextField wallLengthField, wallBreadthField, brickLengthField, brickBreadthField, tractorCapacityField,
            distanceField;
    private JLabel outputLabel;

    public BrickandTractor() {
        setTitle("Brick And Tractor Cost System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new GridLayout(8, 2, 5, 5));

        // Initialize text fields
        wallLengthField = new JTextField();
        wallBreadthField = new JTextField();
        brickLengthField = new JTextField();
        brickBreadthField = new JTextField();
        tractorCapacityField = new JTextField();
        distanceField = new JTextField();

        // Initialize button and output label
        calculateButton = new JButton("Calculate");
        outputLabel = new JLabel("Please Enter Details and Calculate");

        // Add components to the frame
        add(new JLabel("Wall length (feet):"));
        add(wallLengthField);
        add(new JLabel("Wall breadth (feet):"));
        add(wallBreadthField);
        add(new JLabel("Brick length (cm):"));
        add(brickLengthField);
        add(new JLabel("Brick breadth (cm):"));
        add(brickBreadthField);
        add(new JLabel("Tractor capacity of Bricks (Pieces):"));
        add(tractorCapacityField);
        add(new JLabel("Distance (km):"));
        add(distanceField);
        add(calculateButton);
        add(outputLabel);

        // Center the window
        setLocationRelativeTo(null);

        // Add action listener for the button
        calculateButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                // Parse input values from text fields
                double wallLength = Double.parseDouble(wallLengthField.getText());
                double wallBreadth = Double.parseDouble(wallBreadthField.getText());
                double brickLength = Double.parseDouble(brickLengthField.getText());
                double brickBreadth = Double.parseDouble(brickBreadthField.getText());
                double tractorCapacity = Double.parseDouble(tractorCapacityField.getText());
                double distance = Double.parseDouble(distanceField.getText());

                // Calculate the number of bricks required
                double noOfBricksRequired = (wallLength * wallBreadth * 144) / (brickLength * brickBreadth);

                // Calculate the cost of bricks
                double costOfBricks = noOfBricksRequired * 45;

                // Calculate the number of tractors required
                double noOfTractorsRequired = Math.ceil(noOfBricksRequired / tractorCapacity);

                // Calculate transportation cost based on distance
                double costOfTransportation;
                if (distance <= 20) {
                    costOfTransportation = 200 * noOfTractorsRequired;
                } else if (distance <= 30) {
                    costOfTransportation = 300 * noOfTractorsRequired;
                } else {
                    costOfTransportation = 500 * noOfTractorsRequired;
                }

                // Calculate total cost
                double totalCost = costOfBricks + costOfTransportation;

                // Display the result
                outputLabel.setText(
                        "<html>Total number of tractors required: " + String.format("%.0f", noOfTractorsRequired)
                                + "<br>Total cost: Rs " + String.format("%.2f", totalCost) + "</html>");

            } catch (NumberFormatException ex) {
                // Handle invalid input
                outputLabel.setText("Please enter valid numbers in all fields.");
            }
        }
    }

    public static void main(String[] args) {
        new BrickandTractor();
    }
}

