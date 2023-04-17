package zork.commands;

import zork.Command;
import zork.Game;

public class Bag implements Command {

    public void runCommand(String[] args) {
        int i;
        for (i = 0; i < Game.playerInventory.getInventory().size(); i++) {
            if(i > 0)
                System.out.print(", ");

            System.out.print(Game.playerInventory.getInventory().get(i).getName());
        }
        if(i == 0) System.out.print("Your bag is empty.");

        System.out.println();
    }

}