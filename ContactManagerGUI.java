package Git;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ContactManagerGUI {
    private static DefaultTableModel model;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContactManagerGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Table setup
        String[] columns = {"Name", "Email"};
        model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete Selected");
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();

            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter both name and email.");
                return;
            }

            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
                JOptionPane.showMessageDialog(frame, "Invalid email format.");
                return;
            }

            model.addRow(new Object[]{name, email});
            nameField.setText("");
            emailField.setText("");
        });

        // Delete button action
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row to delete.");
            }
        });

        frame.setVisible(true);
    }
}
