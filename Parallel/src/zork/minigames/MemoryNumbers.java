package zork.minigames;

import java.util.Scanner;

import zork.proto.Minigame;
import zork.Game;

public class MemoryNumbers extends Minigame {

    public MemoryNumbers() {
        super("Memory Numbers",(int) 1e9);
    }

    public Scanner in;
    public String nums;
    public int score;
    public boolean finished;

    public void play() {
        in = new Scanner(System.in);

        Game.print("\n/bWelcome to Memory Numbers! Get a score of 8 than MR MINATO to win.");
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
            nums += (int) (Math.random() * 10);

            Game.print("/r" + nums);
            Thread.sleep(2000);
            printLines();
            
            System.out.print("Repeat number here: ");

            String input;
            if(in.hasNextLine()) { 
                input = in.nextLine();

                if(!input.equals(nums)) {
                    Game.print("/bCorrect number was [/r" + nums + "/b], you recieved a score of " + score + ".");
                    finished = true;
                    if(score >= 8) {
                        Game.print("/bYou defeated MR MINATO!");
                        Game.player.setResult(true);
                    } else 
                        Game.player.setResult(false);
                    return;
                }

                score++;
                System.out.printf("Round %s%n", score);
            }
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