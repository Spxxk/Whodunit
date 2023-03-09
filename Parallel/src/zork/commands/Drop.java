package zork.commands;

import zork.*;
import java.util.ArrayList;

class Drop extends Command {
    public Drop(String commandWord) {
        super(commandWord);
    }

    public boolean dropItem(Inventory inv, String commandWord) {
        ArrayList<Item> items = inv.getInventory();
        for(Item invItem : items) {
            if(invItem.getName().equals(commandWord)) {
                items.remove(invItem);
                return true;
            }
        }
        return false;
    }
}