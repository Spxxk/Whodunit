package zork;

import java.util.Scanner;
import zork.exceptions.CommandNotFoundException;

public class Parser {
    private String[] args;
    private Scanner in;
    
    public Parser() {
        in = new Scanner(System.in);
    }
    
    public String getCommand() throws CommandNotFoundException {
        String inputLine = "";
        String[] words;
        String c = new String();
        
        System.out.print("> "); // print prompt
        
        inputLine = in.nextLine();
        
        words = inputLine.split(" ");
        
        if(!CommandWords.checkWord(words[0]))
            throw new CommandNotFoundException(words[0]);

        c = words[0];
        args = words;

        return c;
    }

    public String[] getArguments() {
        return args;
    }
}