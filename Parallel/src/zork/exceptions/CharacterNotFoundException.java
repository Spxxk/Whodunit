package zork.exceptions;

public class CharacterNotFoundException extends Exception {
    String context;

    public CharacterNotFoundException(String e) {
        context = e;
    }

    public void printStackTrace() {
        System.out.printf("Character '%s' does not exist.\n", context);
    }
}
