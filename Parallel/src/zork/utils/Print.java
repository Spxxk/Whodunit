package zork.utils;

public class Print {
    public static void printSlowly(String text, long delay) {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static void printSlowly(String text) {
        printSlowly(text, 50);
    }
}
