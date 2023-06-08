package zork.commands;

import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.utils.CommandLoader;

public class Help extends Command{

    public Help() { super("Help", "Outputs helpful information", ArgumentCount.NONE); }

    @Override
    public void runCommand(String... args) {

        // Help!!
        
        System.out.println("Hi there, I see that you need a little bit of help. Here are some things you should know...");
        
        System.out.printf("-------------------------------------------------------------------%n");
        System.out.printf("|                        Available Commands                       |%n");
        System.out.printf("-------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-50s |%n", "NAME", "DESCRIPTION");
        System.out.printf("-------------------------------------------------------------------%n");        

        CommandLoader.getAllCommands().forEach((name, cmd) -> {
            System.out.printf("| %-10s | %-50s |%n", name, cmd.getDescription());
        });
        System.out.printf("-------------------------------------------------------------------%n");
        System.out.println("Hopefully, now you have a clue. Good luck! :)");
    }
}
