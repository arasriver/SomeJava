package Git;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class TemperatureConverterGUI {
    private static final String[] UNITS = {"Celsius (°C)", "Fahrenheit (°F)", "Kelvin (K)"};
    private static final DecimalFormat DF = new DecimalFormat("0.##");

    public static void main(String[] args){
        SwingUtilities.invokeLater(TemperatureConverterGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 180);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel inputLabel = new JLabel("Value:");
        JTextField inputField = new JTextField(10);

        JLabel fromLabel = new JLabel("From:");
        JComboBox<String> fromCombo = new JComboBox<>(UNITS);

        JLabel toLabel = new JLabel("To:");
        JComboBox<String> toCombo = new JComboBox<>(UNITS);
        toCombo.setSelectedIndex(1); // default different unit

        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result: ");

        // Layout rows
        gbc.gridx = 0; gbc.gridy = 0; frame.add(inputLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; frame.add(inputField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; frame.add(fromLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; frame.add(fromCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 2; frame.add(toLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; frame.add(toCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; frame.add(convertButton, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; frame.add(resultLabel, gbc);

        // Action
        convertButton.addActionListener((ActionEvent e) -> {
            String text = inputField.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a value.");
                return;
            }
            double value;
            try {
                value = Double.parseDouble(text);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid number.");
                return;
            }

            int fromIdx = fromCombo.getSelectedIndex();
            int toIdx = toCombo.getSelectedIndex();

            double celsius = toCelsius(value, fromIdx);
            double converted = fromCelsius(celsius, toIdx);

            resultLabel.setText("Result: " + DF.format(converted) + " " + unitSymbol(toIdx));
        });

        frame.setVisible(true);
    }

    // Convert input value to Celsius based on selected source unit
    private static double toCelsius(double value, int fromIdx) {
        switch (fromIdx) {
            case 0: // C
                return value;
            case 1: // F
                return (value - 32) * 5.0 / 9.0;
            case 2: // K
                return value - 273.15;
            default:
                return value;
        }
    }

    // Convert Celsius to target unit
    private static double fromCelsius(double c, int toIdx) {
        switch (toIdx) {
            case 0: // C
                return c;
            case 1: // F
                return (c * 9.0 / 5.0) + 32;
            case 2: // K
                return c + 273.15;
            default:
                return c;
        }
    }

    private static String unitSymbol(int idx) {
        switch (idx) {
            case 0: return "°C";
            case 1: return "°F";
            case 2: return "K";
            default: return "";
        }
    }
}
