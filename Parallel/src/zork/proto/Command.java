package zork.proto;

import zork.Constants.ArgumentCount;

public abstract class Command {
    private final String name;
    public final ArgumentCount argumentLimit;

    public Command(String cmdName, ArgumentCount limit) {
        name = cmdName;
        argumentLimit = limit;
    }

    public String getName() { return name; }

    public boolean checkArgs(String[] args) {
        if (argumentLimit == ArgumentCount.INFINITE || argumentLimit.argCount() == args.length) {
            return true;
        } 

        return false;
    }

    public abstract void runCommand(String... args);
}
