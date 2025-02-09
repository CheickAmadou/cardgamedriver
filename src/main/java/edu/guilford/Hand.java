package edu.guilford;

import java.util.ArrayList;

/**
 * The Hand class represents a hand of playing cards.
 * It provides methods to add, remove, and get cards from the hand, calculate the value of the hand, and get a string representation of the hand.
 * @author Cheick Amadou
 * @version 1.0
 */
public class Hand {
    private ArrayList<Card> hand = new ArrayList<>();

    /**
     * Constructor to create a new hand of cards.
     */
    public Hand() {
        hand = new ArrayList<Card>();
    }

    /**
     * Returns the list of cards in the hand.
     *
     * @return the list of cards in the hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Adds a card to the hand.
     *
     * @param card the card to add to the hand
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * Removes a card from the hand.
     *
     * @param card the card to remove from the hand
     */
    public void removeCard(Card card) {
        hand.remove(card);
    }

    /**
     * Resets the hand by clearing all cards.
     */
    public void reset() {
        hand.clear();
    }

    /**
     * Returns the number of cards in the hand.
     *
     * @return the number of cards in the hand
     */
    public int size() {
        return hand.size();
    }

    /**
     * Returns the card at the specified index in the hand.
     *
     * @param index the index of the card to return
     * @return the card at the specified index
     */
    public Card getCard(int index) {
        return hand.get(index);
    }

    /**
     * Calculates the total value of the hand.
     * Aces are counted as 11 unless it would cause the hand to exceed 21, in which case they are counted as 1.
     *
     * @return the total value of the hand
     */
    public int getTotalValue() {
        int value = 0;
        int aces = 0;
        for (Card card : hand) {
            switch (card.getRank()) {
                case TWO:
                    value += 2;
                    break;
                case THREE:
                    value += 3;
                    break;
                case FOUR:
                    value += 4;
                    break;
                case FIVE:
                    value += 5;
                    break;
                case SIX:
                    value += 6;
                    break;
                case SEVEN:
                    value += 7;
                    break;
                case EIGHT:
                    value += 8;
                    break;
                case NINE:
                    value += 9;
                    break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    value += 10;
                    break;
                case ACE:
                    aces++;
                    break;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (value + 11 <= 21) {
                value += 11;
            } else {
                value += 1;
            }
        }
        return value;
    }

    /**
     * Returns a string representation of the hand.
     *
     * @return a string representation of the hand
     */
    @Override
    public String toString() {
        String handString = "";
        for (Card card : hand) {
            handString += card.toString() + "\n";
        }
        return handString;
    }

}
