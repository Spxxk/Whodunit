package zork.commands;

import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.Game;

public class Dive extends Command {

    public Dive() { super("Dive", "Dive underneath a body of water", ArgumentCount.NONE); }

    public void runCommand(String... args) {
        if(Game.player.getCurrentRoom().getRoomName().equals("Swimming Pool")) {
            // command stub for Cyrus
        } else {
            Game.print("/bWhat are you doing? You cannot dive on dry land!");
        }
    }

}