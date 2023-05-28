package zork.commands;

import java.util.Scanner;
import zork.Constants.ArgumentCount;
import zork.proto.Command;
import zork.proto.Item;
import zork.Game;

public class Use extends Command {

    public Use() { super("Use" , ArgumentCount.INFINITE); }

    @Override
    public void runCommand(String... args) {
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
        

        else if(argsString.contains("key")){ 
            boolean found = false;
            for(Item item: Game.player.getInventory().getContents()) {
                if(item.getName().equalsIgnoreCase(argsString)){
                    System.out.println("You used the " + item.getName());
                    Game.player.getInventory().removeItem(item); // remove the item from the inventory
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("You don't have the " + argsString + " in your inventory");
            }
        }
    }
}