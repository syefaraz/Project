package ca.sheridancollege.project;

import java.util.List;

public abstract class PlayerHand extends Player {

    public PlayerHand(String name) {
        super(name);
    }

    public int handValue() {
        int value = 0;
        int numAces = 0;
        List<Card> hand = getHand();

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
