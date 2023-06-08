package zork.commands;

import java.util.Scanner;
import java.util.ArrayList;

import zork.Constants.ArgumentCount;
import zork.proto.Character;
import zork.proto.Command;
import zork.proto.Item;
import zork.utils.CharacterConstants;
import zork.Game;

public class Use extends Command {

    public Use() { super("Use", "Use an item from your inventory", ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {
        String argsString = Item.arrayToString(args);

        if(argsString.equalsIgnoreCase("computer") && Game.player.getCurrentRoom().equals(Game.roomMap.get("privatePokerTable")) && !CharacterConstants.USED_COMPUTER) {
            Game.print("/bYou touched the keyboard and the computer flashed open, prompting you with the message:");
            Game.print("/dbPASSWORD?");

            Scanner in = new Scanner(System.in);
            while(true) {
                System.out.print("Type here: ");
                String password = in.nextLine();

                if(password.equalsIgnoreCase("brent")) {
                    Game.print("\n/dbACCESS GRANTED! INITIATING POKER TABLE TRANSPORT MACHINE....\n");
                    Game.print("/bThe room has started to shake uncontrollably. You started hanging on for dear life.");
                    Game.print("/bIn the center of the room, once empty, a poker table has appeared with a few people sitting there.");
                    Game.print("/bBut there's no way you're seeing right... is that /rBrent/b?");

                    ArrayList<Character> ch = new ArrayList<>();
                    ch.add(Game.characterList.get("brentAndFriends"));

                    Game.player.getCurrentRoom().setCharacters(ch);
                    CharacterConstants.USED_COMPUTER = true;
                    break;
                } else if(password.equalsIgnoreCase("no") || password.equalsIgnoreCase("quit")) {
                    Game.print("/bYou decided to put down the keyboard and continue looking around.");
                } else {
                    Game.print("/dbACESS DENIED! WRONG PASSWORD\n");
                    Game.print("/dbPASSWORD?");
                }
            }

        }
        

        else if(argsString.contains("key")){ 
            boolean found = false;
            for(Item item: Game.player.getInventory().getContents()) {
                if(item.getName().equalsIgnoreCase(argsString)){
                    System.out.println("You used the " + item.getName());
                    Game.player.getInventory().removeItem(item); // remove the item from the inventory
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("You don't have the " + argsString + " in your inventory");
            }
        }
    }
}