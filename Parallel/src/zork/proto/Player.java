package zork.proto;

import zork.Game;
import java.util.Scanner;

public class Player {
    private final Inventory playerInventory;
    private Room currentRoom;
    
    public Player(int inventoryLimit) {
        playerInventory = new Inventory(inventoryLimit);
        currentRoom = Game.roomMap.get("userRoom");
    }

    public Player(String room, int inventoryLimit) {
        playerInventory = new Inventory(inventoryLimit);
        currentRoom = Game.roomMap.get(room);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String s) {
        currentRoom = Game.roomMap.get(s);
    }

    public Inventory getInventory() {
        return playerInventory;
    }

    public static String setPlayerName() {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String playerName = in.nextLine();
        return playerName;
    }
}
