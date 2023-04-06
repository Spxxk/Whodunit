package zork.commands;
import java.util.Scanner;

import zork.data.Player;

public class Asker extends AttributesPresets {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String[] A2 = {"Intellect" , "Psyche" , "Physical" , "Motorics"};
        int totalPoints = 30;
        int max = 10;
        int min = 0;
        int[] Attributes = {0,0,0,0};
        Player F = new Player();
        for(int i = 0; i < 10; i++){
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
        F.PlayerAttribute[0] = Attributes[0];
        F.PlayerAttribute[1] = Attributes[1];
        F.PlayerAttribute[2] = Attributes[2];
        F.PlayerAttribute[3] = Attributes[3];
    }
}

