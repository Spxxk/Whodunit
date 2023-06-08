package zork.commands;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.exceptions.CharacterNotFoundException;
import zork.proto.Command;
import zork.proto.Item;
import zork.proto.Character;

public class Talk extends Command {

    public Talk() { super("Talk", "Talk to an NPC", ArgumentCount.INFINITE); }

    public void runCommand(String... args) {
        if (args.length < 2) { // Since it is "talk <arg1:to> <arg2:who>" we need at least 2 words
            System.out.println("Talk to who?");
            return;
        }

        if (args[0].equalsIgnoreCase("to")) { // Check if the request is worded correctly
            for (Character ch : Game.player.getCurrentRoom().getCharacters()) { // Iterate over all present characters
                if(("to " + ch.getName()).equalsIgnoreCase(Item.arrayToString(args))) { // Check if we found the right one
                    Game.dialogueLoop(ch.getId());
                    return;
                }
            }
            
            try {
                throw new CharacterNotFoundException(Item.arrayToString(args).substring(3)); // If we get here that means the NPC is not present, or they don't exist
            } catch (CharacterNotFoundException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Talk to who?");
    }
}