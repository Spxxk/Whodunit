package zork.minigames;

import java.util.*;

import zork.proto.Minigame;
import zork.utils.Dictionary;
import zork.utils.Timer;
import zork.Game;

public class BombParty extends Minigame {

    private Scanner in;
    private String syllable;
    private boolean finished;
    private int score;

    public BombParty() {
        super("Bomb Party");
    }

    public void play() {
        in = new Scanner(System.in);

        Game.print("/bWelcome to Bomb Party! Try to survive as long as possible.");
        Game.print("/bTo play, write a word that contains the syllable in /rRED/b once the console tells you to.");
        System.out.print("Type start once you have understood the rules: ");

        finished = false;

        if(in.nextLine().equalsIgnoreCase("start")) {
            while(!finished) { nextRound(); }
        }
    }

    private void nextRound() {
        try {
            // Random syllable generation (1-2 vowels for simplicity)
            String letters = "abcdefghilmnoprstu";
            syllable = "";
            for (int i = 0; i < 2; i++) {
                syllable += letters.charAt((int)(Math.random() * letters.length()));
            }

            Game.print("/rSyllable: " + syllable);
            
            Game.print("/bIt's your turn. You have 10 seconds to respond.");

            Timer time = new Timer(10);

            time.start();
            String response = in.nextLine().toLowerCase();

            if (time.isOver()|| !isValidWord(response) || !response.contains(syllable)) {
                Game.print("/rYou have been eliminated!/b");
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

    private boolean isValidWord(String word) {
        return Dictionary.exists(word);
    }

    @Override
    public void startGame(String... args) {
        play();
    }
}
