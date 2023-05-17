package zork.exceptions;

public class InventoryLimitExceeded extends Exception {
    String error;

    public InventoryLimitExceeded(String e) {
        error = e;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Item does not exist.");
    }
}
