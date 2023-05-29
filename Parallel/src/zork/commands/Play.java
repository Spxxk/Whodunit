package zork.commands;

import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;

import zork.minigames.*;

public class Play extends Command {
    
    public Play() { super("Play", ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {
        if(Item.arrayToString(args).equalsIgnoreCase("Typing Test")) {    
            TypingTest.play();
            System.out.println("Finished playing Typing Test.");
        }
    }
}
