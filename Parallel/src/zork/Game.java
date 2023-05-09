package zork;

import zork.exceptions.CommandNotFoundException;
import zork.proto.Exit;
import zork.proto.Inventory;
import zork.proto.Item;
import zork.proto.Room;
import zork.utils.CommandLoader;
import zork.utils.Parser;

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
	private static Game game = new Game();
	public static Room currentRoom;

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		try {
            CommandLoader.init();
			initItems("src\\zork\\data\\items.json");
			initRooms("src\\zork\\data\\rooms.json");
			currentRoom = roomMap.get("Bedroom");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Game getCurrentGame() {
		return game;
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
			Item item = new Item(itemName, itemWeight, isOpenable);

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

		while (true) {
			try {
				Parser.getCommand().runCommand();
			}
			catch (CommandNotFoundException e) {
				e.printStackTrace();
			}

		}
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
	 * Given a command, process it. Prints out the return value of runCommand().
	 * @param com (Command)
	 * @param args (String[])
	 * @return void
	 */
	// private void processCommand(CommandContext c) {
	// 	switch(name.toLowerCase()) {
	// 		case "take":
	// 			c = new Take();
	// 			c.runCommand(args);
	// 			break;
	// 		case "i":
	// 			//rolls down to the next case
	// 		case "inventory":
	// 			//rolls down to the next case
	// 		case "bag":
	// 			c = new Bag(); // activates for i, inventory and bag (its pretty smart)
	// 			c.runCommand(args);
	// 			break;
	// 	}
	// }

	// implementations of user commands:

	/**
	 * Print out some help information. Here we print some stupid, cryptic message
	 * and a list of the command words.
	 */
	// private void printHelp() {
	// 	System.out.println("You are lost. You are alone. You wander");
	// 	System.out.println("around at Monash Uni, Peninsula Campus.");
	// 	System.out.println();
	// 	System.out.println("Your command words are:");
	// 	parser.showCommands();
	// }

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	// private void goRoom(Command command) {
	// 	if (!command.hasStatement()) {
	// 		// if there is no second word, we don't know where to go...
	// 		System.out.println("Go where?");
	// 		return;
	// 	}

	// 	String direction = command.getStatement();

	// 	// Try to leave current room.
	// 	Room nextRoom = currentRoom.nextRoom(direction);

	// 	if (nextRoom == null)
	// 		System.out.println("There is no door!");
	// 	else {
	// 		currentRoom = nextRoom;
	// 		System.out.println(currentRoom.longDescription());
	// 	}
	// }
}
