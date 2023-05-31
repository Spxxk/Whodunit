package zork.minigames;

import java.util.*;

public class Poker {
    private List<Card> deck;

    public class Card {
        private String suit;
        private int rank;

        public Card(String suit, int rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public String getSuit() {
            return suit;
        }

        public int getRank() {
            return rank;
        }

        @Override
        public String toString() {
            String rankStr;
            switch (this.rank) {
                case 1:
                    rankStr = "Ace";
                    break;
                case 11:
                    rankStr = "Jack";
                    break;
                case 12:
                    rankStr = "Queen";
                    break;
                case 13:
                    rankStr = "King";
                    break;
                default:
                    rankStr = String.valueOf(this.rank);
            }
            return rankStr + " of " + this.suit;
        }
    }

    public Poker() {
        this.deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for(String suit : suits) {
            for(int i=1; i<=13; i++) {
                this.deck.add(new Card(suit, i));
            }
        }
        Collections.shuffle(this.deck);
    }

    public Card dealCard() {
        return this.deck.remove(this.deck.size() - 1);
    }

    public static void main(String[] args) {
        Poker game = new Poker();

        Card player1Card = game.dealCard();
        Card player2Card = game.dealCard();

        System.out.println("Player 1: " + player1Card);
        System.out.println("Player 2: " + player2Card);

        if(player1Card.getRank() > player2Card.getRank()) {
            System.out.println("Player 1 wins with a " + player1Card);
        } else if(player1Card.getRank() < player2Card.getRank()) {
            System.out.println("Player 2 wins with a " + player2Card);
        } else {
            System.out.println("It's a draw!");
        }
    }
}
