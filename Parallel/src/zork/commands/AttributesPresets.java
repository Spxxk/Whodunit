package zork.commands;

import java.net.Inet4Address;

public class AttributesPresets {
    public static void main(String[] args) {
        final int SkillPoints = 12;
        int Intellect;
        int Psyche;
        int Physique;
        int Motorics;
    }
    public static void Thinker(int Intellect, int Psyche, int Physique, int Motorics){
        Intellect = 5;
        Psyche = 1;
        Physique = 2;
        Motorics = 4;
    }
    public static void Sensitive(int Intellect, int Psyche, int Physique, int Motorics){
        Intellect = 1;
        Psyche = 5;
        Physique = 4;
        Motorics = 2;
    }
    public static void Physical(int Intellect, int Psyche, int Physique, int Motorics){
        Intellect = 1;
        Psyche = 2;
        Physique = 5;
        Motorics = 4;
    }
}
