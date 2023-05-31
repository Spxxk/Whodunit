package zork.utils;

import java.util.*;

import zork.exceptions.CommandNotFoundException;
import zork.proto.Command;

public class CommandLoader {
    private static final Map<String, Command> commands = new HashMap<>();

    public static void init() {
        try {
            Class<?>[] classes = Loader.getClasses("zork.commands");

            for (Class<?> c : classes) {
                commands.put(c.getSimpleName().toLowerCase(), (Command) c.getConstructors()[0].newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    public static Command getCommand(String n) throws CommandNotFoundException {
        Command c = commands.get(n.toLowerCase());

        if (c == null) 
            throw new CommandNotFoundException(n);

        return c;
    }
}
