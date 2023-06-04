package zork.proto;

import zork.Constants.ArgumentCount;

public abstract class Command {
    private final String name;
    private final String desc;
    public final ArgumentCount argumentLimit;

    public Command(String cmdName, String cmdDesc, ArgumentCount limit) {
        name = cmdName;
        desc = cmdDesc;
        argumentLimit = limit;
    }

    public String getName() { return name; }

    public String getDescription() { return desc; }

    public boolean checkArgs(String[] args) {
        if (argumentLimit == ArgumentCount.INFINITE || argumentLimit.argCount() == args.length) {
            return true;
        } 

        return false;
    }

    public abstract void runCommand(String... args);
}
