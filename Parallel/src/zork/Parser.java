package zork;

import java.util.Scanner;
import zork.exceptions.CommandNotFoundException;

public class Parser {
    private String[] args;
    private Scanner in;
    
    public Parser() {
        in = new Scanner(System.in);
    }
    
    public Command getCommand() throws CommandNotFoundException {
        String inputLine = "";
        String[] words;
        Command com = new Command();
        
        System.out.print("> "); // print prompt
        
        inputLine = in.nextLine();
        
        words = inputLine.split(" ");
        
        if(!CommandWords.checkWord(words[0]))
            throw new CommandNotFoundException(words[0]);

        com.setCommand(words[0]);
        args = words;

        return com;
    }

    public String[] getArguments() {
        return args;
    }
}