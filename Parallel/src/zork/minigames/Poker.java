package zork.minigames;

import java.util.*;

public class Poker {
    private Player user;
    private List<Player> npcs;
    private Deck deck;
    private int pot;
    private Scanner scanner = new Scanner(System.in);

    public Poker() {
        this.deck = new Deck();
        this.user = new Player("User", 250);
        this.npcs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            this.npcs.add(new Player("NPC" + i, 250));
        }
        this.pot = 0;
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

        for (Player npc : npcs) {
            System.out.println(npc.getName() + "'s hand: " + String.join(", ", Collections.nCopies(2, "-----")));
        }

        npcs.get(0).bet(5);
        npcs.get(1).bet(10);
        pot += 15;

        System.out.println(npcs.get(0).getName() + " posted the small blind of $5.");
        System.out.println(npcs.get(1).getName() + " posted the big blind of $10.");

        System.out.println("Would you like to 'bet', 'call', or 'raise'? ");
        String decision = scanner.nextLine().toLowerCase();

        int betAmount;
        switch(decision) {
            case "bet":
                betAmount = getPlayerBet();
                this.user.bet(betAmount);
                this.pot += betAmount;
                System.out.println("You bet $" + betAmount + ".");
                break;
            case "raise":
                betAmount = getPlayerBet();
                this.user.bet(this.pot + betAmount);
                this.pot += this.pot + betAmount;
                System.out.println("You raised $" + betAmount + ".");
                break;
            case "call":
                this.user.bet(this.pot);
                System.out.println("You called.");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // New NPC betting strategy
        Iterator<Player> it = npcs.iterator();
        while (it.hasNext()) {
            Player npc = it.next();
            if (npc.shouldBet()) {
                npc.bet(this.pot);
                System.out.println(npc.getName() + " bet $" + this.pot + ".");
            } else {
                System.out.println(npc.getName() + " folded.");
                it.remove();
            }
        }

        Player winner = determineWinner();

        winner.win(this.pot);

        for (Player npc : npcs) {
            System.out.println(npc.getName() + "'s hand was: " + npc.getHand());
        }
        System.out.println(winner.getName() + " wins the round and now has " + winner.getBank() + "!");
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

    public static void main(String[] args) {
        Poker poker = new Poker();
        while (true) {
            poker.playRound();
            System.out.println("Would you like to play again? (yes/no)");
            String playAgain = poker.scanner.nextLine().toLowerCase();
            if (!"yes".equals(playAgain)) {
                break;
            }
        }
    }
}

class Card implements Comparable<Card> {
    private String suit;
    private int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.rank, other.rank);
    }

    @Override
    public String toString() {
        String rankString;
        switch(rank) {
            case 1:
                rankString = "Ace";
                break;
            case 11:
                rankString = "Jack";
                break;
            case 12:
                rankString = "Queen";
                break;
            case 13:
                rankString = "King";
                break;
            default:
                rankString = String.valueOf(rank);
        }
        return rankString + " of " + suit;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                this.cards.add(new Card(suit, i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card dealCard() {
        return this.cards.remove(0);
    }
}

class Player {
    private String name;
    private List<Card> hand;
    private int bank;

    public Player(String name, int bank) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public Card getHighestCard() {
        return Collections.max(this.hand);
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public int getBank() {
        return this.bank;
    }

    public void bet(int amount) {
        this.bank -= amount;
    }

    public void win(int amount) {
        this.bank += amount;
    }

    // New method
    public boolean shouldBet() {
        // Here we'll assume that if the rank of the highest card is 8 or more, the NPC will bet
        return getHighestCard().getRank() >= 8;
    }
}
