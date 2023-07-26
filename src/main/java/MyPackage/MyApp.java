package MyPackage;

import MyPackage.gui.MyGui;

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


