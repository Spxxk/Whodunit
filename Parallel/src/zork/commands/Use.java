package zork.commands;

import zork.Constants.ArgumentCount;
import zork.proto.Command;

public class Use extends Command {

    public Use(String cmdName, ArgumentCount limit) { super("Use" , ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runCommand'");
    }

}