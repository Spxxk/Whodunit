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
        for (Item item : Game.player.getInventory().getContents()) {
            if (Item.arrayToString(args).equalsIgnoreCase(item.getName())) {
                Inventory inv_receive = Game.player.getCurrentRoom().getRoomItems();
                Inventory inv_take = Game.player.getInventory();

                try {
                    inv_receive.addItem(item);
                    inv_take.removeItem(item);
                } catch (InventoryLimitExceeded e) {
                    e.printStackTrace();
                    return;
                }

                System.out.printf("You dropped a [%s] into the room [%2s].%n", item.getName(), Game.player.getCurrentRoom().getRoomName());
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
