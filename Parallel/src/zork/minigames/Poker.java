package zork.minigames;
import java.util.*;

public class Poker {
    private Player user;
    private List<Player> npcs;
    private Deck deck;
    private int pot;
    private int currentBet;
    private int roundCount;
    private Scanner scanner = new Scanner(System.in);

    public Poker() {
        this.deck = new Deck();
        this.user = new Player("User", 250);
        this.npcs = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            this.npcs.add(new Player("NPC" + i, 250));
        }
        this.pot = 0;
        this.currentBet = 0;
        this.roundCount = 0;
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
        System.out.println("Your bank: $" + this.user.getBank());

        for (Player npc : npcs) {
            System.out.println(npc.getName() + "'s hand: " + String.join(", ", Collections.nCopies(2, "-----")));
            System.out.println(npc.getName() + "'s bank: $" + npc.getBank());
        }

        npcs.get(0).bet(5);
        npcs.get(1).bet(10);
        this.pot += 15;
        this.currentBet = 10;

        System.out.println(npcs.get(0).getName() + " posted the small blind of $5. Now has $" + npcs.get(0).getBank());
        System.out.println(npcs.get(1).getName() + " posted the big blind of $10. Now has $" + npcs.get(1).getBank());

        roundCount++;

        if (roundCount == 1) {
            dealFlop();
        } else {
            dealAdditionalCards();
        }

        while (true) {
            System.out.println("Would you like to 'bet', 'call', or 'raise'? ");
            String decision = scanner.nextLine().toLowerCase();

            int betAmount;
            switch (decision) {
                case "bet":
                    betAmount = getPlayerBet();
                    if (betAmount > this.user.getBank()) {
                        System.out.println("You don't have enough money to bet $" + betAmount + ".");
                        continue;
                    }
                    this.user.bet(betAmount);
                    this.pot += betAmount;
                    this.currentBet = betAmount;
                    System.out.println("You bet $" + betAmount + ". Now you have $" + this.user.getBank());
                    break;
                case "raise":
                    betAmount = getPlayerBet();
                    int totalAmount = this.currentBet + betAmount;
                    if (totalAmount > this.user.getBank()) {
                        System.out.println("You don't have enough money to raise to $" + totalAmount + ".");
                        continue;
                    }
                    this.user.bet(totalAmount);
                    this.pot += totalAmount;
                    this.currentBet = totalAmount;
                    System.out.println("You raised to $" + totalAmount + ". Now you have $" + this.user.getBank());
                    break;
                case "call":
                    int callAmount = this.currentBet;
                    if (callAmount > this.user.getBank()) {
                        System.out.println("You don't have enough money to call $" + callAmount + ".");
                        continue;
                    }
                    this.user.bet(callAmount);
                    this.pot += callAmount;
                    System.out.println("You called. Now you have $" + this.user.getBank());
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            for (Player npc : npcs) {
                try {
                    Thread.sleep(2000); // Delay between NPC moves
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int npcBetAmount = getRandomBetAmount(npc);
                if (npcBetAmount > npc.getBank()) {
                    npcBetAmount = npc.getBank();
                }
                npc.bet(npcBetAmount);
                this.pot += npcBetAmount;
                System.out.println(npc.getName() + " bet $" + npcBetAmount + ". Now has $" + npc.getBank());
            }

            if (roundCount == 1) {
                dealFlop();
            } else if (roundCount == 2) {
                dealTurn();
            } else if (roundCount == 3) {
                dealRiver();
            } else {
                break;
            }
        }

        Player winner = determineWinner();

        System.out.println(winner.getName() + " wins the round!");

        try {
            Thread.sleep(2000); // Delay before revealing hands
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Player npc : npcs) {
            try {
                Thread.sleep(2000); // Delay between revealing each NPC's hand
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(npc.getName() + "'s hand was: " + npc.getHand());
            System.out.println(npc.getName() + "'s bank: $" + npc.getBank());
        }

        try {
            Thread.sleep(2000); // Delay before displaying user's hand and bank
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Your hand: " + this.user.getHand());
        System.out.println("Your bank: $" + this.user.getBank());

        winner.win(this.pot);
        System.out.println(winner.getName() + " wins $" + this.pot + "! Now has $" + winner.getBank());

        this.pot = 0;
        this.currentBet = 0;
        this.roundCount = 0;
    }

    private void dealFlop() {
        System.out.println("Dealing flop...");
        for (int i = 0; i < 3; i++) {
            Card card = this.deck.dealCard();
            this.user.addCard(card);
            for (Player npc : npcs) {
                npc.addCard(card);
            }
        }
        System.out.println("Flop: " + this.user.getHand().subList(2, 5));
    }

    private void dealAdditionalCards() {
        Card card = this.deck.dealCard();
        this.user.addCard(card);
        for (Player npc : npcs) {
            npc.addCard(card);
        }
        System.out.println("Additional card: " + card);
    }

    private void dealTurn() {
        System.out.println("Dealing turn...");
        Card card = this.deck.dealCard();
        this.user.addCard(card);
        for (Player npc : npcs) {
            npc.addCard(card);
        }
        System.out.println("Turn: " + card);
    }

    private void dealRiver() {
        System.out.println("Dealing river...");
        Card card = this.deck.dealCard();
        this.user.addCard(card);
        for (Player npc : npcs) {
            npc.addCard(card);
        }
        System.out.println("River: " + card);
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

    private int getRandomBetAmount(Player player) {
        int maxBet = player.getBank() / 10 * 10;
        int minBet = 10;
        return minBet + (int) (Math.random() * ((maxBet - minBet) / 10 + 1)) * 10;
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

    public void playGame() {
        boolean playAgain = true;
        while (playAgain && (user.getBank() > 0 || !npcs.isEmpty())) {
            playRound();
            System.out.println("Would you like to play again? (yes/no)");
            String playAgainInput = scanner.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("yes");
            if (playAgain) {
                resetGame();
                System.out.println("Dealing in for the next round...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void resetGame() {
        this.deck = new Deck();
        this.user.reset();
        for (Player npc : npcs) {
            npc.reset();
        }
    }

    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.playGame();
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
        switch (rank) {
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

    public void reset() {
        this.hand.clear();
    }
}

