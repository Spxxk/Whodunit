package zork.utils;

import java.util.*;

import zork.exceptions.*;
import zork.proto.Minigame;

public class MinigameLoader {
    private static final Map<String, Minigame> minigames = new HashMap<>();

    public static void init() {
        try {
            Class<?>[] classes = Loader.getClasses("zork.minigames");

            for (Class<?> c : classes) {
                Minigame game = (Minigame) c.getConstructors()[0].newInstance();
                minigames.put(game.getName().toLowerCase(), game);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    public static Minigame getMinigame(String n) throws MinigameNotFoundException {
        Minigame c = minigames.get(n.toLowerCase());

        if (c == null) 
            throw new MinigameNotFoundException(n);

        return c;
    }
}
