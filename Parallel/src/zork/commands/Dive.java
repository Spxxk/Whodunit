package zork.commands;

import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.Game;
import zork.utils.Give;
import zork.utils.CharacterConstants;

public class Dive extends Command {

    public Dive() { super("Dive", "Dive underneath a body of water", ArgumentCount.NONE); }

    public void runCommand(String... args) {
        if(Game.player.getCurrentRoom().getRoomName().equals("Swimming Pool")) {
            if(!CharacterConstants.TOOK_KEY){
                Game.print("/bYou take a deep breath, then jump into the pool.");
                Game.print("/bAs you are swimming underwater, you see something shiny, it looks like a key.");
                Game.print("/bYou propel yourself closer to it, then pick it up and put it in your pocket.");
                Game.print("/bYou climb out of the pool, wanting to know more.");
                if(Give.giveItem(Game.itemList.get("glennClosetKey"), null))  {
                    Game.print("/bType /rinventory /bto see where the key leads.");
                    CharacterConstants.TOOK_KEY = true;
                }
            }else{
                Game.print("You took a nice dive in the pool, you feel refreshed.");
            }
        } else {
            Game.print("/bWhat are you doing? You can't dive on dry land!");
        }
    }

}