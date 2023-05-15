package zork;

import zork.threads.ChronoHandler;
import zork.utils.Timer;

public class Test {
    public static Timer c = new Timer(10);

    public static void main(String[] args) throws InterruptedException, IllegalAccessException {
        Thread ch = new ChronoHandler(c);

        c.isOver();
    }
}
