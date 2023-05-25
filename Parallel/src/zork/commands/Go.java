package zork.commands;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.exceptions.InvalidRoomException;
import zork.proto.Command;
import zork.proto.Exit;
import zork.proto.Player;
import zork.proto.Room;

public class Go extends Command {
    
    public Go() { super("Go", ArgumentCount.ONE); }

    public void runCommand(String... args) {
        Player player = Game.player;
        Room room = player.getCurrentRoom();
        String direction = args[0];

        for (Exit e : room.getExits()) {
            if (e.getDirection().equalsIgnoreCase(direction)) {
                player.setCurrentRoom(e.getAdjacentRoom());
                System.out.printf("You just travelled to [%s]!\n\n", player.getCurrentRoom().getRoomName());
                System.out.println(player.getCurrentRoom().longDescription());
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