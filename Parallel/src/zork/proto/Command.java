package zork.proto;

public abstract class Command {
    private final String name;

    public Command(String cmdName) { name = cmdName; }

    public String getName() { return name; }

    public abstract void runCommand(String... args);
}
