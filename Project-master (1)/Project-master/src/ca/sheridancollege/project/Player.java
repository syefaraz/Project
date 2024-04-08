package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void addHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int handValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : hand) {
            String cardNum = card.getCardNum();
            if (cardNum.equals("Ace")) {
                numAces++;
            } else if (cardNum.equals("Jack") || cardNum.equals("Queen") || cardNum.equals("King")) {
                value += 10;
            } else {
                value += Integer.parseInt(cardNum);
            }
        }

        for (int i = 0; i < numAces; i++) {
            if (value + 11 <= 21) {
                value += 11;
            } else {
                value += 1;
            }
        }

        return value;
    }
}
