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

        String minigame = Item.arrayToString(args);

        try {
            GameThread gt = new GameThread(MinigameLoader.getMinigame(minigame));

            gt.start();
            gt.join();

            Thread.sleep(1000);
            System.out.println();
        } catch (MinigameNotFoundException e) {
            e.printStackTrace("cmdHandler");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
