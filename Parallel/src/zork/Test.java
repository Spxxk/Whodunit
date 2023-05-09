package zork;

import zork.exceptions.CommandNotFoundException;
import zork.utils.CommandContext;
import zork.utils.CommandLoader;

public class Test {
    public static void main(String[] args) {
        CommandLoader.init();
        
        CommandContext context = null;

        try {
            context = new CommandContext("omch", new String[]{"ooo ooo aaa aaa"});
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        }

        context.runCommand("slimch");
    }
}
