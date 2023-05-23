package zork.commands;

import zork.Game;
import zork.Constants.ArgumentCount;
import zork.exceptions.InvalidRoomException;
import zork.proto.Command;
import zork.proto.Exit;
import zork.proto.Room;

public class Go extends Command {
    
    public Go() { super("Go", ArgumentCount.ONE); }

    public void runCommand(String... args) {
        Room room = Game.player.getCurrentRoom();
        String direction = args[0];

        for (Exit e : room.getExits()) {
            if (e.getDirection().equalsIgnoreCase(direction)) {
                Game.player.setCurrentRoom(e.getAdjacentRoom());
                System.out.printf("You just travelled to [%s]!\n", e.getAdjacentRoom());
                System.out.println(Game.player.getCurrentRoom().longDescription());
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