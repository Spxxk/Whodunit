package zork.minigames;

import java.util.*;

import zork.proto.Minigame;

public class BombParty extends Minigame {

    private Scanner in;
    private String syllable;
    private boolean finished;

    public static final String RED = "\u001B[31m", WHITE = "\u001B[0m";

    public BombParty() {
        super("Bomb Party",(int) 1e9);
    }

    public void play() {
        in = new Scanner(System.in);

        System.out.println("Welcome to Bomb Party! Try to survive as long as possible.");
        System.out.printf("To play, write a word that contains the syllable in %sRED%2s once the console tells you to.%n", RED, WHITE);
        System.out.printf("Type start once you have understood the rules: ");

        finished = false;

        if(in.nextLine().equalsIgnoreCase("start")) {
            while(!finished) { nextRound(); }
        }
    }

    private void nextRound() {
        try {
            // Random syllable generation (1-2 vowels for simplicity)
            String vowels = "aeiou";
            syllable = "";
            for (int i = 0; i < 1 + (int)(Math.random() * 2); i++) {
                syllable += vowels.charAt((int)(Math.random() * vowels.length()));
            }

            System.out.println(RED + "Syllable: " + syllable + WHITE);
            
            System.out.println("It's your turn. You have 10 seconds to respond.");
            long startTime = System.currentTimeMillis();
            String response = in.nextLine();
            long responseTime = (System.currentTimeMillis() - startTime) / 1000;

            if (responseTime > 10 || !isValidWord(response) || !response.contains(syllable)) {
                System.out.println("You have been eliminated!");
                finished = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Placeholder method. Replace with a method that checks the word in a real dictionary.
    private boolean isValidWord(String word) {
        // Check the word in your dictionary here
        return true;
    }

    @Override
    public void startGame(String... args) {
        play();
    }
}
