package zork.utils;

import java.security.NoSuchAlgorithmException;

public class TimeController {
    private final String _hash;
    private long startChrono;
    private boolean started = false;
    
    public TimeController() {
        String proposedHash = null;

        try {
            proposedHash = Hash.generateHash(String.valueOf(Math.random()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Internal Error.");
        }

        _hash = proposedHash;
    }

    public long timeElapsed() throws IllegalAccessException {
        if (!hasStarted()) {
            throw new IllegalAccessException(String.format("TimeController [%s] has not been started!", _hash));
        }

        return getUNIXSeconds() - startChrono;
    }

    public void start() {
        started = true;
        setStartChrono(getUNIXSeconds());
    }

    public boolean hasStarted() {
        return started;
    }

    public static long getUNIXSeconds() {
        return System.currentTimeMillis()/1000;
    }

    public long getStartChrono() {
        return startChrono;
    }

    public void setStartChrono(long t) {
        startChrono = t;
    }

    public String getHash() {
        return _hash;
    }
}