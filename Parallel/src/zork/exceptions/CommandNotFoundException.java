package zork.exceptions;

public class CommandNotFoundException extends Exception {
    String context;

    public CommandNotFoundException(String e) {
        context = e;
    }

    public void printStackTrace(String threadName) {
        System.out.printf("[%s] Invalid Command '%s'.\n", threadName, context);
    }
}