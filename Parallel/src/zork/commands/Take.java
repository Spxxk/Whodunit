package zork.commands;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Inventory;
import zork.proto.Item;
import zork.exceptions.InventoryLimitExceeded;

public class Take extends Command {

    public Take() { super("Take", ArgumentCount.INFINITE); }

    public void runCommand(String... args) {
        for (Item item : Game.player.getCurrentRoom().getRoomItems().getContents()) {
            if(Item.arrayToString(args).equalsIgnoreCase(item.getName())) {
                Inventory inv_receive = Game.player.getInventory();
                Inventory inv_take = Game.player.getCurrentRoom().getRoomItems();

                int weight = inv_receive.getCurrentWeight();
                inv_receive.setCurrentWeight(weight);

                try{
                    inv_take.removeItem(item);
                    inv_receive.addItem(item);
                } catch(InventoryLimitExceeded e) {
                    return;
                }

                System.out.println("You picked up a " + item.getName() + " from the ground.");
                return;
            }
        }
        System.out.println("No item was taken.");
    }

}