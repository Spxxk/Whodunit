package zork;

import zork.Utils.CommandContext;
import zork.Utils.CommandLoader;
import zork.exceptions.CommandNotFoundException;

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
