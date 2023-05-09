package zork.utils;

public class Timer extends TimeController {
    private final int duration;

    public Timer(int duration) {
        this.duration = duration;
    }

    public boolean isOver() throws IllegalAccessException {
        return timeElapsed() >= duration;
    }
}
