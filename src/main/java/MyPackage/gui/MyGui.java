package MyPackage.gui;

import MyPackage.ops.Addition;

import javax.swing.*;

public class MyGui {
    public MyGui() {
        jFrame();

    }

    public static void jFrame() {
        JFrame frame = new JFrame("MyApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Addition();
        frame.add(Addition.panel);
        frame.pack();
        frame.setVisible(true);
    }
}
