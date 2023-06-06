package zork.utils;

import zork.Game;
import zork.exceptions.InventoryLimitExceeded;
import zork.proto.Item;

public class Give {
    public static boolean giveItem(Item item, String cName) {
        try {
            Game.player.getInventory().addItem(item);

            Game.print("/bThe " + cName + " gave you " + item.getName() + "!");
            return true;
        } catch(InventoryLimitExceeded e) {
            Game.print("/bPlease make space in your inventory to recieve " + item.getName());
            return false;
        }
    }
}
