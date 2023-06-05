package zork.minigames;

import java.util.*;

import zork.Game;
import zork.utils.PokerUtil.Card;
import zork.utils.PokerUtil.Deck;
import zork.utils.PokerUtil.Player;
import zork.proto.Minigame;

public class Poker extends Minigame {
    private Player user;
    private List<Player> npcs;
    private Deck deck;
    private int pot;
    private int currentBet;
    private int roundCount;
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
        this.currentBet = 0;
        this.roundCount = 0;
    }

    public void startGame(String... args) {
        Game.print("WELCOME TO CAGA's POKER DUNGEON");
        Game.print("Welcome! You are about to play a classic game of poker.");
        Game.print("Here are some instructions to get you started:");
        Game.print("\n1. You will start the game with the $250 from the wallet you found.");
        Game.print("2. You will be playing against 3 opponents.");
        Game.print("3. Each round begins with you and the opponents being dealt 2 cards from a shuffled deck.");
        Game.print("4. In each betting round, you can choose to 'bet', 'raise', or 'call'.");
        Game.print("5. The game continues until you lose all your money or reach $800");
        Game.print("\nIf you succumb to CAGASUGE you will be eaten and die a painful death");
        Game.print("\nCAGASUGE IS GETTING READY ITS TIME TO FACE THE BIGGEST ONE OF THEM ALL!...");

        try {
            Thread.sleep(2000); // Delay before the game starts
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            playRound();
            Game.print("Would you like to play again? (yes/no)");
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
}




