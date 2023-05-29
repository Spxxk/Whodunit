package zork;

import zork.proto.Exit;
import zork.proto.Inventory;
import zork.proto.Item;
import zork.proto.Player;
import zork.proto.Room;
import zork.threads.CommandListener;
import zork.utils.CommandLoader;

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

    public static Player player;

    private static Game game = new Game();

    private static final Thread cmdListener = new CommandListener();

	private static final HashMap<String, Boolean> STORY_FLAGS = new HashMap<String, Boolean>();

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		try {
            CommandLoader.init();
			initItems();
			initRooms();

            player = new Player("userRoom",100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Game getCurrentGame() {
		return game;
	}

	private void initItems() throws Exception {
		Path path = Path.of("src\\zork\\data\\items.json");
		String jsonString = Files.readString(path);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(jsonString);

		JSONArray jsonItems = (JSONArray) json.get("items");

		for (Object itemObj : jsonItems) {
			String itemName = (String) ((JSONObject) itemObj).get("name");
			String itemId = (String) ((JSONObject) itemObj).get("id");
			Double itemWeight = Double.parseDouble(((JSONObject) itemObj).get("weight") + "");
			Boolean isOpenable = (Boolean) ((JSONObject) itemObj).get("isOpenable");
			Boolean needsContext = (Boolean) ((JSONObject) itemObj).get("needsContext");
			Item item = new Item(itemName, itemWeight, isOpenable, needsContext);

			itemList.put(itemId, item);
		}
	}

	private void initRooms() throws Exception {
		Path path = Path.of("src\\zork\\data\\rooms.json");
		String jsonString = Files.readString(path);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(jsonString);

		JSONArray jsonRooms = (JSONArray) json.get("rooms");

		for (Object roomObj : jsonRooms) {
			Room room = new Room();
			String roomName = (String) ((JSONObject) roomObj).get("name");
			String roomId = (String) ((JSONObject) roomObj).get("id");
			int roomCapacity = Integer.parseInt(String.valueOf(((JSONObject) roomObj).get("capacity")));
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
		
        cmdListener.start();
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
		System.out.println(Game.player.getCurrentRoom().longDescription());
	}
}
