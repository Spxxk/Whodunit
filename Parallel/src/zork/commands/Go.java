package zork.commands;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.exceptions.InvalidRoomException;
import zork.proto.Command;
import zork.proto.Exit;
import zork.proto.Player;
import zork.proto.Room;
import zork.proto.Item;

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

                player.setCurrentRoom(e.getAdjacentRoom());
                try {
                System.out.printf("You just travelled to [%s]!\n\n", player.getCurrentRoom().getRoomName());
                Game.print("/b" + player.getCurrentRoom().longDescription());
                } catch(Exception r) {}
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
