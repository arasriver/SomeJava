package Git;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountdownTimerGUI {
    private static Timer timer;
    private static int timeLeft;

    public static void main(String[] args){
        JFrame frame = new JFrame("Countdown Timer");
        frame.setSize(300, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Enter time (seconds):");
        JTextField timeField = new JTextField(10);
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JLabel countdownLabel = new JLabel("Time: 0");
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 24));

        frame.add(inputLabel);
        frame.add(timeField);
        frame.add(startButton);
        frame.add(stopButton);
        frame.add(countdownLabel);

        startButton.addActionListener(e -> {
            if (timer != null && timer.isRunning()) {
                timer.stop();
            }

            try {
                timeLeft = Integer.parseInt(timeField.getText());
                countdownLabel.setText("Time: " + timeLeft);

                timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        timeLeft--;
                        countdownLabel.setText("Time: " + timeLeft);
                        if (timeLeft <= 0) {
                            timer.stop();
                            countdownLabel.setText("⏰ Time's up!");
                        }
                    }
                });
                timer.start();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        });

        stopButton.addActionListener(e -> {
            if (timer != null) {
                timer.stop();
                countdownLabel.setText("Timer stopped.");
            }
        });

        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);
    }
}
