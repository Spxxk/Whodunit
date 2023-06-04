package zork.proto;

import java.util.ArrayList;
import java.util.HashMap;

import zork.Game;
import zork.proto.Character;

public class Room {
    
    private String roomName;
    private String description;
    private Inventory items;
    private ArrayList<Exit> exits;
    private HashMap<String, Boolean> roomFlags;
    private ArrayList<Character> characters;
    
    public ArrayList<Exit> getExits() {
        return exits;
    }
    
    public void setExits(ArrayList<Exit> exits) {
        this.exits = exits;
    }
    
    public Inventory getRoomItems() {
        return items;
    }
    
    public void setRoomItems(Inventory items) {
        this.items = items;
    }

    public HashMap<String, Boolean> getRoomFlags() {
        return roomFlags;
    }

    /**
    * Create a room described "description". Initially, it has no exits.
    * "description" is something like "a kitchen" or "an open court yard".
    */
    public Room(String description) {
        this.description = description;
        exits = new ArrayList<Exit>();
    }
    
    public Room() {
        roomName = "DEFAULT ROOM";
        description = "DEFAULT DESCRIPTION";
        exits = new ArrayList<Exit>();
    }
    
    public void addExit(Exit exit) throws Exception {
        exits.add(exit);
    }
    
    /**
    * Return the description of the room (the one that was defined in the
    * constructor).
    */
    public String shortDescription() {
        return "Room: " + roomName + "\n\n" + description;
    }
    
    /**
    * Return a long description of this room, on the form: You are in the kitchen.
    * Exits: north west
    */
    public String longDescription() {
        String chDescriptions = "";
        for (int i = 0; i < getCharacters().size(); i++)
            chDescriptions += getCharacters().get(i).getDescription() + ".\n";
        
        return "Room: " + roomName + "\n\n" + description + "\n" + chDescriptions + exitString();
    }
    
    /**
    * Return a string describing the room's exits, for example "Exits: north west
    * ".
    */
    private String exitString() {
        String returnString = "Exits: ";
        for (Exit exit : exits) {
            returnString += exit.getDirection() + " ";
        }
        
        return returnString;
    }
    
    /**
    * Return the room that is reached if we go from this room in direction
    * "direction". If there is no room in that direction, return null.
    */
    public Room nextRoom(String direction) {
        try {
            for (Exit exit : exits) {
                
                if (exit.getDirection().equalsIgnoreCase(direction)) {
                    String adjacentRoom = exit.getAdjacentRoom();
                    
                    return Game.roomMap.get(adjacentRoom);
                }
                
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(direction + " is not a valid direction.");
            return null;
        }
        
        System.out.println(direction + " is not a valid direction.");
        return null;
    }
    
    /*
    * private int getDirectionIndex(String direction) { int dirIndex = 0; for
        * (String dir : directions) { if (dir.equals(direction)) return dirIndex; else
            * dirIndex++; }
            * 
            * throw new IllegalArgumentException("Invalid Direction"); }
            */
    public String getRoomName() {
        return roomName;
    }
    
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setCharacters(ArrayList<Character> ch) {
        characters = ch;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }
}
        