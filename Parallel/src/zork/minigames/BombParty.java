package zork.minigames;

import java.util.*;

import zork.proto.Minigame;
import zork.Game;

public class BombParty extends Minigame {

    private Scanner in;
    private String syllable;
    private boolean finished;
    private int score;

    public BombParty() {
        super("Bomb Party",(int) 1e9);
    }

    public void play() {
        in = new Scanner(System.in);

        Game.print("/bWelcome to Bomb Party! Try to survive as long as possible.");
        Game.print("/bTo play, write a word that contains the syllable in /rRED%/b once the console tells you to.");
        System.out.print("Type start once you have understood the rules: ");

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

            Game.print("/rSyllable: " + syllable);
            
            Game.print("/bIt's your turn. You have 10 seconds to respond.");
            long startTime = System.currentTimeMillis();
            String response = in.nextLine();
            long responseTime = (System.currentTimeMillis() - startTime) / 1000;

            if (responseTime > 10 || !isValidWord(response) || !response.contains(syllable)) {
                Game.print("/bYou have been eliminated!");
                finished = true;
                Game.player.setResult(false);
                return;
            }

            System.out.println();
            score++;
            if(score >= 10) {
                Game.player.setResult(true);
                finished = false;
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
