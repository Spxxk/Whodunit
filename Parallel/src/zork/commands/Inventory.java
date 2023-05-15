package zork.commands;

import java.util.ArrayList;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;

public class Inventory extends Command {

    public final ArgumentCount Arguments = ArgumentCount.INFINITE;

    public Inventory() { super("Inventory"); }

    public void runCommand(String... args) {
        ArrayList<Item> inventory = Game.playerInventory.getInventory();

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