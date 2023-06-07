package zork.commands;

import java.util.Scanner;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;
import zork.proto.Exit;
import zork.utils.CharacterConstants;
import zork.utils.Give;

public class Check extends Command {
    
    public Check() { super("Check", "Checks inside an item in the room", ArgumentCount.INFINITE); } 

    public void runCommand(String... args) {
        String itemName = Item.arrayToString(args);

        switch(Game.player.getCurrentRoom().getRoomName()) {
            case "Your Room":
                if(itemName.equalsIgnoreCase("nightstand")) {
                    Game.print("/bYou looked inside the nightstand.");
                    Game.print("/bYou found a letter addressed to you from your friend Brent.");
                    if(Give.giveItem(Game.itemList.get("letterAddressedToYou"), null)) 
                        Game.print("/bType /rInventory/b into the console to see your current items.");
                } else {
                    Game.print("/b" + itemName + " does not need to be checked.");
                }
                break;
            case "Your Bathroom":
                if(itemName.equalsIgnoreCase("Bathtub")) {
                    if(CharacterConstants.READ_LETTER_FROM_BRENT) {
                        Game.print("/bYou felt the bathtub was the lake from the clue, so you checked underneath it.");
                        Game.print("/bThere appears to be a trapdoor underneath. Maybe you can get out this way.");
                        Game.print("/bTo enter the trapdoor, type /rGo Down/b in the console.");

                        Exit e = new Exit("Down", "cellar", false, null);
                        try {
                            Game.roomMap.get("userBathroom").addExit(e);
                        } catch(Exception ex) { Game.print("/rUnknown error has occured, please restart."); }
                    } else {
                        Game.print("/bWhat? It's just a normal bathtub.");
                    }
                } else {
                    Game.print("/b" + itemName + " does not need to be checked.");
                }
                break;
            case "Cellar":
                if(itemName.equalsIgnoreCase("Crate")) {
                    Game.print("/bYou opened the lid of the crate and checked inside.");
                    Game.print("/bYou found a bullet at the bottom of the crate.");
                    Give.giveItem(Game.itemList.get("cellarBullet"), null);
                    Game.print("/bWhy would a bullet be inside this crate? What is this place?");
                } else if(itemName.equalsIgnoreCase("Battering Ram")) {
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
                            } catch(Exception ex) { Game.print("/rUnknown error has occured, please restart."); }
                            break;
                        } else if(answer.equalsIgnoreCase("no")) {
                            Game.print("/bYou decided to put down the battering ram.");
                            break;
                        } else {
                            Game.print("/bWhat does " + answer + " mean? Yes or no?");
                        }
                    }
                } else {
                    Game.print("/b" + itemName + " does not need to be checked.");
                }
                break;

            default:
                Game.print("/b" + itemName + " does not need to be checked.");
                break;
        }
    }
}
