package zork.Utils;

import java.util.*;

import zork.Proto.Command;
import zork.exceptions.CommandNotFoundException;

import java.io.*;
import java.net.URL;

public class CommandLoader {
    private static Map<String, Command> commands = new HashMap<>();

    public static void init() {
        try {
            Class<?>[] classes = getClasses("zork.commands");

            for (Class<?> c : classes) {
                commands.put(c.getSimpleName().toLowerCase(), (Command) c.getConstructors()[0].newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    public static Command getCommand(String n) throws CommandNotFoundException {
        Command c = commands.get(n.toLowerCase());

        if (c == null) 
            throw new CommandNotFoundException(n);

        return c;
    }

    public static Class<?>[] getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }


    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

}
