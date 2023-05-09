package zork.utils;

import java.util.Arrays;
import java.util.Scanner;
import zork.exceptions.CommandNotFoundException;

public class Parser {
    private static Scanner in = new Scanner(System.in);

    public static CommandContext getCommand() throws CommandNotFoundException {
        String inputLine, words[];

        System.out.print("> "); // print prompt
        
        inputLine = in.nextLine();
        words = inputLine.split(" ");

        return new CommandContext(words[0], Arrays.copyOfRange(words, 1, words.length));
    }
}