package zork.exceptions;

import zork.Game;

public class InvalidRoomException extends Exception {
    String context;

    public InvalidRoomException(String e) {
        context = e;
    }

    public void printStackTrace() {
        System.out.printf("Cannot find a room [%s] of [%s]\n", context, Game.player.getCurrentRoom().getRoomName());
    }
}
