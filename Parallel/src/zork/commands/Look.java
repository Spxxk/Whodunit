package zork.commands;

import java.util.ArrayList;

import zork.Game;
import zork.proto.Command;
import zork.proto.Item;

public class Look extends Command {
    
    public Look() { super("Look"); }

    @Override
    public void runCommand(String... args) {
        ArrayList<Item> items = Game.currentRoom.getRoomItems().getInventory();

        if(items.size() == 0) {
            System.out.println("The room is empty.");
            return;
        }

        for (Item i : items) {
            System.out.print(i.getName());
            
            if (!i.equals(items.get(items.size()-1))) System.out.print(", ");
        }

        System.out.println();
    }
}
