package zork.threads;

import zork.exceptions.CommandNotFoundException;
import zork.proto.Command;
import zork.utils.CommandContext;
import zork.utils.Parser;

public class CommandListener extends Thread {
    public CommandListener() {
        super("CmdListener");
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("--------------");
                
                CommandContext res = Parser.getCommand();

                System.out.println("--------------");

                res.runCommand();
            } catch (CommandNotFoundException e) {
                e.printStackTrace(getName());
            }
        }
    }
}