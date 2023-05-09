package zork.utils;

import zork.exceptions.CommandNotFoundException;
import zork.proto.Command;

public class CommandContext {
    private final Command command;
    private final String[] args;

    public CommandContext(String commandName) throws CommandNotFoundException {       
        command = CommandLoader.getCommand(commandName);
        args = null;
    }

    public CommandContext(String commandName, String... arguments) throws CommandNotFoundException {
        command = CommandLoader.getCommand(commandName);
        args = arguments;
    }


    public void runCommand(String... specialArgs) {
        if (specialArgs.length != 0) {
            command.runCommand(specialArgs);
        } else {
            command.runCommand(args);
        }
    }

}
