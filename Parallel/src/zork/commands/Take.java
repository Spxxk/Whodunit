package zork.commands;

import zork.Game;
import zork.Command;

import zork.Item;
import zork.Inventory;

public class Take extends Command {
    @Override
    public void runCommand(String[] args) {
        for (Item item : Game.currentRoom.getRoomItems().getInventory()) {
            if(Item.arrayToString(args).equalsIgnoreCase(item.getName())) {
                Inventory inv_recieve = Game.playerInventory;
                Inventory inv_take = Game.currentRoom.getRoomItems();

                int weight = inv_recieve.getCurrentWeight();
                inv_recieve.setCurrentWeight(weight);

                inv_take.removeItem(item);
                inv_recieve.addItem(item);

                System.out.println("You picked up a " + item.getName() + " from the ground.");
                return;
            }
        }
        System.out.println("No item was taken.");
    }
}