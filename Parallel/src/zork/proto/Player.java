package zork.proto;

import zork.Game;
import zork.utils.Print;

import java.util.Scanner;

public class Player {
    private final Inventory playerInventory;
    private Room currentRoom;
    private String name;
    private Character characterTalkingTo;
    
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

    public void setPlayerName() {
        Scanner in = new Scanner(System.in);
        Print.printSlowly("What is your name? ");
        name = in.nextLine();
    }

    public String getPlayerName() {
        return this.name;
    }

    public Character getCharacterTalkingTo() {
        return characterTalkingTo;
    }

    public void setCharacterTalkingTo(Character c) {
        characterTalkingTo = c;
    }
}
