package zork.Proto;

public abstract class Command {
    private final String name;

    public Command(String cmdName) { this.name = cmdName; }

    public String getName() { return name; }

    public abstract void runCommand(String... args);
}
