package zork.commands;

import java.util.ArrayList;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;
import zork.proto.Character;

public class Look extends Command {
    
    public Look() { super("Look", "See the items and characters in the room", ArgumentCount.NONE); }

    @Override
    public void runCommand(String... args) {
        ArrayList<Item> items = Game.player.getCurrentRoom().getRoomItems().getContents(); // The items in the room
        ArrayList<Character> chars = Game.player.getCurrentRoom().getCharacters(); // The characters present in the room

        if (items.size() == 0 && chars.size() == 0) { // Check if there is nothing in the room
            System.out.println("The room is empty.");
            return;
        }

        if (items.size() > 0) { // If there are items
            System.out.print("Items: ");
            for (Item i : items) {
                System.out.print(i.getName());
                
                if (!i.equals(items.get(items.size()-1))) System.out.print(", ");
            }
            if(chars.size() > 0) System.out.println();
        }

        if (chars.size() > 0) { // If there are characters
            System.out.print("Characters: ");
            for (Character ch : chars) {
                System.out.print(ch.getName());
                
                if (!ch.equals(chars.get(chars.size()-1))) System.out.print(", ");
            }
        }

        System.out.println();
    }
}
