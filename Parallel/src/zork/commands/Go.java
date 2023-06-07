package zork.commands;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.exceptions.InvalidRoomException;
import zork.proto.Command;
import zork.proto.Exit;
import zork.proto.Player;
import zork.proto.Room;
import zork.proto.Item;
import zork.utils.CharacterConstants;

public class Go extends Command {
    
    public Go() { super("Go", "Go in a certain direction", ArgumentCount.ONE); }

    public void runCommand(String... args) {
        Player player = Game.player;
        Room room = player.getCurrentRoom();
        String direction = args[0];

        for (int i = 0; i < room.getExits().size(); i++) {
            Exit e = room.getExits().get(i);
            
            if (e.getDirection().equalsIgnoreCase(direction)) {
                if(e.isLocked()) {
                    for(Item item : player.getInventory().getContents()) {
                        if(item.getId().equalsIgnoreCase(e.getAdjacentRoom()+"Key")) { 
                            e.setLocked(false); 
                            try {
                                player.setCurrentRoom(e.getAdjacentRoom());
                                Game.print("/bYou have just unlocked "+player.getCurrentRoom().getRoomName()+"!");
                                System.out.printf("You just travelled to [%s]!\n\n", player.getCurrentRoom().getRoomName());
                                System.out.println(player.getCurrentRoom().longDescription());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            return;
                        }
                    }
                    System.out.printf("The room [%s] is currently locked. Maybe come back with a key...\n", e.getAdjacentRoom());
                    return;
                }

                if(!CharacterConstants.LEFT_YOUR_ROOM && room.getRoomName().equals("Your Room") && e.getAdjacentRoom().equals("hallwayLow")) {
                    if(CharacterConstants.READ_LETTER_FROM_BRENT) {
                        Game.print("/bThe door still seems to be blocked by a massive object.");
                        Game.print("/bA note that you didn't notice before is stuck to the wall.");
                        Game.print("/bIt reads: /dbMake your way to the room with the family of ducks;");
                        Game.print("/dbFor there your answer lies - tucked underneath the lake.");
                    } else {
                        Game.print("/bYou tried pushing the door with all your might,");
                        Game.print("/bbut it seems as if someone has blocked the door with a heavy object...");
                        Game.print("/bTry looking around to see what's going on.");
                    }
                    return;
                }

                player.setCurrentRoom(e.getAdjacentRoom());
                try {
                    System.out.printf("You just travelled to [%s]!\n\n", player.getCurrentRoom().getRoomName());
                    Game.print("/b" + player.getCurrentRoom().longDescription());
                } catch(Exception r) {}

                if(!CharacterConstants.LEFT_YOUR_ROOM && e.getAdjacentRoom().equals("brentRoom")) {
                    Game.print("\n/bWhy would Brent's room be behind this wall? Why was my door locked?");
                    Game.print("/bWho killed Glenn? Consider talking to people in the hotel to gather /rclues/b.");
                    CharacterConstants.LEFT_YOUR_ROOM = true;
                }

                return;
            }
        }

        try {
            throw new InvalidRoomException(direction);
        } catch (InvalidRoomException e) {
            e.printStackTrace();
        }
    }
}
