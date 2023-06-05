package zork.commands;

import java.util.Scanner;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.exceptions.CharacterNotFoundException;
import zork.proto.Command;
import zork.proto.Item;
import zork.proto.Character;

public class Talk extends Command {

    public Talk() { super("Talk", "Talk to an NPC", ArgumentCount.INFINITE); }

    public void runCommand(String... args) {
        if(args.length < 2) {
            System.out.println("Talk to who?");
            return;
        }

        if(args[0].equalsIgnoreCase("to")) {
            for (Character ch : Game.player.getCurrentRoom().getCharacters()) {
                if(("to " + ch.getName()).equalsIgnoreCase(Item.arrayToString(args))) {
                    System.out.println("\033[1;32m" + ch.getDialogue() + "\033[0m");

                    if(ch.hasOptions()) {
                        Scanner in = new Scanner(System.in);

                        System.out.print("Type [yes] to play and [no] to decline: ");
                        while(true) {
                            String option = in.nextLine();
                            if(option.equalsIgnoreCase("yes")) {
                                System.out.println("start minigame here");
                                return;
                            }
                            if(option.equalsIgnoreCase("no")) {
                                System.out.println("Ok, come back later if you change your mind.");
                                return;
                            }
                            System.out.print("Invalid option, please input again: ");
                        }
                    }
                    return;
                }
            }
            try {
                throw new CharacterNotFoundException(Item.arrayToString(args).substring(3));
            } catch(CharacterNotFoundException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Talk to who?");
    }
}