package zork.commands;

import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;

import zork.minigames.Test;

public class Play extends Command {
    
    public Play() { super("Play", ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {
        if(Item.arrayToString(args).equalsIgnoreCase("Test")) {    
            Test.play();
            System.out.printf("\nFinished playing Go Fish.\n\n");
        }
    }
}
