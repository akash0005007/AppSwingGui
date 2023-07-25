package com.akash;

import javax.swing.*;

public class Main implements Runnable {
    private JTextField num1TextField;
    private JTextField num2TextField;
    private JTextField resultTextField;

    @Override
    public void run() {
        JFrame frame = new JFrame("Two Sum App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Components
        num1TextField = new JTextField(10);
        num2TextField = new JTextField(10);
        resultTextField = new JTextField(10);
        JButton addButton = new JButton("Add");

        // Action listener for the "Add" button
        addButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(num1TextField.getText());
                int num2 = Integer.parseInt(num2TextField.getText());
                int result = num1 + num2;
                resultTextField.setText(Integer.toString(result));
            } catch (NumberFormatException ex) {
                resultTextField.setText("Invalid input");
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.add(new JLabel("Number 1:"));
        panel.add(num1TextField);
        panel.add(new JLabel("Number 2:"));
        panel.add(num2TextField);
        panel.add(addButton);
        panel.add(new JLabel("Result:"));
        panel.add(resultTextField);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }
}
