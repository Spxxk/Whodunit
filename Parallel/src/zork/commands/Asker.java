package zork.commands;
import java.util.Scanner; 

public class Asker extends AttributesPresets {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Add Points| INT | PSY | FYS | MOT");

    String userName = myObj.nextLine();  // Read user input
    System.out.println("Username is: " + Intellect + Psyche + Physical + Motorics);  // Output user input
    }
  }

