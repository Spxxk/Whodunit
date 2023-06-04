package zork.proto;

public class Character {
    String id, name, description, dialogue;

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
        return dialogue;
    }
}
