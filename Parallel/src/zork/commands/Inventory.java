package zork.commands;

import java.util.ArrayList;
import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;


//test 

public class Inventory extends Command {
    
    public Inventory() { super("Inventory", "View your inventory", ArgumentCount.NONE); }

    public void runCommand(String... args) {
        ArrayList<Item> inventory = Game.player.getInventory().getContents();

        if(inventory.size() == 0) { // Check if it has things
            Game.print("/bYour inventory is empty.");
            return;
        }


        // If we have things...

        for (Item i : inventory) {
            System.out.print(i.getName() + (!i.equals(inventory.get(inventory.size()-1)) ? ", " : "")); // Print the name (and the comma, if appropriate)
        }

        System.out.println();
    }
}