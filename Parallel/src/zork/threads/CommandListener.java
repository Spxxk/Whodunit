package zork.threads;

import zork.exceptions.CommandNotFoundException;

import zork.utils.Parser;

public class CommandListener extends Thread {
    public CommandListener() {
        super("CmdListener");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Parser.getCommand().runCommand();
            } catch (CommandNotFoundException e) {
                e.printStackTrace(getName());
            }
        }
    }
}