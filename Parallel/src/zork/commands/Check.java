package zork.commands;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;
import zork.utils.CharacterConstants;
import zork.utils.Give;

public class Check extends Command {
    
    public Check() { super("Check", "Checks inside an item in the room", ArgumentCount.INFINITE); } 

    public void runCommand(String... args) {
        String itemName = Item.arrayToString(args);

        switch(Game.player.getCurrentRoom().getRoomName()) {
            case "Your Room":
                if(itemName.equalsIgnoreCase("nightstand")) {
                    Game.print("/bYou looked inside the nightstand.");
                    Game.print("/bYou found a letter addressed to you from your friend Brent.");
                    if(Give.giveItem(Game.itemList.get("letterAddressedToYou"), null)) 
                        Game.print("/bType /rInventory/b into the console to see your current items.");
                }
            case "Your Bathroom":
                if(itemName.equalsIgnoreCase("Bathtub")) {
                    if(CharacterConstants.READ_LETTER_FROM_BRENT) {
                        Game.print("/bYou felt the bathtub looked suspicious, so you checked underneath the bathtub.");
                        Game.print("/bThere appears to be a trapdoor underneath.");
                        Game.print("/bMaybe you can get out this way.");
                    }
                }
        }
    }
}
