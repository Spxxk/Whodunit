package zork.commands;

import zork.proto.Command;
import zork.proto.Item;
import zork.Game;
import zork.Constants.ArgumentCount;

public class Read extends Command {
    
    public Read() { super("Read", "Read the contents of an item from your inventory.", ArgumentCount.INFINITE); } 

    public void runCommand(String... args) {
        String itemName = Item.arrayToString(args);

        switch(itemName.toLowerCase()) {
            case "welcome letter":
                for (Item item : Game.player.getInventory().getContents()) {
                    if(item.getName().equalsIgnoreCase(itemName)) {
                        if(item.getName().equalsIgnoreCase("welcome letter")) {
                            Game.print("/dbWelcome to the Parallel Hotel!");
                            Game.print("/dbWe hope you enjoy your stay here at our wonderful 5 star resort.");
                            Game.print("/dbDid you know you can open the nightstand in your room by writing");
                            Game.print("/rCheck Nightstand");
                            Game.print("/dbin the console? It's a very useful tip!");
                        }
                        return;
                    } else {
                        Game.print("/b" + item.getName() + " is not in your inventory.");
                    }
                }
                break;
            default:
                Game.print("/bWhat is " + itemName + "? Is that even a book?");
        }
    }
}
