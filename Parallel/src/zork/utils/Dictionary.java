package zork.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    
    private static Set<String> words;

    public static void initDictionary() throws IOException {
		Path path = Path.of("src\\zork\\data\\words.txt");
		String dictionary = Files.readString(path);

        words = new HashSet<String>(Arrays.asList(dictionary.split("\\R")));
    }

    public static boolean exists(String word) {
        return words.contains(word);
    }
}
