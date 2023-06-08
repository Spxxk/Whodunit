package zork.minigames;

import java.util.Scanner;

import zork.proto.Minigame;
import zork.Game;

public class MemoryNumbers extends Minigame {

    public MemoryNumbers() {
        super("Memory Numbers");
    }

    public Scanner in;
    public String nums;
    public int score;
    public boolean finished;

    public void play() {
        in = new Scanner(System.in);

        Game.print("\n/bWelcome to Memory Numbers! Get a score of 8 to defeat MR MINATO.");
        Game.print("/bTo play, write the number in /rRED/b once the console tells you to.");
        System.out.print("Type start once you have understood the rules: ");

        nums = "";
        finished = false;
        score = 1;

        if(in.nextLine().equalsIgnoreCase("start")) {
            Game.print("\n/bRound 1");
            while(!finished) { nextRound(); }
        }
    }

    private void nextRound() {
        try {
            nums += (int) (Math.random() * 10); // Generate a random number

            Game.print("/r" + nums); // The new number

            Thread.sleep(2000); // 2 seconds to look at the number
            printLines();
            
            System.out.print("Repeat number here: ");

            String input = in.nextLine();

            if(!input.equals(nums)) { // If the answer is incorrect
                Game.print("/bCorrect number was [/r" + nums + "/b], you recieved a score of " + score + "."); // Display the right answer
                finished = true; // Game is done
                if(score >= 8) { // If we get to 8 though, we win
                    Game.print("/bYou defeated MR MINATO!"); // Inform the user
                    Game.player.setResult(true); // Status won
                } else 
                    Game.player.setResult(false); // Status lost
                return;
            }

            // Number is right if we get here

            score++; // Increment the score
            System.out.printf("Round %d%n", score); // Displaying the round #

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printLines() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    @Override
    public void startGame(String... args) {
        play();
    }
    
}