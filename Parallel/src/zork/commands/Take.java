package zork.commands;

import zork.*;

public class Take {
    public static void takeItem(Item item) {
        Inventory rm = Game.currentRoom.getRoomItems();
        if(Game.currentRoom.getRoomItems().getInventory().contains(item) && item.getWeight() + Game.playerInventory.getCurrentWeight() <= Game.playerInventory.getMaxWeight()) {
            Game.playerInventory.addItem(item);
            rm.removeItem(item); Game.currentRoom.setRoomItems(rm);
        }
    }
}