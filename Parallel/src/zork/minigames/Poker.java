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
    private List<Card> communityCards;
    private int pot;
    private int currentBet;
    private int roundCount;
    private Scanner scanner = new Scanner(System.in);

    public Poker() {
        super("Poker");

        this.deck = new Deck();
        this.user = new Player("User", 250);
        this.npcs = new ArrayList<>();
        this.communityCards = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            this.npcs.add(new Player("NPC" + i, 250));
        }
        this.pot = 0;
        this.currentBet = 0;
        this.roundCount = 0;
    }

    public void startGame(String... args) {
        Game.print("Brent: Finally you made it here");
        Game.print("Brent: If you can be me and my henchmen I will turn myself in for killing Glenn");
        Game.print("Brent: But if you lose... well... you don't what to find out");
        Game.print("\nHere are some instructions to get you started:");
        Game.print("1. You will start the game with the $250 from the wallet you found.");
        Game.print("2. You will be playing against 3 opponents.");
        Game.print("3. The game begins with you and the opponents being dealt 2 cards from a shuffled deck.");
        Game.print("4. In each betting round, you can choose to 'bet', 'raise', or 'call'.");
        Game.print("5. Brent has made it so you cannot check to make the game harder");
        Game.print("6. The flop or the cards on the table are first presented after the first betting round.");
        Game.print("7. After each betting round one card is added to the community pile.");
        Game.print("8. Then when there are 5 cards in the pile there will be one last betting round.");
        Game.print("9. The game continues until you lose all your money or reach $800");
        Game.print("\nIf you succumb to Brent you will...");
        Game.print("\nBRENT IS GETTING READY ITS TIME TO FACE THE BIGGEST ONE OF THEM ALL!...");

        try {
            Thread.sleep(2000); // Delay before the game starts
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            if (user.getBank() >= 800) {
                Game.print("Congratulations! You won the game with $" + user.getBank() + " in your bank.");
                break;
            } else if (user.getBank() <= 0) {
                Game.print("You lost all your money. Better luck next time!");
                break;
            } else {
                playRound();
            }
        }
    }

    private static final String ANSI_RESET = "\u001B[0m"; //changeign the color for player vs npc
    private static final String ANSI_GREEN = "\u001B[32m";
    public void playRound() {
        
        this.deck = new Deck();
        this.deck.shuffle();
        this.communityCards.clear();
    
        for (int i = 0; i < 2; i++) {
            this.user.addCard(this.deck.dealCard());
            for (Player npc : npcs) {
                npc.addCard(this.deck.dealCard());
            }
        }
    
        System.out.println("Your hand: " + ANSI_GREEN + this.user.getHand() + ANSI_RESET);
        System.out.println("Your bank: $" + ANSI_GREEN + this.user.getBank() + ANSI_RESET);
    
    
        for (Player npc : npcs) {
            System.out.println(npc.getName() + "'s hand: " + npc.getHand());
            System.out.println(npc.getName() + "'s bank: $" + npc.getBank());
        }
    
        npcs.get(0).bet(5);
        npcs.get(1).bet(10);
        this.pot += 15;
        this.currentBet = 10;
    
        System.out.println(npcs.get(0).getName() + " posted the small blind of $5. Now has $" + npcs.get(0).getBank());
        System.out.println(npcs.get(1).getName() + " posted the big blind of $10. Now has $" + npcs.get(1).getBank());
    
        roundCount++;
    
        while (roundCount <= 4) {
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

            roundCount++;

            if (roundCount == 2) {
                dealFlop();  // Dealing the Flop (3 cards) in the poker I played with OMCH we were given 3 flop cards then 2 more community cards later
            } else if (roundCount == 3 || roundCount == 4) {
                dealCommunityCard();  // Dealing the Turn (1 card) and the River (1 card)
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
            this.communityCards.add(this.deck.dealCard());
        }
        System.out.println("Flop: " + this.communityCards);
    }
    
    private void dealCommunityCard() {
        System.out.println("Dealing a community card...");
        this.communityCards.add(this.deck.dealCard());
        System.out.println("Community cards: " + this.communityCards);
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

    //These are all like the things you can get in poker_______________________________________
    private boolean hasRoyalFlush(Player player) {
        List<Card> combinedCards = new ArrayList<>(player.getHand());
        combinedCards.addAll(communityCards);
        Collections.sort(combinedCards);
    
        for (int i = 0; i <= combinedCards.size() - 5; i++) {
            if (combinedCards.get(i).getRank() == 10 &&
                combinedCards.get(i).getSuit() == combinedCards.get(i + 1).getSuit() &&
                combinedCards.get(i + 1).getRank() == 11 &&
                combinedCards.get(i + 1).getSuit() == combinedCards.get(i + 2).getSuit() &&
                combinedCards.get(i + 2).getRank() == 12 &&
                combinedCards.get(i + 2).getSuit() == combinedCards.get(i + 3).getSuit() &&
                combinedCards.get(i + 3).getRank() == 13 &&
                combinedCards.get(i + 3).getSuit() == combinedCards.get(i + 4).getSuit() &&
                combinedCards.get(i + 4).getRank() == 14) {
                return true;
            }
        }
    
        return false;
    }


    private boolean hasStraightFlush(Player player) {
        List<Card> combinedCards = new ArrayList<>(player.getHand());
        combinedCards.addAll(communityCards);
        combinedCards.sort(Comparator.comparing(Card::getRank));
    
        for (int i = 0; i <= combinedCards.size() - 5; i++) {
            if (isSameSuit(combinedCards.subList(i, i + 5)) && isSequential(combinedCards.subList(i, i + 5))) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isSameSuit(List<Card> cards) {
        String suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isSequential(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getRank() + 1 != cards.get(i + 1).getRank()) {
                return false;
            }
        }
        return true;
    }

    private boolean hasFourOfAKind(Player player) {
        List<Card> combinedCards = new ArrayList<>(player.getHand());
        combinedCards.addAll(communityCards);
    
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Card card : combinedCards) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
        }
    
        for (Integer count : rankCounts.values()) {
            if (count == 4) {
                return true;
            }
        }
    
        return false;
    }

    private boolean hasFullHouse(Player player) {
        List<Card> combinedCards = new ArrayList<>(player.getHand());
        combinedCards.addAll(communityCards);
    
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Card card : combinedCards) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
        }
    
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
    
        for (Integer count : rankCounts.values()) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }
    
        return hasThreeOfAKind && hasPair;
    }
    
    private boolean hasFlush(Player player) {
        List<Card> combinedCards = new ArrayList<>(player.getHand());
        combinedCards.addAll(communityCards);
    
        Map<String, Integer> suitCounts = new HashMap<>();
        for (Card card : combinedCards) {
            suitCounts.put(card.getSuit(), suitCounts.getOrDefault(card.getSuit(), 0) + 1);
        }
    
        for (Integer count : suitCounts.values()) {
            if (count >= 5) {
                return true;
            }
        }
    
        return false;
    }

    private boolean hasStraight(Player player) {
        List<Card> combinedCards = new ArrayList<>(player.getHand());
        combinedCards.addAll(communityCards);
        Collections.sort(combinedCards);
    
        int currentStreak = 1;
        for (int i = 0; i < combinedCards.size() - 1; i++) {
            if (combinedCards.get(i).getRank() + 1 == combinedCards.get(i + 1).getRank()) {
                currentStreak++;
                if (currentStreak == 5) {
                    return true;
                }
            } else if (combinedCards.get(i).getRank() != combinedCards.get(i + 1).getRank()) {
                currentStreak = 1;
            }
        }
        return false;
    }

    private boolean hasThreeOfAKind(Player player) {
        List<Card> combinedCards = new ArrayList<>(player.getHand());
        combinedCards.addAll(communityCards);
    
        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (Card card : combinedCards) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
        }
    
        return rankCounts.values().stream().anyMatch(count -> count == 3);
    }

    private boolean hasTwoPair(Player player) {
        List<Card> combinedCards = new ArrayList<>(player.getHand());
        combinedCards.addAll(communityCards);
        
        int pairCount = 0;
        List<Integer> pairedRanks = new ArrayList<>();
    
        for (Card card : combinedCards) {
            int count = 0;
            if (pairedRanks.contains(card.getRank())) {
                continue;
            }
            for (Card otherCard : combinedCards) {
                if (card.getRank() == otherCard.getRank()) {
                    count++;
                }
            }
            if (count == 2) {
                pairCount++;
                pairedRanks.add(card.getRank());
            }
        }
        return pairCount >= 2;
    }

    private boolean hasPair(Player player) {
        Map<Integer, Integer> cardCounts = new HashMap<>();
        for (Card card : player.getHand()) {
            cardCounts.put(card.getRank(), cardCounts.getOrDefault(card.getRank(), 0) + 1);
        }
        for (int count : cardCounts.values()) {
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }

    private Player getHighestCardWinner() {
        Player highestCardPlayer = user;
        Card highestCard = user.getHighestCard();
    
        for (Player npc : npcs) {
            Card npcHighestCard = npc.getHighestCard();
            if (npcHighestCard.compareTo(highestCard) > 0) {
                highestCardPlayer = npc;
                highestCard = npcHighestCard;
            }
        }
    
        return highestCardPlayer;
    }
    
    
    
    //_________________________________________

    private List<Player> getAllPlayers() {
        List<Player> allPlayers = new ArrayList<>();
        allPlayers.add(user);
        allPlayers.addAll(npcs);
        return allPlayers;
    }
    
    
    private Player determineWinner() {
        // Start by checking if any player has a Royal Flush
        for (Player player : getAllPlayers()) {
            if (hasRoyalFlush(player)) {
                System.out.println(player.getName() + " has a Royal Flush!");
                return player;  // The player with the Royal Flush wins
            }
        }
    
        // Check if any player has a Straight Flush
        for (Player player : getAllPlayers()) {
            if (hasStraightFlush(player)) {
                System.out.println(player.getName() + " has a Straight Flush!");
                return player;  // The player with the Straight Flush wins
            }
        }
    
        // Check if any player has a Four of a Kind
        for (Player player : getAllPlayers()) {
            if (hasFourOfAKind(player)) {
                System.out.println(player.getName() + " has a Four of a Kind!");
                return player;  // The player with the Four of a Kind wins
            }
        }
    
        // Check if any player has a Full House
        for (Player player : getAllPlayers()) {
            if (hasFullHouse(player)) {
                System.out.println(player.getName() + " has a Full House!");
                return player;  // The player with the Full House wins
            }
        }
    
        // Check if any player has a Flush
        for (Player player : getAllPlayers()) {
            if (hasFlush(player)) {
                System.out.println(player.getName() + " has a Flush!");
                return player;  // The player with the Flush wins
            }
        }
    
        // Check if any player has a Straight
        for (Player player : getAllPlayers()) {
            if (hasStraight(player)) {
                System.out.println(player.getName() + " has a Straight!");
                return player;  // The player with the Straight wins
            }
        }
    
        // Check if any player has Three of a Kind
        for (Player player : getAllPlayers()) {
            if (hasThreeOfAKind(player)) {
                System.out.println(player.getName() + " has Three of a Kind!");
                return player;  // The player with Three of a Kind wins
            }
        }
    
        // Check if any player has Two Pair
        for (Player player : getAllPlayers()) {
            if (hasTwoPair(player)) {
                System.out.println(player.getName() + " has Two Pair!");
                return player;  // The player with Two Pair wins
            }
        }
    
        // Check if any player has a Pair
        for (Player player : getAllPlayers()) {
            if (hasPair(player)) {
                System.out.println(player.getName() + " has a Pair!");
                return player;  // The player with a Pair wins
            }
        }
    
        // If no player has any of the above hands then the person itht he highest card wins
        return getHighestCardWinner();
    }
}    