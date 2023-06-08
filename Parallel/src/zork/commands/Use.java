package zork.commands;

import java.util.Scanner;
import java.util.ArrayList;

import zork.Constants.ArgumentCount;
import zork.proto.Character;
import zork.proto.Command;
import zork.proto.Item;
import zork.proto.Exit;
import zork.utils.CharacterConstants;
import zork.Game;

public class Use extends Command {

    public Use() { super("Use", "Use an item from your inventory", ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {
        String argsString = Item.arrayToString(args);

        if(argsString.equalsIgnoreCase("computer") && Game.player.getCurrentRoom().equals(Game.roomMap.get("privatePokerTable"))) {
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
        else if(argsString.equalsIgnoreCase("battering ram") && Game.player.getCurrentRoom().getRoomName().equals("Cellar")) {
            if(CharacterConstants.CHECKED_BATTERING_RAM_CELLAR) {
                Game.print("/bYou already used the battering ram.");
                Game.print("/bThere's a massive hole in the wall because of you.");
                return;
            }
            Game.print("/bThe battering ram is being pointed at the wall.");
            Game.print("/bWould you like to break down the wall?");
            Scanner in = new Scanner(System.in);
            System.out.print("(yes/no): ");
            while(true) {
                String answer = in.nextLine();
                if(answer.equalsIgnoreCase("yes")) {
                    Game.print("/bYou brought the battering ram back as far as you could and thrust it forward.");
                    Game.print("/bIt broke a hole through the wall and revealed another hotel room /rthrough/b.");
                
                    Exit e = new Exit("Through", "brentRoom", false, null);
                    try {
                        Game.roomMap.get("cellar").addExit(e);
                        CharacterConstants.CHECKED_BATTERING_RAM_CELLAR = true;
                    } catch(Exception ex) { Game.print("/rUnknown error has occured, please restart."); }
                    break;
                } else if(answer.equalsIgnoreCase("no")) {
                    Game.print("/bYou decided to put down the battering ram.");
                    break;
                } else {
                    Game.print("/bWhat does " + answer + " mean? Yes or no?");
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