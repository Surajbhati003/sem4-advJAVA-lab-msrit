package slab8;
/*Write a program that uses Java Swing and JDBC to create a stand-alone application.
Create a table named Customer (CustNo, CustName, State, Credit_Limit) in MySQL
database. Use appropriate Swing components to insert values in a form and populate
the MySQL table. Using JDBC, display the Customer table.*/
// using custid as auto_increment no need to take input 
// CREATE TABLE Customer (CustNo INT NOT NULL AUTO_INCREMENT,CustName VARCHAR(15),State VARCHAR(15),Credit_Limit INT,PRIMARY KEY (CustNo));

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainApp extends JFrame {
    // JDBC URL, username, password
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "suraj";
    private static final String PASSWORD = "Sur_12345";

    // GUI components
    private JTextField custNameField, stateField, creditLimitField;
    private JButton insertButton, displayButton;

    public MainApp() {
        setTitle("Customer Database");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Create and add GUI components
        add(new JLabel("Customer Name:"));
        custNameField = new JTextField();
        add(custNameField);

        add(new JLabel("State:"));
        stateField = new JTextField();
        add(stateField);

        add(new JLabel("Credit Limit:"));
        creditLimitField = new JTextField();
        add(creditLimitField);

        insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertCustomer();
            }
        });
        add(insertButton);

        displayButton = new JButton("Display");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCustomers();
            }
        });
        add(displayButton);
    }

    private void insertCustomer() {
        String custName = custNameField.getText();
        String state = stateField.getText();
        String creditLimitStr = creditLimitField.getText();
        double creditLimit;

        try {
            creditLimit = Double.parseDouble(creditLimitStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid credit limit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Customer (CustName, State, Credit_Limit) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, custName);
            preparedStatement.setString(2, state);
            preparedStatement.setDouble(3, creditLimit);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Customer inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inserting customer", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayCustomers() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Customer";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            StringBuilder results = new StringBuilder();

            while (resultSet.next()) {
                int custNo = resultSet.getInt("CustNo");
                String custName = resultSet.getString("CustName");
                String state = resultSet.getString("State");
                double creditLimit = resultSet.getDouble("Credit_Limit");
                results.append("CustNo: ").append(custNo)
                       .append(", CustName: ").append(custName)
                       .append(", State: ").append(state)
                       .append(", Credit Limit: ").append(creditLimit).append("\n");
            }

            JOptionPane.showMessageDialog(this, results.toString(), "Customer List", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error displaying customers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }
}
