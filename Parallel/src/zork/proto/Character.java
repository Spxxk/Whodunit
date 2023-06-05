package zork.proto;

import zork.Game;

public class Character {
    String id, name, description, dialogue;
    boolean options;

    public Character(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDialogue(String d) {
        dialogue = d;
    }

    public String getDialogue() {
        for(int i = 0; i < dialogue.length() - 1; i++) {
            if(dialogue.substring(i, i + 2).equals("/p")) {
                dialogue = dialogue.substring(0, i) + Game.player.getPlayerName() + dialogue.substring(i + 2);
            }
        }
        return dialogue;
    }

    public void setOptions(boolean options) {
        this.options = options;
    } 

    public boolean hasOptions() {
        return options;
    }
}
