package zork.commands;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Inventory;
import zork.proto.Item;
import zork.exceptions.InventoryLimitExceeded;
import zork.exceptions.ItemNotFoundException;

public class Drop extends Command {

    public Drop() { super("Drop", "Drops an item from the inventory", ArgumentCount.INFINITE); }

    public void runCommand(String... args) {
        for (Item item : Game.player.getInventory().getContents()) { // Iterates through the player's inventory
            if (Item.arrayToString(args).equalsIgnoreCase(item.getName())) { // Attempting to find item
                Inventory inv_receive = Game.player.getCurrentRoom().getRoomItems(); // The room's "inventory"
                Inventory inv_take = Game.player.getInventory(); // Our inventory

                try {
                    inv_receive.addItem(item); // Throws InventoryLimitExceeded if cannot fit, but this should never be thrown because the room's inventory is infinite
                    inv_take.removeItem(item); 
                } catch (InventoryLimitExceeded e) {
                    e.printStackTrace();
                    return;
                }

                System.out.printf("You dropped a [%s] into the room [%2s].%n", item.getName(), Game.player.getCurrentRoom().getRoomName()); // Informs the user
                return;
            }
        }

        try {
            throw new ItemNotFoundException(Item.arrayToString(args)); // If we have an item, this condition will never be met. This means that if we get here, we don't have the item we want to drop
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
    }
}
