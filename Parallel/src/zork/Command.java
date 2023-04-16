package zork;

public class Command {
    private String name;
    
    /**
    * Create a command obsject. First and second word must be supplied, but either
    * one (or both) can be null. The command word should be null to indicate that
    * this was a command that is not recognised by this game.
    */
    
    public Command(String name) {
        this.name = name;
    }

    public Command() {}
    
    public void setCommand(String name) {
        this.name = name;
    }

    public String getCommand() {
        return name;
    }

    /**
     * I liked how Cameron's code was set up so I took some inspiration on how
     * he did his commands. no spaghetti code!!!!!
     * @param args
     */
    public void runCommand(String[] args) {
        System.out.println("Invalid command: " + name);
    }
}
