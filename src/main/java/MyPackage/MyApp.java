package MyPackage;

import javax.swing.*;

public class MyApp implements Runnable {

    private static MyApp aThread, bThread;
    private char c;

    public MyApp(char c) {
        this.c = c;
    }

    public MyApp() {

        aThread = new MyApp('a');
        bThread = new MyApp('b');
        Thread thread = new Thread(aThread);
        Thread thread1 = new Thread(bThread);
        thread.start();
        thread1.start();
        new MyGui();
    }


    @Override
    public void run() {
        if (this == aThread || this == bThread) {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        new MyApp();
    }
}

class MyGui {
    private static JTextField num1TextField;
    private static JTextField num2TextField;
    private static JTextField result1TextField;

    private static JButton addButton;

    private static JTextField num3TextField;
    private static JTextField num4TextField;
    private static JTextField result2TextField;
    private static JButton subtractButton;
    private static JPanel panel;

    public MyGui() {
        jFrame();
        myEventListener();
    }

    public static void jFrame() {
        jPanel();
        JFrame frame = new JFrame("MyApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
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
        

        // Third row
        JPanel row2 = new JPanel();
        row2.add(new JLabel("Number 1:"));
        row2.add(num3TextField);
        row2.add(new JLabel("Number 2:"));
        row2.add(num4TextField);
        row2.add(subtractButton);
        row2.add(new JLabel("Result:"));
        row2.add(result2TextField);
        panel.add(row2);

        
    }

    public static void myComponents() {
        num1TextField = new JTextField(10);
        num2TextField = new JTextField(10);
        result1TextField = new JTextField(10);
        addButton = new JButton("Add");
        num3TextField=new JTextField(10);
        num4TextField= new JTextField(10);
        result2TextField=new JTextField(10);
        subtractButton=new JButton("Subtract");
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
        subtractButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(num3TextField.getText());
                int num2 = Integer.parseInt(num4TextField.getText());
                int result = num1 - num2;
                result2TextField.setText(Integer.toString(result));
            } catch (NumberFormatException ex) {
                result1TextField.setText("Invalid input");
            }
        });
    }

}
