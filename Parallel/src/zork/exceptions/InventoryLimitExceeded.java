package zork.exceptions;

import zork.Game;
import zork.proto.Item;

public class InventoryLimitExceeded extends Exception {
    Item item;

    public InventoryLimitExceeded(Item i) {
        item = i;
    }

    @Override
    public void printStackTrace() {
        System.out.printf("You cannot add item [%s] with weight [%.2f] when your inventory is at [%s]!\n", item.getName(), item.getWeight(), Game.player.getInventory().getCurrentWeight() + "/" + Game.player.getInventory().getMaxWeight());
    }
}
