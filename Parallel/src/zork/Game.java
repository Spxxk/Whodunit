package zork;

import zork.commands.Take;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Game {

	public static HashMap<String, Room> roomMap = new HashMap<String, Room>();
	public static HashMap<String, Item> itemList = new HashMap<String, Item>();
	public static Inventory playerInventory = new Inventory(100);
	public static Room currentRoom;

	private Parser parser;

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		try {
			initItems("src\\zork\\data\\items.json");
			initRooms("src\\zork\\data\\rooms.json");
			currentRoom = roomMap.get("Bedroom");
		} catch (Exception e) {
			e.printStackTrace();
		}
		parser = new Parser();
	}

	private void initItems(String fileName) throws Exception {
		Path path = Path.of(fileName);
		String jsonString = Files.readString(path);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(jsonString);

		JSONArray jsonItems = (JSONArray) json.get("items");

		for (Object itemObj : jsonItems) {
			String itemName = (String) ((JSONObject) itemObj).get("name");
			String itemId = (String) ((JSONObject) itemObj).get("id");
			Double itemWeight = Double.parseDouble(((JSONObject) itemObj).get("weight") + "");
			Boolean isOpenable = (Boolean) ((JSONObject) itemObj).get("isOpenable");
			Item item = new Item(itemWeight, itemName, isOpenable);

			itemList.put(itemId, item);
		}
	}

	private void initRooms(String fileName) throws Exception {
		Path path = Path.of(fileName);
		String jsonString = Files.readString(path);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(jsonString);

		JSONArray jsonRooms = (JSONArray) json.get("rooms");

		for (Object roomObj : jsonRooms) {
			Room room = new Room();
			String roomName = (String) ((JSONObject) roomObj).get("name");
			String roomId = (String) ((JSONObject) roomObj).get("id");
			int roomCapacity = Integer.parseInt(((JSONObject) roomObj).get("capacity") + "");
			String roomDescription = (String) ((JSONObject) roomObj).get("description");
			room.setDescription(roomDescription);
			room.setRoomName(roomName);

			JSONArray jsonItems = (JSONArray) ((JSONObject) roomObj).get("items");
			Inventory roomItems = new Inventory(roomCapacity);
			for(Object itemObj : jsonItems) {
				if(((JSONObject) itemObj).get("id") != null) {
					roomItems.addItem(itemList.get((String) ((JSONObject) itemObj).get("id")));
				}
			}
			room.setRoomItems(roomItems);

			JSONArray jsonExits = (JSONArray) ((JSONObject) roomObj).get("exits");
			ArrayList<Exit> exits = new ArrayList<Exit>();
			for (Object exitObj : jsonExits) {
				String direction = (String) ((JSONObject) exitObj).get("direction");
				String adjacentRoom = (String) ((JSONObject) exitObj).get("adjacentRoom");
				String keyId = (String) ((JSONObject) exitObj).get("keyId");
				Boolean isLocked = (Boolean) ((JSONObject) exitObj).get("isLocked");
				Boolean isOpen = (Boolean) ((JSONObject) exitObj).get("isOpen");
				Exit exit = new Exit(direction, adjacentRoom, isLocked, keyId, isOpen);
				exits.add(exit);
			}
			room.setExits(exits);
			roomMap.put(roomId, room);
		}
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();

		boolean finished = false;
		while (!finished) {
			Command command;
			try {
				command = parser.getCommand();
				finished = processCommand(command);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Thank you for playing.  Good bye.");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("Welcome to Zork!");
		System.out.println("Zork is a new, incredibly boring adventure game.");
		System.out.println("Type 'help' if you need help.");
		System.out.println();
		System.out.println(currentRoom.longDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command. If this command ends
	 * the game, true is returned, otherwise false is returned.
	 */
	private boolean processCommand(Command command) {
		if (command.isUnknown()) {
			System.out.println("I don't know what you mean...");
			return false;
		}

		Command com;
		String commandWord = command.getCommandWord();
		if (commandWord.equals("help"))
			printHelp();
		else if (commandWord.equals("go"))
			goRoom(command);
		else if (commandWord.equals("quit")) {
			if (command.hasStatement())
				System.out.println("Quit what?");
			else
				return true; // signal that we want to quit
		} else if (commandWord.equals("eat")) {
			System.out.println("Do you really think you should be eating at a time like this?");
		} else if(commandWord.equals("drop")) {
			if(command.hasStatement()) {
					
			}
			else {
				System.out.println("Drop what?");
				Command newCommand;
				//for dropping items
			}
		}
		else if(commandWord.equals("take")) {
			try {
				for (int i = 0; i < currentRoom.getRoomItems().getInventory().size(); i++) {
					Item item = currentRoom.getRoomItems().getInventory().get(i);
					if(command.getStatement().toLowerCase().equals(item.getName().toLowerCase())) {
						com = new Take(item, currentRoom.getRoomItems(), playerInventory);

						Inventory[] newInvs = ((Take) com).takeItem();
						currentRoom.setRoomItems(newInvs[0]); playerInventory = newInvs[1];

						System.out.println("You picked up a " + item.getName() + ".");
					}	
				}
			}
			catch(NullPointerException e) {
				System.out.println("Take what?");
			}
		}
		else if(commandWord.equals("l") || commandWord.equals("look")) {
			boolean isEmpty = true;
			for (Item item : currentRoom.getRoomItems().getInventory()) {
				isEmpty = false;
				System.out.print(item.getName() + ", "); // just a rough copy dont mald we can change this later.
			}
			if(isEmpty)
				System.out.println("The room is empty.");
			else
				System.out.println();
		}
		else if(commandWord.equals("i") || commandWord.equals("inventory")) {
			for (Item item : playerInventory.getInventory()) {
				System.out.print(item.getName() + ", "); // just a rough copy dont mald we can change this later.
			}
			System.out.println();
		}
		return false;
	}

	// implementations of user commands:

	/**
	 * Print out some help information. Here we print some stupid, cryptic message
	 * and a list of the command words.
	 */
	private void printHelp() {
		System.out.println("You are lost. You are alone. You wander");
		System.out.println("around at Monash Uni, Peninsula Campus.");
		System.out.println();
		System.out.println("Your command words are:");
		parser.showCommands();
	}

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private void goRoom(Command command) {
		if (!command.hasStatement()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Go where?");
			return;
		}

		String direction = command.getStatement();

		// Try to leave current room.
		Room nextRoom = currentRoom.nextRoom(direction);

		if (nextRoom == null)
			System.out.println("There is no door!");
		else {
			currentRoom = nextRoom;
			System.out.println(currentRoom.longDescription());
		}
	}
}
