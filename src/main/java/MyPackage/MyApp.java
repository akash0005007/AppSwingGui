package MyPackage;

import MyPackage.gui.MyGui;
import MyPackage.ops.Addition;
import MyPackage.ops.Subtraction;

public class MyApp implements Runnable {

    private static MyApp aThread, bThread;

    public static Thread threadA,threadB;
    private char c;

    public MyApp(char c) {
        this.c = c;
    }

    public MyApp() {

        aThread = new MyApp('a');
        bThread = new MyApp('b');
        threadA= new Thread(aThread);
        threadB  = new Thread(bThread);

        new MyGui();
    }


    @Override
    public void run() {
        if (this == aThread ) {
            System.out.println("a thread");
            Addition.myEventListener();
        }
        if (this == bThread ) {
            System.out.println("b thread");
            Subtraction.myEventListener();
        }
    }

    public static void main(String[] args) {
        new MyApp();
    }
}


