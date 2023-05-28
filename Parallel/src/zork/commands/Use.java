package zork.commands;

import java.util.Scanner;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;

public class Use extends Command {

    public Use(String cmdName, ArgumentCount limit) { super("Use" , ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {
        // TODO Auto-generated method stub
        String argsString = Item.arrayToString(args);

        if(argsString.equalsIgnoreCase("gun")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do with the gun? Type 'reload', 'shoot', or 'throw'.");
            String gunCommand = scanner.nextLine();

            if(gunCommand.equalsIgnoreCase("reload")){
                System.out.println("You reload the gun.");
                //Bullets++; there is no counter
            }
            else if(gunCommand.equalsIgnoreCase("shoot")){
                System.out.println("You shoot the gun.");
                //Bullet--; there is no counter
            }
            else if(gunCommand.equalsIgnoreCase("throw")){
                System.out.println("You throw the gun.");
                //Gun--; there is no gun yet 
            }
            else {
                System.out.println("Invalid command for gun.");
            }
        }
        
        else if(argsString.equalsIgnoreCase("key")){
            System.out.println("Command key executed successfully!");
        }
        else {
            throw new UnsupportedOperationException("Unimplemented method 'runCommand'");
        }
    }
}