package zork;

import zork.proto.Exit;
import zork.proto.Inventory;
import zork.proto.Item;
import zork.proto.Player;
import zork.proto.Room;
import zork.proto.Character;
import zork.proto.Command;
import zork.threads.CommandListener;
import zork.threads.DialogueThread;
import zork.utils.CommandLoader;
import zork.utils.Dictionary;
import zork.utils.Give;
import zork.utils.CharacterConstants;
import zork.utils.MinigameLoader;
import zork.utils.Music;
import zork.commands.Play;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Game {

	public static HashMap<String, Room> roomMap = new HashMap<String, Room>();
	public static HashMap<String, Item> itemList = new HashMap<String, Item>();
	public static HashMap<String, Character> characterList = new HashMap<String, Character>();

    public static Player player;

    private static Game game = new Game();

    private static final Thread cmdListener = new CommandListener(), dialogueThread = new DialogueThread();

	static final String GREEN_TEXT = "\033[1;32m", RESET = "\033[0m", RED_TEXT = "\033[1;31m", BLUE_TEXT = "\033[1;34m";

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		try {
            CommandLoader.init();
            MinigameLoader.init();
			Dictionary.initDictionary();
			
			initCharacters();
			initItems();
			initRooms();

			Music music = new Music();
			
			music.play();
            player = new Player("userRoom",100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Game getCurrentGame() {
		return game;
	}

	private void initCharacters() throws Exception {
		Path path = Path.of("src\\zork\\data\\npc.json");
		String jsonString = Files.readString(path);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(jsonString);

		JSONArray jsonItems = (JSONArray) json.get("characters");

		for (Object characterObj : jsonItems) {
			String characterName = (String) ((JSONObject) characterObj).get("name");
			String characterId = (String) ((JSONObject) characterObj).get("id");
			String characterDescription = (String) ((JSONObject) characterObj).get("description");

			Character character = new Character(characterId, characterName, characterDescription);

			characterList.put(characterId, character);
		}
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

			item.setId(itemId);
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

			JSONArray jsonCharacters = (JSONArray) ((JSONObject) roomObj).get("npcs");
			ArrayList<Character> characters = new ArrayList<Character>();
			for(Object charObj : jsonCharacters) {
				if(((JSONObject) charObj).get("id") != null) { characters.add(characterList.get((String) ((JSONObject) charObj).get("id"))); }
			}
			room.setCharacters(characters);

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
	public void play(boolean test) throws InterruptedException {
		if(!test) {
			printWelcome();
			player.setPlayerName();
			print("\n/bHey there, "+player.getPlayerName()+". Get ready for an eventful stretch of time coming your way.");
			printStory();
		} 
		else { player.setPlayerName(0); }
		print("/b" + Game.player.getCurrentRoom().longDescription());
		
        cmdListener.start();
		dialogueThread.start();		
	}

	private void printStory() throws InterruptedException {
		System.out.println();
		print("/bYou went on a trip with your friends Brent and Glenn to a fancy tropical resort.");
		print("/bHowever, you woke up this morning,");
		print("/band something was off........");
		print("/bTravel around to see what's going on.");
		System.out.println();
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() throws InterruptedException{
		System.out.println();
		print("/bWelcome to Whodunit!");
		print("/bWhodunit is a murder mystery game in which you find clues and crack a case.");
		print("/bType 'help' if you need help.");
		System.out.println();
	}

	public static void dialogueLoop(String id) {
		switch(id) {
			case "police":
				if(!CharacterConstants.GAVE_ROOM_KEY) {
					print("Hey there /p, I was looking to speak with you.");
					print("I heard your buddy died and came running here.");
					print("So far, we don't know much about the case, but it might be helpful to");
					print("speak with the /rreceptionist/g east of here about accessing Glenn's room.");
				}
				else if(CharacterConstants.GAVE_ROOM_KEY) {
					print("Ah, I see you got the room key from the receptionist.");
					print("Use that key to unlock Glenn's room /rnorthwest/g of the elevator.");
					print("Good luck on your investigation, /p, and remember I'm here to help you if you need me.");
				}
				break;

			case "receptionist":
				if(!CharacterConstants.GAVE_ROOM_KEY) {
					print("Hi /p! The officer over there told me to give you this.");
					if(Give.giveItem(itemList.get("glennRoomKey"), "receptionist")) {
						print("Use this to continue your investigation into your friend's murder.");
						print("I feel super bad for you, but I'm afraid this is all I can help with.");
						print("I'll call you if I ever find out more information.");
						CharacterConstants.GAVE_ROOM_KEY = true;
					}
				}
				else if(CharacterConstants.GAVE_ROOM_KEY) {
					print("Hi again /p, hope your investigation is going well.");
					print("If there's anything you need help with, please ask me.");
					print("Have you used the key to check Glenn's room? It may provide you with clues.");
				}
				break;

			case "walletOwner":
				if(!CharacterConstants.GAVE_WALLET && CharacterConstants.READ_NOTE) {
					print("Hey there /p! This resort is pretty nice, huh?");
					print("Anyways, I heard that there's something going on at the casino later, but you need money to get in.");
					print("I have a wallet with $250 for you, but only if you can get 60 words per minute on a typing test.");
					print("So, /p, you wanna take on the challenge?");
					Scanner in = new Scanner(System.in);
					while(true){
						String ans = in.nextLine();
						if(ans.equalsIgnoreCase("yes")){
							print("You're on, /p!");
							runMinigame("Typing Test");
							if(player.getResult()){
								print("Excellent work /p! The money is now yours.");
								if(Give.giveItem(itemList.get("casinoKey"),"Wallet Owner")){
									print("Use this to access the casino when you please. See ya /p!");
									CharacterConstants.GAVE_WALLET = true;
								}
								return;
							}else{
								print("Unfortunately, you couldn't pass the typing test. Would you like to try again?");
							}
						}else if(ans.equalsIgnoreCase("no")){
							print("No problem /p. Remember, I'm always chilling by the pool in case you change your mind!");
						}
					}
				}else if(CharacterConstants.GAVE_WALLET){
					print("Great to see you again /p!");
					print("Have you visited the casino yet? Remember, play wisely!");
				}
				else {
					print("Did you know this is the #1 rated resort in our county?");
					print("It really makes sense when you look at what it has to offer.");
					print("A bummer that a murder had to happen during my vacation...");
				}
				break;

			case "invitationMan":
				if(!CharacterConstants.GAVE_INVITATION && CharacterConstants.READ_NOTE) {
					print("Hello there, you must be /p!");
					print("I am supposed to attend an event in the casino's private poker room, but I won't be able to make it");
					print("The invitation can be all yours, but only if you beat me in Tic Tac Toe.");
					print("So, /p, are you ready to challenge the master?");
					Scanner in = new Scanner(System.in);
					while(true){
						String ans = in.nextLine();
						if(ans.equalsIgnoreCase("yes")){
							print("Bring it on, /p!");
							runMinigame("Tic Tac Toe");
							if(player.getResult()){
								print("Wow, you're pretty good. Here's the invitation, /p!");
								if(Give.giveItem(itemList.get("privatePokerTableKey"),"Mr. McMullen")){
									print("Have fun at the event!");
									CharacterConstants.GAVE_INVITATION = true;
								}
								return;
							}else{
								print("Yes! I win this time! I'll give you another change /p, want to rematch?");
							}
						}
					}
				}else if(CharacterConstants.GAVE_INVITATION){
					print("Greetings, p/! How are you on this fine day?");
					print("The date for the event is approaching rapidly, don't miss it!");
				}
				else {
					print("Private poker table... ticket for /r/p/g... I think");
					print("I have to wait before enacting the leader's master plan...");
				}
				break;

			case "hotelStaff":
				if(!CharacterConstants.GAVE_INFO && CharacterConstants.READ_NOTE) {
					print("Hello? Is that /p? What are you doing here?");
					print("Okay, fine, I'll let you stay, even though I'm not supposed to.");
					print("Anyways, I've heard you were investigating some issues around the hotel, and I may be able to help you out.");
					print("If you can beat round 8 on a number memory test, I'll give you the info. The rules are simple:");
					print("Each round you will be given a number, each one a digit larger than the previous one. Enter the correct number to beat the round.");
					print("So, /p, you wanna take on the challenge?");
					Scanner in = new Scanner(System.in);
					while(true){
						String ans = in.nextLine();
						if(ans.equalsIgnoreCase("yes")){
							print("You're on, /p!");
							runMinigame("Memory Numbers");
							if(player.getResult()){
								print("Ok /p, here's what I can tell you:");
								print("In this world, it's risky business to trust anyone. The suspect could be anyone at the resort,");
								print("even someone extremely close to you. Keep this in mind as you dive deeper into your investigation. Good luck /p!");
								CharacterConstants.GAVE_INFO = true;
								return;
							}else{
								print("Unfortunately, you couldn't pass the number memory test. Would you like to try again?");
							}
						}else if(ans.equalsIgnoreCase("no")){
							print("No problem /p. Remember, I'm always up here if you change your mind.");
						}
					}
				}else if(CharacterConstants.GAVE_INFO){
					print("Nice seeing you again /p!");
					print("How did the information help you out? Remember to stay safe when investigating.");
				} else {
					print("How did you get in here? Get out of here now!");
				}
				break;

			case "brentAndFriends":
				print("Well well well, if it isn't /p.");
				print("It's a shame what happened to Glenn. But there's one thing I should let you know: it was ME!");
				print("I get sick to my stomach when I see Glenn with Emily,");
				print("so I decided to put an end to it. Now /p, we're gonna play a game of poker.");
				print("If you win, you could turn me into the cops and I won't have any money to get a lawyer.");
				print("But if you lose, it's all over for you.");
				runMinigame("Poker");
				if(player.getResult()){
					printWin();
				}else{
					printLoss();
				}
				break;

			case "littleGirl":
				print("Hi mister! Mommy told me to stay upstairs while she goes downstairs and checks out the crime scene.");
				print("You can get downstairs by going /reast/g of here and then south on the elevator.");
				break;
		}
	}

	public static void print(String line) {
		line = playerEscapeSequence(line);
		line = redEscapeSequence(line);
		line = greenEscapeSequence(line);
		line = blueEscapeSequence(line);
		line = resetEscapeSequence(line);

		try {
			System.out.print(GREEN_TEXT);

			for (int i = 0; i < line.length(); i++) {
				System.out.print(line.charAt(i));
				Thread.sleep(20);
			}
			System.out.println(RESET);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static String blueEscapeSequence(String line) {
		while(line.indexOf("/db") != -1) {
			int p = line.indexOf("/db");
			line = line.substring(0, p) + BLUE_TEXT + line.substring(p + 3);
		}

		return line;
	}

	private static String resetEscapeSequence(String line) {
		while(line.indexOf("/b") != -1) {
			int p = line.indexOf("/b");
			line = line.substring(0, p) + RESET + line.substring(p + 2);
		}

		return line;
	}

	private static String greenEscapeSequence(String line) {
		while(line.indexOf("/g") != -1) {
			int p = line.indexOf("/g");
			line = line.substring(0, p) + GREEN_TEXT + line.substring(p + 2);
		}

		return line;
	}

	private static String redEscapeSequence(String line) {
		while(line.indexOf("/r") != -1) {
			int p = line.indexOf("/r");
			line = line.substring(0, p) + RED_TEXT + line.substring(p + 2);
		}

		return line;
	}

	public static String playerEscapeSequence(String line) {
		while(line.indexOf("/p") != -1) {
			int p = line.indexOf("/p");
			line = line.substring(0, p) + player.getPlayerName() + line.substring(p + 2);
		}

		return line;
	}

	public static void runMinigame(String minigame) {
		Command play = new Play();
		play.runCommand(minigame);
	}

	public static void printWin() {
		print("\n/bYou win! You found out Whodunit! Congrats /p!");
		System.exit(0);
	}

	public static void printLoss() {
		print("\n/rUnfortunately, you lost the game of poker, and Brent . YOU LOSE.");
		System.exit(0);
	}
}