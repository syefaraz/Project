package ca.sheridancollege.project;

public class Card {

    private String suit;
    private String cardNum;
    private boolean isHidden;

    public Card(String suit, String cardNum) {
        this.suit = suit;
        this.cardNum = cardNum;
        this.isHidden = false;
    }

    public String getSuit() {
        return suit;
    }

    public String getCardNum() {
        return cardNum;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    @Override
    public String toString() {
        if (isHidden) {
            return "Hidden Card";
        } else {
            return cardNum + " of " + suit;
        }
    }
}
