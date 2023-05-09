package zork;

import zork.utils.Timer;

public class Test {
    public static Timer c = new Timer(10);

    public static void f() {
        try {
            System.out.println("---");
            System.out.println(c.timeElapsed());
            System.out.println(c.isOver());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {

        c.start();

        f();

        Thread.sleep(5000);

        f();

        Thread.sleep(5000);

        f();
    }
}
