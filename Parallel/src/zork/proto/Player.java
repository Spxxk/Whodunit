package zork.proto;

import zork.Game;

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

    public Inventory getInventory() {
        return playerInventory;
    }
}
