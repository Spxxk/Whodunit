package zork.commands;

import zork.proto.Command;
import zork.proto.Item;
import zork.Game;
import zork.utils.CharacterConstants;
import zork.Constants.ArgumentCount;

public class Read extends Command {
    
    public Read() { super("Read", "Read the contents of an item from your inventory", ArgumentCount.INFINITE); } 

    public void runCommand(String... args) {
        String itemName = Item.arrayToString(args);

        switch(itemName.toLowerCase()) {
            case "letter":
            case "welcome letter":
                for (Item item : Game.player.getInventory().getContents()) {
                    if(item.getName().equalsIgnoreCase(itemName)) {
                        if(item.getId().equalsIgnoreCase("welcome letter")) {
                            Game.print("/dbWelcome to the Parallel Hotel!");
                            Game.print("/dbWe hope you enjoy your stay here at our wonderful 5 star resort.");
                            Game.print("/dbDid you know you can open the nightstand in your room by writing");
                            Game.print("/rCheck Nightstand");
                            Game.print("/dbin the console? It's a very useful tip!");
                        }
                        if(item.getId().equalsIgnoreCase("letterAddressedToYou")) {
                            try {
                                Game.print("/db... /p... it's Brent...");
                                Thread.sleep(1000);
                                Game.print("/dbI woke up today as usual and went to wake him up, but...");
                                Thread.sleep(1000);
                                Game.print("/dbHe was there on the bed, lying still as stone, dead.");
                                Game.print("/dbI know it's your vacation, but we really need your detective skills...");
                                Game.print("/dbPlease... Find who murdered our best friend... /rGlenn/db...");
                                Thread.sleep(1000);
                                Game.print("/bThe page was covered in tears, making you cry for your friend as well.");
                                CharacterConstants.READ_LETTER_FROM_BRENT = true;
                            } catch(InterruptedException e) {}
                        }

                        return;
                    }
                }
                Game.print("/b" + itemName + " is not in your inventory.");
                break;
            default:
                Game.print("/bWhat is " + itemName + "? Is that even a book?");
        }
    }
}
