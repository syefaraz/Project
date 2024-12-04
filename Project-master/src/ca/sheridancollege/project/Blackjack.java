package ca.sheridancollege.project;

import java.util.Scanner;

public class Blackjack {

    private GroupOfCards deck;
    private Player dealer;
    private Player player;

    public Blackjack() {
        deck = new GroupOfCards(52);
        dealer = new Player("Dealer");
        player = new Player("Player");
    }

    public void play() {
        deck.shuffle();
        dealCards();

        Scanner scanner = new Scanner(System.in);

        while (playerHit(scanner)) {
            player.addHand(deck.dealCard());
            if (pBust()) {
                System.out.println("Player busts! Dealer wins (Player: " + player.handValue() + ", Dealer: " + dealer.handValue() + ")");
                return;
            }
        }

        while (dealerHit()) {
            dealer.addHand(deck.dealCard());
            if (dBust()) {
                System.out.println("Dealer busts! Player wins (Player: " + player.handValue() + ", Dealer: " + dealer.handValue() + ")");
                return;
            }
        }

        determineWinner();
        scanner.close();
    }

    private void dealCards() {
        // Deal two cards to the player
        player.addHand(deck.dealCard());
        player.addHand(deck.dealCard());

        // Deal two cards to the dealer (one hidden)
        dealer.addHand(deck.dealCard());
        Card hiddenCard = deck.dealCard();
        hiddenCard.setHidden(true);
    }

    private boolean playerHit(Scanner scanner) {
        System.out.println("Your hand: " + player.getHand() + " Value: " + player.handValue());
        System.out.println("Dealer hand: " + dealer.getHand() + " Value: " + dealer.handValue());
        System.out.println("Hit or stand? (h/s)");
        String choice = scanner.nextLine().toLowerCase();
        return choice.equals("h");
    }

    private boolean pBust() {
        return player.handValue() > 21;
    }

    private boolean dealerHit() {
        return dealer.handValue() < 17;
    }

    private boolean dBust() {
        return dealer.handValue() > 21;
    }

    private void determineWinner() {
        int pValue = player.handValue();
        int dValue = dealer.handValue();

        System.out.println("Player's hand: " + player.getHand() + ", Value: " + pValue);
        System.out.println("Dealer's hand: " + dealer.getHand() + ", Value: " + dValue);

        if (pValue > 21) {
            System.out.println("Player busts! Dealer wins (Player: " + pValue + ", Dealer: " + dValue + ")");
        } else if (dValue > 21) {
            System.out.println("Dealer busts! Player wins (Player: " + pValue + ", Dealer: " + dValue + ")");
        } else if (pValue == 21 && dValue != 21) {
            System.out.println("Player got Blackjack! Player wins (Player: " + pValue + ", Dealer: " + dValue + ")");
        } else if (dValue == 21 && pValue != 21) {
            System.out.println("Dealer got Blackjack! Dealer wins (Player: " + pValue + ", Dealer: " + dValue + ")");
        } else if (pValue > dValue) {
            System.out.println("Player wins (Player: " + pValue + ", Dealer: " + dValue + ")");
        } else if (pValue < dValue) {
            System.out.println("Dealer wins (Player: " + pValue + ", Dealer: " + dValue + ")");
        } else {
            System.out.println("Tie Game! (Player: " + pValue + ", Dealer: " + dValue + ")");
        }
    }
}
