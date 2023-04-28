package zork.exceptions;

public class CommandNotFoundException extends Exception {
    String context;

    public CommandNotFoundException(String e) {
        context = e;
    }

    @Override
    public void printStackTrace() {
        System.out.printf("Invalid Command '%s'.\n", context);
    }
}