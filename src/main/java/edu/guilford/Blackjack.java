package edu.guilford;

/**
 * The Blackjack class represents a game of Blackjack.
 * It provides methods to reset the game, deal cards, and handle player and dealer turns.
 * @author Cheick Amadou
 * @version 1.0
 */
public class Blackjack {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;

    /**
     * Constructor to create a new game of Blackjack.
     * The game is reset upon initialization.
     */
    public Blackjack() {
        reset();
    }

    /**
     * Returns the player's hand.
     *
     * @return the player's hand
     */
    public Hand getPlayerHand() {
        return playerHand;
    }

    /**
     * Returns the dealer's hand.
     *
     * @return the dealer's hand
     */
    public Hand getDealerHand() {
        return dealerHand;
    }

    /**
     * Returns the deck of cards.
     *
     * @return the deck of cards
     */
    public Deck getDeck() {
        return deck;
    }

    // reset method isn't suppose to accept a boolean input, if you call reset() it should reset the deck and shuffle it without any input
    /* 
    public void reset(boolean newDeck) {
        if (newDeck) {
            deck = new Deck();
            deck.shuffle();
        }
    }
    */

    /**
     * Resets the game by creating a new deck and shuffling it.
     */
    public void reset() {
        deck = new Deck();
        deck.shuffle();
    }

    /**
     * Deals two cards to both the player and the dealer.
     */
    public void deal() {
        playerHand = new Hand();
        dealerHand = new Hand();
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
    }

    /**
     * Handles the player's turn.
     * The player keeps drawing cards until the total value of the hand is at least 16.
     *
     * @return true if the player's total value is 21 or less, false otherwise
     */
    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.addCard(deck.deal());
        }
        return playerHand.getTotalValue() <= 21;
    }

    /**
     * Handles the dealer's turn.
     * The dealer keeps drawing cards until the total value of the hand is at least 17.
     *
     * @return true if the dealer's total value is 21 or less, false otherwise
     */
    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.addCard(deck.deal());
        }
        return dealerHand.getTotalValue() <= 21;
    }

    /**
     * Returns a string representation of the game, including the player's and dealer's hands and their total values.
     *
     * @return a string representation of the game
     */
    @Override
    public String toString() {
        String result = "Player's Hand:\n";
        for (int i = 0; i < playerHand.size(); i++) {
            result += playerHand.getCard(i) + "\n";
        }
        result += "Player's Total: " + playerHand.getTotalValue() + "\n\n";
        result += "Dealer's Hand:\n";
        for (int i = 0; i < dealerHand.size(); i++) {
            result += dealerHand.getCard(i) + "\n";
        }
        result += "Dealer's Total: " + dealerHand.getTotalValue() + "\n\n";
        return result;
    }
}
