package zork.exceptions;

public class ItemNotFoundException extends Exception {
    String error;

    public ItemNotFoundException(String e) {
        error = e;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Item does not exist.");
    }
}
