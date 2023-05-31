package zork.proto;

import java.security.NoSuchAlgorithmException;

import zork.threads.ChronoHandler;
import zork.utils.Hash;
import zork.utils.Timer;

public abstract class Minigame {
    private final String name;
    private final String _hash;

    public final int timeLimit;
    private final ChronoHandler timer;

    public Minigame(String cmdName, int limit) {
        name = cmdName;
        timeLimit = limit;

        timer = new ChronoHandler(new Timer(timeLimit));

        String proposedHash = null;

        try {
            proposedHash = Hash.generateHash(String.valueOf(Math.random()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Internal Error.");
        }

        _hash = proposedHash;
    }

    public String getHash() { return _hash; }

    public String getName() { return name; }

    public abstract void startGame(String... args);
}
