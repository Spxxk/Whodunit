package zork.commands;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Inventory;
import zork.proto.Item;
import zork.exceptions.InventoryLimitExceeded;
import zork.exceptions.ItemNotFoundException;

public class Take extends Command {

    public Take() { super("Take", "Put an item from the room into your inventory", ArgumentCount.INFINITE); }

    public void runCommand(String... args) {
        for (Item item : Game.player.getCurrentRoom().getRoomItems().getContents()) {
            if (Item.arrayToString(args).equalsIgnoreCase(item.getName())) {
                Inventory inv_receive = Game.player.getInventory();
                Inventory inv_take = Game.player.getCurrentRoom().getRoomItems();
                
                try {
                    inv_receive.addItem(item);
                    inv_take.removeItem(item);
                } catch (InventoryLimitExceeded e) {
                    e.printStackTrace();
                    return;
                }

                Game.print("/bYou picked up a " + item.getName() + " from the ground.");
                return;
            }
        }

        try {
            throw new ItemNotFoundException(Item.arrayToString(args));
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
    }
}