package zork.utils.PokerUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int bank, bet;

    public Player(String name, int bank) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.bank = bank;
        bet = 0;
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
        this.bet = amount;
        this.bank -= amount;
    }

    public int getBet() {
        return bet;
    }

    public void win(int amount) {
        this.bank += amount;
    }

    public boolean shouldBet() {
        return getHighestCard().getRank() >= 8;
    }
}
