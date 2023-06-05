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
        if(args.length < 2) {
            System.out.println("Talk to who?");
            return;
        }

        if(args[0].equalsIgnoreCase("to")) {
            for (Character ch : Game.player.getCurrentRoom().getCharacters()) {
                if(("to " + ch.getName()).equalsIgnoreCase(Item.arrayToString(args))) {
                    Game.player.setCharacterTalkingTo(ch);
                    return;
                }
            }
            try {
                throw new CharacterNotFoundException(Item.arrayToString(args).substring(3));
            } catch(CharacterNotFoundException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Talk to who?");
    }
}