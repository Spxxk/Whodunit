package zork.proto;

import java.security.NoSuchAlgorithmException;

import zork.utils.Hash;

public abstract class Minigame {
    private final String name;
    private final String _hash;

    public Minigame(String cmdName) {
        name = cmdName;

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
