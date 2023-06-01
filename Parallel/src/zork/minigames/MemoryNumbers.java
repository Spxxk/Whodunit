package zork.minigames;

import java.util.Scanner;

import zork.proto.Minigame;

public class MemoryNumbers extends Minigame {

    public MemoryNumbers() {
        super("Memory Numbers",(int) 1e9);
    }

    public Scanner in;
    public String nums;
    public int score;
    public boolean finished;

    public static final String RED = "\u001B[31m", WHITE = "\u001B[0m";

    public void play() {
        in = new Scanner(System.in);

        System.out.println("Welcome to Memory Numbers! Get a higher score than MR MINATO to win.");
        System.out.printf("To play, write the number in %sRED%2s once the console tells you to.%n", RED, WHITE);
        System.out.printf("Type start once you have understood the rules: ");

        nums = "";
        finished = false;
        score = 1;

        if(in.nextLine().equalsIgnoreCase("start")) {
            System.out.println("\nRound 1");
            while(!finished) { nextRound(); }
        }
    }

    private void nextRound() {
        try {
            nums += (int) (Math.random() * 10);

            System.out.println(RED + nums + WHITE);
            Thread.sleep(1000);
            printLines();
            
            System.out.print("Repeat number here: ");

            String input;
            if(in.hasNextLine()) { 
                input = in.nextLine();

                if(!input.equals(nums)) {
                    System.out.printf("Correct number was [%s], you recieved a score of %s.%n", RED + nums + WHITE, score);
                    finished = true;
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