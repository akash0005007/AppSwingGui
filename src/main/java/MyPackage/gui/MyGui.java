package MyPackage.gui;

import MyPackage.ops.Addition;
import MyPackage.ops.Subtraction;

import javax.swing.*;

public class MyGui {
    private static JFrame frame;
    public MyGui() {
        jFrame();

    }

    public static void jFrame() {
         frame= new JFrame("MyApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        panelAddition();
        frame.pack();
        frame.setVisible(true);
    }
    private static void panelAddition(){
        new Addition();
        frame.add(Addition.panel);
        new Subtraction();
        frame.add(Subtraction.panel);
    }
}
