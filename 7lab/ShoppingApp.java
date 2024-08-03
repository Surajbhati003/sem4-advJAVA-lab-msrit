package slab7;
/*Write a java program using Swing to perform the following:
Allow the user to enter the item purchased by giving the item id and quantity
purchased.
On clicking of a button, the item name and the total cost should appear in the
corresponding GUI components.
Using option dialog box, indicate the types of discount available for the
customer. On clicking on the print button, print the details of final cost in
information dialog box.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class ShoppingApp extends JFrame {
    private JTextField itemIdField, quantityField;
    private JLabel itemNameLabel, totalCostLabel;
    private JButton calculateButton, printButton;
    // Sample item data
    private HashMap<String, String> itemNames = new HashMap<>();
    private HashMap<String, Double> itemPrices = new HashMap<>();

    public ShoppingApp() {
        // Initialize sample item data
        itemNames.put("101", "Apple");
        itemPrices.put("101", 0.5);
        itemNames.put("102", "Banana");
        itemPrices.put("102", 0.2);
        itemNames.put("103", "Orange");
        itemPrices.put("103", 0.3);

        // Set up the frame
        setTitle("Shopping Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Create components
        JLabel itemIdLabel = new JLabel("Item ID:");
        itemIdField = new JTextField();
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();
        itemNameLabel = new JLabel("Item Name: ");
        totalCostLabel = new JLabel("Total Cost: ");
        calculateButton = new JButton("Calculate");
        printButton = new JButton("Print");

        // Add components to frame
        add(itemIdLabel);
        add(itemIdField);
        add(quantityLabel);
        add(quantityField);
        add(itemNameLabel);
        add(totalCostLabel);
        add(calculateButton);
        add(printButton);

        // Add button listeners
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotalCost();
            }
        });

        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printFinalCost();
            }
        });
    }

    private void calculateTotalCost() {
        String itemId = itemIdField.getText();
        int quantity;
        try {
            quantity = Integer.parseInt(quantityField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (itemNames.containsKey(itemId) && itemPrices.containsKey(itemId)) {
            String itemName = itemNames.get(itemId);
            double price = itemPrices.get(itemId);
            double totalCost = price * quantity;
            itemNameLabel.setText("Item Name: " + itemName);
            totalCostLabel.setText("Total Cost: $" + totalCost);
        } else {
            itemNameLabel.setText("Item Name: ");
            totalCostLabel.setText("Total Cost: ");
            JOptionPane.showMessageDialog(this, "Invalid Item ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void printFinalCost() {
        String[] discountOptions = {"None", "10%", "20%", "30%"};
        String selectedDiscount = (String) JOptionPane.showInputDialog(this,
                "Select Discount",
                "Discount Options",
                JOptionPane.QUESTION_MESSAGE,
                null,
                discountOptions,
                discountOptions[0]);

        if (selectedDiscount == null) {
            return; // User canceled
        }

        double discount = 0;
        switch (selectedDiscount) {
            case "10%":
                discount = 0.10;
                break;
            case "20%":
                discount = 0.20;
                break;
            case "30%":
                discount = 0.30;
                break;
        }

        String itemName = itemNameLabel.getText().replace("Item Name: ", "");
        String totalCostStr = totalCostLabel.getText().replace("Total Cost: $", "");

        double totalCost;
        try {
            totalCost = Double.parseDouble(totalCostStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Total cost is not a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double finalCost = totalCost * (1 - discount);
        JOptionPane.showMessageDialog(this,
                "Item Name: " + itemName + "\nTotal Cost: $" + totalCost + "\nDiscount: " +
                        selectedDiscount + "\nFinal Cost: $" + finalCost,
                "Final Cost",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShoppingApp().setVisible(true);
            }
        });
    }
}
