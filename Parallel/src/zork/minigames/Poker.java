package zork.minigames;

import java.util.*;

import zork.utils.PokerUtil.Card;
import zork.utils.PokerUtil.Deck;
import zork.utils.PokerUtil.Player;
import zork.proto.Minigame;

public class Poker extends Minigame {
    private Player user;
    private List<Player> npcs;
    private Deck deck;
    private int pot;
    private Scanner scanner = new Scanner(System.in);

    public Poker() {
        super("Poker", (int) 1e9);

        this.deck = new Deck();
        this.user = new Player("User", 250);
        this.npcs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            this.npcs.add(new Player("NPC" + i, 250));
        }
        this.pot = 0;
    }

    public void startGame(String... args) {
        while (true) {
            playRound();
            System.out.println("Would you like to play again? (yes/no)");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!"yes".equals(playAgain)) {
                break;
            }
        }
    }

    public void playRound() {
        this.deck = new Deck();
        this.deck.shuffle();

        for (int i = 0; i < 2; i++) {
            this.user.addCard(this.deck.dealCard());
            for (Player npc : npcs) {
                npc.addCard(this.deck.dealCard());
            }
        }

        System.out.println("Your hand: " + this.user.getHand());
        System.out.println("Your bank: " + this.user.getBank());

        for (Player npc : npcs) {
            System.out.println(npc.getName() + "'s hand: " + String.join(", ", Collections.nCopies(2, "-----")));
            System.out.println(npc.getName() + "'s bank: " + npc.getBank());
        }

        npcs.get(0).bet(5);
        npcs.get(1).bet(10);
        pot += 15;

        System.out.println(npcs.get(0).getName() + " posted the small blind of $5. Now has $" + npcs.get(0).getBank());
        System.out.println(npcs.get(1).getName() + " posted the big blind of $10. Now has $" + npcs.get(1).getBank());

        System.out.println("Would you like to 'bet', 'call', or 'raise'? ");
        String decision = scanner.nextLine().toLowerCase();

        int betAmount;
        switch(decision) {
            case "bet":
                betAmount = getPlayerBet();
                this.user.bet(betAmount);
                this.pot += betAmount;
                System.out.println("You bet $" + betAmount + ". Now you have $" + this.user.getBank());
                break;
            case "raise":
                betAmount = getPlayerBet();
                this.user.bet(this.pot + betAmount);
                this.pot += this.pot + betAmount;
                System.out.println("You raised $" + betAmount + ". Now you have $" + this.user.getBank());
                break;
            case "call":
                this.user.bet(this.pot);
                System.out.println("You called. Now you have $" + this.user.getBank());
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        Iterator<Player> it = npcs.iterator();
        while (it.hasNext()) {
            Player npc = it.next();
            if (npc.shouldBet()) {
                npc.bet(this.pot);
                System.out.println(npc.getName() + " bet $" + this.pot + ". Now has $" + npc.getBank());
            } else {
                System.out.println(npc.getName() + " folded. Now has $" + npc.getBank());
                it.remove();
            }
        }

        Player winner = determineWinner();

        winner.win(this.pot);
        System.out.println(winner.getName() + " wins the pot of $" + this.pot + ". Now has $" + winner.getBank());

        for (Player npc : npcs) {
            System.out.println(npc.getName() + "'s hand was: " + npc.getHand());
        }
        System.out.println(winner.getName() + " wins the round!");
    }

    private int getPlayerBet() {
        System.out.println("How much would you like to bet?");
        while (true) {
            try {
                int bet = Integer.parseInt(scanner.nextLine());
                if (bet <= this.user.getBank()) {
                    return bet;
                } else {
                    System.out.println("You can't bet more than you have. Your bank: " + this.user.getBank());
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid bet.");
            }
        }
    }

    private Player determineWinner() {
        Card highestCardUser = user.getHighestCard();
        Player winner = user;
        for (Player npc : npcs) {
            Card highestCardNPC = npc.getHighestCard();
            if (highestCardNPC.getRank() > highestCardUser.getRank()) {
                highestCardUser = highestCardNPC;
                winner = npc;
            }
        }
        return winner;
    }
}




