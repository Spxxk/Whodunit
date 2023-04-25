package zork;

import java.util.*;
import java.io.*;

public class CommandContext {
    private final Command command;
    private final String[] args;

    public CommandContext(String commandName, String[] arguments) {
        command = CommandLoader.getCommand(commandName);
        args = arguments;
    }
}
