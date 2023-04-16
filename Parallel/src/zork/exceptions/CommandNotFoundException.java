package zork.exceptions;

public class CommandNotFoundException extends Exception {
    String error;

    public CommandNotFoundException(String e) {
        error = e;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Invalid Command.");
    }
}