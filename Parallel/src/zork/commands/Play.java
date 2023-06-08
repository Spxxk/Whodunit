package zork.commands;

import zork.Constants.ArgumentCount;
import zork.exceptions.MinigameNotFoundException;
import zork.proto.Command;
import zork.proto.Item;
import zork.threads.GameThread;
import zork.utils.MinigameLoader;

public class Play extends Command {
    
    public Play() { super("Play", "Play a certain minigame", ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {

        String minigame = Item.arrayToString(args); // Find the minigame name

        try {
            GameThread gt = new GameThread(MinigameLoader.getMinigame(minigame)); // Game Thread

            gt.start(); 
            gt.join(); // Pause the current thread until the game is done

            Thread.sleep(1000); // Delay after the game is finished

        } catch (MinigameNotFoundException e) {
            e.printStackTrace("cmdHandler"); // If we can't find the minigame
        } catch (InterruptedException e) { 
            e.printStackTrace(); // Internal error
        }
    }
}
