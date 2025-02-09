package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The LamarckianPoker class represents a game of Lamarckian Poker.
 * It provides methods to reset the game, deal cards, make a pool, handle turns, and determine the winner.
 * @author Cheick Amadou
 * @version 1.0
 */
public class LamarckianPoker {
    private Hand player1Hand;
    private Hand player2Hand;
    private Hand pool;
    private Deck discard;
    private Deck deck;
    private Random rand = new Random();
    //Not specified and unneccesary
    //private int iTurn;

/**
     * Constructor to create a new game of Lamarckian Poker.
     * The game is reset upon initialization.
     */
    public LamarckianPoker() {
        reset();
    }

/**
     * Returns the player's hand.
     *
     * @return the player's hand
     */
    public Hand getPlayer1Hand() {
        return player1Hand;
    }

/**
     * Returns the dealer's hand.
     *
     * @return the dealer's hand
     */
    public Hand getPlayer2Hand() {
        return player2Hand;
    }

/**
     * Returns the pool of cards.
     *
     * @return the pool of cards
     */
    public Hand getPool() {
        return pool;
    }

/**
     * Resets the game by creating a new deck and shuffling it.
    */
    public void reset( ) {    
            deck = new Deck();
            discard = new Deck();
            discard.clear();
            deck.shuffle();
    }
    // newDeck parameter is not needed
    /* 
    public void reset(boolean newDeck) {
        if (newDeck) {
            deck = new Deck();
            discard = new Deck();
            discard.clear();
            deck.shuffle();
        }
    }
        */

/**
     * Deals four cards to both the player and the dealer.
     */
    public void deal() {
        player1Hand = new Hand();
        player2Hand = new Hand();
        for (int iCard = 0; iCard < 4; iCard++) {
            player1Hand.addCard(deck.deal());
            player2Hand.addCard(deck.deal());
        }
    }

/**
     * Creates a pool of four cards.
     */
    public void makePool() {
        pool = new Hand();
        for (int iCard = 0; iCard < 4; iCard++) {
            pool.addCard(deck.deal());
        }
        // System.out.println("Deck size: " + deck.size());
    }

/**
     * Handles a turn in the game.
     *
     * @return true if the turn was successful, false otherwise
     */
    public boolean turn() {
        // I changed the condition to also check if the players have more than 0 cards in their hands to get rid of the illegal argument exception.
        if ((player1Hand.size() < 7||player2Hand.size() < 7) && player1Hand.size() > 0 && player2Hand.size() > 0) {
            makePool();
            // System.out.println("Turn " + iTurn + "\n" + pool);
            Card player1Card = player1Hand.getCard(rand.nextInt(player1Hand.size()));
            Card player2Card = player2Hand.getCard(rand.nextInt(player2Hand.size()));
            Hand firstHand, secondHand;
            Card firstCard, secondCard;
            //No point in doing this if we have a compareTo method
           /* if (player1Card.getRank().ordinal() > player2Card.getRank().ordinal()) {
                firstHand = player1Hand;
                secondHand = player2Hand;
                firstCard = player1Card;
                secondCard = player2Card;
            } else if (player1Card.getRank().ordinal() < player2Card.getRank().ordinal()) {
                firstHand = player2Hand;
                secondHand = player1Hand;
                firstCard = player2Card;
                secondCard = player1Card;
            } else {
                if (player1Card.getSuit().ordinal() > player2Card.getSuit().ordinal()) {
                    firstHand = player1Hand;
                    secondHand = player2Hand;
                    firstCard = player1Card;
                    secondCard = player2Card;
                } else {
                    firstHand = player2Hand;
                    secondHand = player1Hand;
                    firstCard = player2Card;
                    secondCard = player1Card;
                }

            }
            */
            if (player1Card.compareTo(player2Card) > 0) {
                firstHand = player1Hand;
                secondHand = player2Hand;
                firstCard = player1Card;
                secondCard = player2Card;
            } else {
                firstHand = player2Hand;
                secondHand = player1Hand;
                firstCard = player2Card;
                secondCard = player1Card;
            }
            ArrayList<Card> poolRemove = new ArrayList<Card>();

            for (Card poolCard : pool.getHand()) {
                if (firstCard.getRank().ordinal() == poolCard.getRank().ordinal() ||
                        firstCard.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                    firstHand.addCard(poolCard);
                    poolRemove.add(poolCard);
                }
            }
            // Remove cards from pool
            for (Card poolCard : poolRemove) {
                pool.removeCard(poolCard);
            }
            poolRemove.clear();
            // The card that was played is added to the discard pile not the pool
            //pool.addCard(firstCard);
            discard.getDeck().add(firstCard);
            firstHand.removeCard(firstCard);
            for (Card poolCard : pool.getHand()) {
                if (secondCard.getRank().ordinal() == poolCard.getRank().ordinal() ||
                        secondCard.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
                    secondHand.addCard(poolCard);
                    poolRemove.add(poolCard);
                }
            }
            for (Card poolCard : poolRemove) {
                pool.removeCard(poolCard);
            }
            // The card that was played is added to the discard pile not the pool
            //pool.addCard(secondCard);
            discard.getDeck().add(secondCard);
            secondHand.removeCard(secondCard);
            for (Card poolCard : pool.getHand()) {
                discard.getDeck().add(poolCard);
            }
            pool.getHand().clear();
            // System.out.println("Discard\n" + discard.size());
            if (deck.size() < 4) {
                for (Card card : discard.getDeck()) {
                    deck.getDeck().add(card);
                }
                discard.clear();
                // System.out.println("Discard\n" + discard.size());
            }            
            return true;
        } else {
            return false;
        }

    }

     /**
     * Determines the winner of the game based on the best five-card hand.
     *
     * @return the winner of the game ("Player 1", "Player 2", or "Tie")
     */
    public String getWinner() {
        int player1BestValue = getBestFiveCardHandValue(player1Hand);
        int player2BestValue = getBestFiveCardHandValue(player2Hand);

        if (player1BestValue > player2BestValue) {
            return "Player 1";
        } else if (player2BestValue > player1BestValue) {
            return "Player 2";
        } else {
            return "Tie";
        }
    }

    /**
     * Evaluates the best five-card hand value for the given hand.
     *
     * @param hand the hand to evaluate
     * @return the best five-card hand value
     */
    private int getBestFiveCardHandValue(Hand hand) {
        // Sort the cards in the hand
        ArrayList<Card> sortedCards = new ArrayList<>(hand.getHand());
        Collections.sort(sortedCards);

        // Select the top 5 cards
        Hand bestFiveCardHand = new Hand();
        for (int i = 0; i < 5 && i < sortedCards.size(); i++) {
            bestFiveCardHand.addCard(sortedCards.get(i));
        }

        // Return the total value of the best five-card hand
        return bestFiveCardHand.getTotalValue();
    }

    @Override
    /**
     * Returns a string representation of the game, including the player's hands and the pool.
     * @return a string representation of the game
     */
    public String toString() 
    {
        return "\nPlayer 1: \n" + player1Hand + "\nPlayer 2: \n" + player2Hand + "\nPool: " + pool + "\n";
    }
}
