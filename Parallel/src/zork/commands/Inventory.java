package zork.commands;

import java.util.ArrayList;
import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;


//test 

public class Inventory extends Command {
    
    public Inventory() { super("Inventory", ArgumentCount.NONE); }

    public void runCommand(String... args) {
        ArrayList<Item> inventory = Game.player.getInventory().getContents();

        if(inventory.size() == 0) { 
            System.out.println("Your inventory is empty.");
            return;
        }

        for (Item i : inventory) {
            System.out.print(i.getName());
            
            if (!i.equals(inventory.get(inventory.size()-1))) System.out.print(", ");
        }

        System.out.println();
    }
}