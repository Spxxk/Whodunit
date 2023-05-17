package zork.exceptions;

public class ItemNotFoundException extends Exception {
    String context;

    public ItemNotFoundException(String e) {
        context = e;
    }

    @Override
    public void printStackTrace() {
        System.out.printf("Item [%s] does not exist.\n", context);
    }
}
