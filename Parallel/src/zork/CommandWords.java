package zork;

public class CommandWords {
    // a constant array that holds all valid command words
    private static final String COMMANDS[] = { "take", "bag", "i", "inventory" };

    public static boolean checkWord(String s) {
        for (String c : COMMANDS) {
            if(c.equals(s.toLowerCase())) 
                return true;
        }
        return false;
    }
}