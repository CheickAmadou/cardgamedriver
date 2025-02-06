package edu.guilford;

import java.util.Random;

/**
 * The Card class represents a playing card with a suit and rank.
 * It implements the Comparable interface to allow for card comparison.
 * @author Cheick Amadou
 * @version 1.0
 */
public class Card implements Comparable<Card> {
    /**
     * Enum for the suits of the cards.
     */
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    /**
     * Enum for the ranks of the cards.
     */
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    // instance variables
    private Suit suit;
    private Rank rank;

    /**
     * Constructor to create a card with a specific suit and rank.
     *
     * @param suit the suit of the card
     * @param rank the rank of the card
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Default constructor to create a card with a random suit and rank.
     */
    public Card() {
        // random Card
        Random rand = new Random();
        int suit = rand.nextInt(Suit.values().length);
        int rank = rand.nextInt(Rank.values().length);
        this.suit = Suit.values()[suit];
        this.rank = Rank.values()[rank];
    }

    /**
     * Getter for the suit of the card.
     *
     * @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Getter for the rank of the card.
     *
     * @return the rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    // toString
    public String toString() {
        return rank + " of " + suit;
    }

    /**
     * Compares this card with the specified card for order. Returns a -1 if this card is less than the specified card,
     * 1 if this card is greater than the specified card, and 0 if the cards are equal in both rank and suit.
     * The comparison is primarily based on the rank of the cards. If the ranks are equal,
     * the comparison is then based on the suit of the cards.
     *
     * @param otherCard the card to be compared.
     * @return a negative integer, zero, or a positive integer as this card is less than,
     *         equal to, or greater than the specified card.
     */
    @Override
    public int compareTo(Card otherCard) {
        if (this.rank.ordinal() > otherCard.rank.ordinal()) {
            return 1;
        } else if (this.rank.ordinal() < otherCard.rank.ordinal()) {
            return -1;
        } else {
            if (this.suit.ordinal() > otherCard.suit.ordinal()) {
                return 1;
            } else if (this.suit.ordinal() < otherCard.suit.ordinal()) {
                return -1;
            }
        }

        return 0;
    }

}