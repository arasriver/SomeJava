package Git;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel label1 = new JLabel("First Number:");
        JTextField num1Field = new JTextField();

        JLabel label2 = new JLabel("Second Number:");
        JTextField num2Field = new JTextField();

        JLabel resultLabel = new JLabel("Result: ");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addBtn = new JButton("+");
        JButton subBtn = new JButton("-");
        JButton mulBtn = new JButton("*");
        JButton divBtn = new JButton("/");

        buttonPanel.add(addBtn);
        buttonPanel.add(subBtn);
        buttonPanel.add(mulBtn);
        buttonPanel.add(divBtn);

        frame.add(label1);
        frame.add(num1Field);
        frame.add(label2);
        frame.add(num2Field);
        frame.add(resultLabel);
        frame.add(resultField);
        frame.add(buttonPanel);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = 0;

                    if (e.getSource() == addBtn) {
                        result = num1 + num2;
                    } else if (e.getSource() == subBtn) {
                        result = num1 - num2;
                    } else if (e.getSource() == mulBtn) {
                        result = num1 * num2;
                    } else if (e.getSource() == divBtn) {
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Cannot divide by zero.");
                            return;
                        }
                    }
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
                }
            }
        };

        addBtn.addActionListener(actionListener);
        subBtn.addActionListener(actionListener);
        mulBtn.addActionListener(actionListener);
        divBtn.addActionListener(actionListener);

        frame.setVisible(true);
    }
}
