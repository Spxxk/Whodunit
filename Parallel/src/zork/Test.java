package zork;


public class Test {
    public static void main(String[] args) {
        CommandLoader.init();
        
        CommandContext context = new CommandContext("Omch", new String[]{"ooo ooo aaa aaa"});


        context.runCommand("slimch");
    }
}
