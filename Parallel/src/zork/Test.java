package zork;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Game game = Game.getCurrentGame();
        game.play(true);
    }
}
