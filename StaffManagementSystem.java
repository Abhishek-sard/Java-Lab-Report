import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class StaffManagementSystem extends JFrame {
    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Staffdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Replace with your MySQL password

    // UI Components
    private JTextField staffIdField, staffNameField, staffContactField, staffSalaryField, staffAddressField, authorField;
    private JButton addButton, updateButton, deleteButton, viewButton;
    private JTextArea displayArea;

    public StaffManagementSystem() {
        setTitle("Staff Management System");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        staffIdField = new JTextField(10);
        staffNameField = new JTextField(20);
        staffContactField = new JTextField(15);
        staffSalaryField = new JTextField(10);
        staffAddressField = new JTextField(30);
        authorField = new JTextField(20);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        viewButton = new JButton("View");

        displayArea = new JTextArea(10, 50);
        displayArea.setEditable(false);

        // Layout
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        inputPanel.add(new JLabel("Staff ID:"));
        inputPanel.add(staffIdField);
        inputPanel.add(new JLabel("Staff Name:"));
        inputPanel.add(staffNameField);
        inputPanel.add(new JLabel("Staff Contact:"));
        inputPanel.add(staffContactField);
        inputPanel.add(new JLabel("Staff Salary:"));
        inputPanel.add(staffSalaryField);
        inputPanel.add(new JLabel("Staff Address:"));
        inputPanel.add(staffAddressField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        JPanel displayPanel = new JPanel();
        displayPanel.add(new JScrollPane(displayArea));

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.SOUTH);

        // Event Handling
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStaff();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStaff();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStaff();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStaff();
            }
        });
    }

    private void addStaff() {
        String name = staffNameField.getText();
        String contact = staffContactField.getText();
        double salary = Double.parseDouble(staffSalaryField.getText());
        String address = staffAddressField.getText();
        String author = authorField.getText();
        LocalDate dateOfEntry = LocalDate.now();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = connection.prepareStatement("INSERT INTO Staff (staff_name, staff_contact, staff_salary, staff_address, date_of_entry, author) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, name);
            ps.setString(2, contact);
            ps.setDouble(3, salary);
            ps.setString(4, address);
            ps.setDate(5, Date.valueOf(dateOfEntry));
            ps.setString(6, author);

            ps.executeUpdate();
            displayArea.append("Staff added successfully.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            displayArea.append("Error adding staff.\n");
        }
    }

    private void updateStaff() {
        int id = Integer.parseInt(staffIdField.getText());
        String name = staffNameField.getText();
        String contact = staffContactField.getText();
        double salary = Double.parseDouble(staffSalaryField.getText());
        String address = staffAddressField.getText();
        String author = authorField.getText();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = connection.prepareStatement("UPDATE Staff SET staff_name = ?, staff_contact = ?, staff_salary = ?, staff_address = ?, author = ? WHERE staff_id = ?")) {

            ps.setString(1, name);
            ps.setString(2, contact);
            ps.setDouble(3, salary);
            ps.setString(4, address);
            ps.setString(5, author);
            ps.setInt(6, id);

            ps.executeUpdate();
            displayArea.append("Staff updated successfully.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            displayArea.append("Error updating staff.\n");
        }
    }

    private void deleteStaff() {
        int id = Integer.parseInt(staffIdField.getText());

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = connection.prepareStatement("DELETE FROM Staff WHERE staff_id = ?")) {

            ps.setInt(1, id);

            ps.executeUpdate();
            displayArea.append("Staff deleted successfully.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            displayArea.append("Error deleting staff.\n");
        }
    }

    private void viewStaff() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Staff")) {

            displayArea.setText("");
            while (rs.next()) {
                int id = rs.getInt("staff_id");
                String name = rs.getString("staff_name");
                String contact = rs.getString("staff_contact");
                double salary = rs.getDouble("staff_salary");
                String address = rs.getString("staff_address");
                Date dateOfEntry = rs.getDate("date_of_entry");
                String author = rs.getString("author");

                displayArea.append(String.format("ID: %d, Name: %s, Contact: %s, Salary: %.2f, Address: %s, Date: %s, Author: %s\n", id, name, contact, salary, address, dateOfEntry, author));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            displayArea.append("Error viewing staff.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StaffManagementSystem frame = new StaffManagementSystem();
            frame.setVisible(true);
        });
    }
}

