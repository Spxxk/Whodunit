package zork.exceptions;

public class MinigameNotFoundException extends Exception {
    String context;

    public MinigameNotFoundException(String e) {
        context = e;
    }

    public void printStackTrace(String threadName) {
        System.out.printf("[%s] Invalid Minigame '%s'.\n", threadName, context);
    }
}