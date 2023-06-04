package zork.commands;

import zork.Constants.ArgumentCount;
import zork.proto.Command;

public class Omch extends Command {

    public Omch() { super("Omch", "OMCH!", ArgumentCount.ONE); }

    public void runCommand(String... args) {
        System.out.printf("Hi I'm a %s and my name is Omch!\n", args[0]);
    }

}
