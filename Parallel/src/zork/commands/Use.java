package zork.commands;

import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;

public class Use extends Command {

    public Use(String cmdName, ArgumentCount limit) { super("Use" , ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {
        // TODO Auto-generated method stub
        String argsString = Item.arrayToString(args);
        if(argsString.equalsIgnoreCase("gun")){
            System.out.println("Command gun executed successfully!");
        }
        else
        {
        throw new UnsupportedOperationException("Unimplemented method 'runCommand'");
        }
    }
}