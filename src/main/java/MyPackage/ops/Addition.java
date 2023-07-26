package MyPackage.ops;

import MyPackage.MyApp;

import javax.swing.*;

public class Addition {
    private static JTextField num1TextField;
    private static JTextField num2TextField;
    private static JTextField result1TextField;

    private static JButton addButton;

    public static JPanel panel;

    public Addition() {
        jPanel();
    }

    public static void jPanel() {
        myComponents();

        // Create a panel with BoxLayout in Y_AXIS orientation
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // First row
        JPanel row1 = new JPanel();
        row1.add(new JLabel("Number 1:"));
        row1.add(num1TextField);
        row1.add(new JLabel("Number 2:"));
        row1.add(num2TextField);
        row1.add(addButton);
        row1.add(new JLabel("Result:"));
        row1.add(result1TextField);
        panel.add(row1);
        MyApp.threadA.start();

    }

    public static void myComponents() {
        num1TextField = new JTextField(10);
        num2TextField = new JTextField(10);
        result1TextField = new JTextField(10);
        addButton = new JButton("Add");
    }

    public static void myEventListener() {
        addButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(num1TextField.getText());
                int num2 = Integer.parseInt(num2TextField.getText());
                int result = num1 + num2;
                result1TextField.setText(Integer.toString(result));
            } catch (NumberFormatException ex) {
                result1TextField.setText("Invalid input");
            }
        });
    }

}