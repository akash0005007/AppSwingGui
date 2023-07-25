package com.akash;

import javax.swing.*;

public class MyApp implements Runnable {
    private JTextField num1TextField;
    private JTextField num2TextField;
    private JTextField resultTextField;
    private static MyApp aThread, bThread;
    private char c;

    public MyApp(char c) {
        this.c = c;
    }

    public MyApp() {
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
        aThread= new MyApp('a');
        bThread= new MyApp('b');
        Thread thread = new Thread(aThread);
        Thread thread1= new Thread(bThread);
        thread.start();
        thread1.start();
    }


    @Override
    public void run() {
        if (this == aThread || this == bThread) {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MyApp());
    }
}
