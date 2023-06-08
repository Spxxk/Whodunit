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
    
    public Go() { super("Go", "Go in a certain direction", ArgumentCount.ONE); } // Super constructor (name, arguments)

    public void runCommand(String... args) {
        Player player = Game.player; // Player
        Room room = player.getCurrentRoom(); // Room
        String direction = args[0]; // Direction

        for (int i = 0; i < room.getExits().size(); i++) {
            Exit e = room.getExits().get(i); // Exits of the current room
            
            if (e.getDirection().equalsIgnoreCase(direction)) { // Check if direction is the selected one
                if(e.isLocked()) { // If it's locked and we have the key, access will be granted, we don't need to "unlock" the room
                    for(Item item : player.getInventory().getContents()) {
                        if(item.getId().equalsIgnoreCase(e.getAdjacentRoom()+"Key")) { 

                            player.setCurrentRoom(e.getAdjacentRoom());

                            System.out.printf("You just travelled to [%s]!\n\n", player.getCurrentRoom().getRoomName());
                            System.out.println(player.getCurrentRoom().longDescription()); // Informs the player
                        
                            return;
                        }
                    }

                    System.out.printf("The room [%s] is currently locked. Maybe come back with a key...\n", e.getAdjacentRoom());
                    return;
                }
                
                // Hints for the player 

                if (!CharacterConstants.LEFT_YOUR_ROOM && room.getRoomName().equals("Your Room") && e.getAdjacentRoom().equals("hallwayLow")) { 
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

                player.setCurrentRoom(e.getAdjacentRoom()); // Going to the new room

                System.out.printf("You just travelled to [%s]!\n\n", player.getCurrentRoom().getRoomName());
                Game.print("/b" + player.getCurrentRoom().longDescription()); // Informing the player about it


                if(!CharacterConstants.LEFT_YOUR_ROOM && e.getAdjacentRoom().equals("brentRoom")) {
                    Game.print("\n/bWhy would Brent's room be behind this wall? Why was my door locked?");
                    Game.print("/bWho killed Glenn? Consider talking to people in the hotel to gather /rclues/b.");
                    CharacterConstants.LEFT_YOUR_ROOM = true;
                }

                return;
            }
        }

        try {
            throw new InvalidRoomException(direction); // If we get here, that means the direction we are trying to go does not lead to a room
        } catch (InvalidRoomException e) {
            e.printStackTrace();
        }
    }
}
