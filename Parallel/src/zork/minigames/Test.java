package zork.minigames;

import zork.utils.TimeController;

public class Test {

    public static TimeController timer = new TimeController();
    
    public static void play() {
        timer.start();

        try {
            while(true) {
                if(timer.timeElapsed() > 2) {
                    System.out.println("cee itch");

                    if(timer.timeElapsed() > 4) {
                        printLines();
                        timer = new TimeController();
                        timer.start();
                    }
                }
            }
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void printLines() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
