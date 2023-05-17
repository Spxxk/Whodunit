package zork.commands;

import java.util.ArrayList;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;

public class Look extends Command {
    
    public Look() { super("Look", ArgumentCount.NONE); }

    @Override
    public void runCommand(String... args) {
        ArrayList<Item> items = Game.player.getCurrentRoom().getRoomItems().getContents();

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
