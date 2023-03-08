package zork.commands;

import zork.*;

public class AttributesPresets { // why are we passing stuff in? i dont understand
    public final int SKILL_POINTS = 12;
    private int[] stats = new int[4]; 
    // putting all of the values into this one array
    // { intellect, psyche, physique, motorics }
    // intellect is index 0, psyche is index 1, physique is index 2, motorics is index 3

    public void Thinker(){
        stats[0] = 5;
        stats[1] = 1;
        stats[2] = 2;
        stats[3] = 4;
    }
    public void Sensitive(){
        stats[0] = 1;
        stats[1] = 5;
        stats[2] = 4;
        stats[3] = 2;
    }
    public void Physical(){
        stats[0] = 1;
        stats[1] = 2;
        stats[2] = 5;
        stats[3] = 4;
    }
}
