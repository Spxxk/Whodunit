package zork.minigames;

import java.util.Scanner;

import zork.proto.Minigame;

public class TicTacToe extends Minigame {
    private String[][] grid;
    private Scanner in;

    private static final int PLAYER = 0, COM = 1;
    private boolean finished = false;

    public TicTacToe() { super("Tic Tac Toe", (int) 1e9); }

    public void startGame(String... args) {
        in = new Scanner(System.in);

        initializeGrid();

        System.out.println("Welcome to Tic Tac Toe! Defeat MR MCMULLEN to be able to move on.");
        
        while (!finished) { playerTurn(); comTurn(); }

        finished = false;
    }
    
    private void comTurn() {
        displayGrid();

        addToGrid(COM, comAsker());
    }


    private int[] comAsker() {
        int row, col;
        while(true) {
            row = (int) (Math.random() * 3); col = (int) (Math.random() * 3);

            if(!grid[row][col].equals("-")) { continue; }
            break;
        }

        return new int[] { row, col };
    }


    private void playerTurn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        displayGrid();
        
        addToGrid(PLAYER, playerAsker());
    }

    private void addToGrid(int player, int[] loc) {
        grid[loc[0]][loc[1]] = player == PLAYER ? "X" : "0";

        checkGrid(player);
    }


    private void checkGrid(int player) {
        String c = player == PLAYER ? "X" : "0", g = "";

        for (String[] row : grid) {
            for (String val : row) {
                g += val;
            }
            if(g.equals(c + c + c)) { endGame(player); return; }
            g = "";
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                g += grid[j][i];
            }
            if(g.equals(c + c + c)) { endGame(player); return; }
            g = "";
        }

        if(grid[0][0].equals(c)) {
            for (int i = 0; i < grid.length; i++) {
                g += grid[i][i];
            }
            if(g.equals(c + c + c)) { endGame(player); return; }
        }

        if(grid[0][2].equals(c) && grid[1][1].equals(c) && grid[2][0].equals(c)) {
            endGame(player); return;
        }

        checkTie();

        System.out.println();
    }


    private void checkTie() {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(!grid[i][j].equals("-")) { count++; }
            }
        }
        if(count == 9) {
            System.out.println("The game ended in a tie against MR MCMULLEN.");

            displayGrid();
            finished = true;
        }
    }


    private void endGame(int player) {
        String message = player == PLAYER ? "You" : "MR MCMULLEN";
        System.out.printf("%n%s won the game!%n", message);
        
        if(player == COM) System.out.println("Better luck next time...");

        displayGrid();
        finished = true;
    }


    private int[] playerAsker() {
        while(true) {
            try{
                System.out.print("\nWhich row would you like to play in? (1), (2), (3): ");

                int row = Integer.parseInt(in.nextLine()); 
                if(row < 1 || row > 3) { System.out.println("Please enter a valid integer between 1-3, inclusive, to play."); continue; }

                System.out.print("Which column would you like to play in? (1), (2), (3): ");

                int col = Integer.parseInt(in.nextLine());
                if(col < 1 || col > 3) { System.out.println("Please enter a valid integer between 1-3, inclusive, to play."); continue; }

                if(!grid[row - 1][col - 1].equals("-")) { System.out.println("Please use a valid space to play your turn."); continue; } 

                return new int[] { row - 1, col - 1 };
            } catch(NumberFormatException e) {
                System.out.println("Please enter a valid integer between 1-3, inclusive, to play.");
            }
        }
    }


    private void initializeGrid() {
        grid = new String[3][3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = "-";
            }
        }
    }

    private void displayGrid() {
        if(!finished) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}