package zork.commands;

import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;
import zork.Game;

import zork.minigames.*;

public class Play extends Command {
    
    public Play() { super("Play", ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {
        String temp = Item.arrayToString(args);
        if(temp.equalsIgnoreCase("Typing Test")) {    
            TypingTest.play();
            System.out.println("Finished playing Typing Test.\n");
        }
        else if(temp.equalsIgnoreCase("Tic Tac Toe")) {
            TicTacToe.play();
            System.out.println("Finished playing Tic Tac Toe.\n");
        }
        else if(temp.equalsIgnoreCase("Memory Numbers")) {
            MemoryNumbers.play();
            System.out.println("Finished playing Memory Numbers.\n");
        }

        System.out.println(Game.player.getCurrentRoom().longDescription());
    }
}
