package zork.minigames;
import java.util.*;

public class Poker {
    private Player user;
    private Player npc;
    private Deck deck;
    private int pot;
    private Scanner scanner = new Scanner(System.in);

    public Poker() {
        this.deck = new Deck();
        this.user = new Player("User", 100);
        this.npc = new Player("NPC", 100);
        this.pot = 0;
    }

    public void playRound() {
        this.deck.shuffle();

        for (int i = 0; i < 5; i++) {
            this.user.addCard(this.deck.dealCard());
            this.npc.addCard(this.deck.dealCard());
        }

        System.out.println("Your hand: " + this.user.getHand());

        System.out.println("NPC's hand: " + String.join(", ", Collections.nCopies(5, "-----")));

        
        System.out.println("Would you like to 'bet', 'call', or 'raise'? ");
        String decision = scanner.nextLine().toLowerCase();

        if (decision.equals("bet")) {
            System.out.println("How much would you like to bet?");
            int bet = scanner.nextInt();
            this.user.bet(bet);
            this.pot += bet;
        } else if (decision.equals("raise")) {
            System.out.println("How much would you like to raise?");
            int raise = scanner.nextInt();
            this.user.bet(this.pot + raise);
            this.pot += this.pot + raise;
        } else if (decision.equals("call")) {
            this.user.bet(this.pot);
        }

        
        this.npc.bet(this.pot);

        
        Player winner = determineWinner();

        
        winner.win(this.pot);

        
        System.out.println("NPC's hand was: " + this.npc.getHand());
        System.out.println(winner.getName() + " wins the round and now has " + winner.getBank() + "!");
    }

    private Player determineWinner() {
        
        Card highestCardUser = user.getHighestCard();
        Card highestCardNPC = npc.getHighestCard();

        if (highestCardUser.getRank() > highestCardNPC.getRank()) {
            return user;
        } else {
            return npc;
        }
    }

    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.playRound();
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
}
