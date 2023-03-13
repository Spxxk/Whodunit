package zork.commands;
import java.util.Scanner;

public class Asker extends AttributesPresets {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String[] A2 = {"Intellect" , "Psyche" , "Physical" , "Motorics"};
        int totalPoints = 8;
        int max = 4;
        int min = 0;
        int[] Attributes = {1,1,1,1};
        for(int i = 0; i < 4; i++){
            System.out.println("You have " + totalPoints + " points left, please choose how many points allocated to " + A2[i] + "!");
            int number = myObj.nextInt();
            while(number<min || number > max || totalPoints-number < 0){
                System.out.println("Out of Range! | or | No more points! Please re-enter");
                number = myObj.nextInt();
            }
            totalPoints = totalPoints-number;
            Attributes[i] += number;
        }
        System.out.println("INT = " + Attributes[0]);
        System.out.println("PSY = " + Attributes[1]);
        System.out.println("FYS = " + Attributes[2]);
        System.out.println("MOT = " + Attributes[3]);
    }
}

