package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The Deck class represents a deck of playing cards.
 * It provides methods to build, shuffle, pick, and deal cards from the deck.
 * @author Cheick Amadou
 * @version 1.0
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private Random rand = new Random();

    /**
     * Constructor to create a new deck of cards.
     * The deck is built upon initialization.
     */
    public Deck() {
        build();
    }

    /**
     * Returns the list of cards in the deck.
     *
     * @return the list of cards in the deck
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    /**
     * Clears the deck of all cards.
     */
    public void clear() {
        deck.clear();
    }

    /**
     * Builds a standard deck of 52 playing cards.
     */
    public void build() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        /*
        // Original shuffle method
        ArrayList<Card> tempDeck = new ArrayList<>();
        while (deck.size() > 0) {
            int loc = rand.nextInt(deck.size());
            tempDeck.add(deck.get(loc));
            deck.remove(loc);
        }
        deck = tempDeck;
         */
        // More efficient way to shuffle
        Collections.shuffle(deck,rand);
    }

    /**
     * Picks a card from the deck at the specified index.
     *
     * @param i the index of the card to pick
     * @return the picked card
     */
    public Card pick(int i) {
        Card picked = deck.remove(i);
        return picked;
    }

    /**
     * Deals the top card from the deck.
     *
     * @return the top card from the deck
     */
    public Card deal() {
        return deck.remove(0);
    }

    /**
     * Returns the number of cards in the deck.
     *
     * @return the number of cards in the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Returns a string representation of the deck.
     *
     * @return a string representation of the deck
     */
    @Override
    public String toString() {
        String deckString = "";
        for (Card card : deck) {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }
}
