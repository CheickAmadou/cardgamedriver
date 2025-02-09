# Code Review for Card Class

## Relevant Code Review Items

1. **Class Implementation**
   - The `Card` class should implement the `Comparable<Card>` interface.

2. **Attributes**
   - The `Card` class should have a suit chosen from `CLUBS, DIAMONDS, HEARTS, SPADES`.
   - The `Card` class should have a rank chosen from `ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING`.
   - The suit and rank should be declared using `enum` structures named `Suit` and `Rank`.

3. **Constructors**
   - `public Card()` should produce a randomly chosen `Card` object.
   - `public Card(Suit suit, Rank rank)` should produce a `Card` object of the specified suit and rank.

4. **Methods**
   - `public Suit getSuit()` should return the suit of the `Card` object.
   - `public Rank getRank()` should return the rank of the `Card` object.
   - `public String toString()` should return a well-formatted `String` representation of this `Card` object.
   - `public int compareTo(Card otherCard)` should compare this `Card` object to `otherCard`. Rank is compared first and then suit.

## Evaluation

### Class Implementation
- **Satisfactory**: The `Card` class implements the `Comparable<Card>` interface.

### Attributes
- **Satisfactory**: The `Card` class has a suit and rank chosen from the specified enums `Suit` and `Rank`.

### Constructors
- **Satisfactory**: The `Card` class has both constructors implemented correctly.
  - `public Card()` produces a randomly chosen `Card` object.
  - `public Card(Suit suit, Rank rank)` produces a `Card` object of the specified suit and rank.

### Methods
- **Satisfactory**: The `Card` class has the `getSuit()` and `getRank()` methods implemented correctly.
- **Satisfactory**: The `toString()` and `compareTo(Card otherCard)` methods are implemented correctly in the provided code.

### Documentation
- **Unsatisfactory**: There weren't proper Javadoc comments. I fixed this by adding Javadoc comments to the `Card` class.

# Code Review for Deck Class

## Relevant Code Review Items

1. **Class Implementation**
   - The `Deck` class should represent a deck of playing cards.

2. **Attributes**
   - The `Deck` class should have a list of `Card` objects.
   - The `Deck` class should have a `Random` object for random operations.

3. **Constructors**
   - `public Deck()` should construct a standard 52-card deck using the `build()` method.

4. **Methods**
   - `public ArrayList<Card> getDeck()` should return the list of cards in the deck.
   - `public void clear()` should empty the deck.
   - `public void build()` should add all 52 `Card` objects in a standard deck to the deck in a specified order.
   - `public void shuffle()` should shuffle the order of objects in the deck using some standard algorithm that ensures a randomly arranged deck.
   - `public Card pick(int i)` should return the `Card` object in the deck at index `i` and remove that `Card` object from the deck.
   - `public Card deal()` should return the `Card` object at index 0 (assumed to be the "top" of the deck) and remove that `Card` object from the deck.
   - `public int size()` should return the number of `Card` objects in the deck.
   - `public String toString()` should return a well-formatted `String` representation of this `Deck` object.

## Evaluation

### Class Implementation
- **Satisfactory**: The `Deck` class represents a deck of playing cards.

### Attributes
- **Satisfactory**: The `Deck` class has a list of `Card` objects and a `Random` object for random operations.

### Constructors
- **Satisfactory**: The `Deck` class has the constructor implemented correctly.
  - `public Deck()` constructs a standard 52-card deck using the `build()` method.

### Methods
- **Satisfactory**: The `Deck` class has the `getDeck()`, `clear()`, `build()`, `pick(int i)`, `deal()`, `size()`, and `toString()` methods implemented correctly.
- **Unsatisfactory**: The `shuffle()` method is implemented correctly but used an inefficient sorting algorithm.

### Documentation
- **Unsatisfactory**: There weren't proper Javadoc comments. I fixed this by adding Javadoc comments to the `Deck` class.

### Code Changes
- **Shuffle Method**: The original shuffle method was commented out and replaced with a more efficient shuffle method using `Collections.shuffle(deck)`.

```java

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
```

# Code Review for Hand Class

## Relevant Code Review Items

1. **Class Implementation**
   - The `Hand` class should represent a hand of playing cards.

2. **Attributes**
   - The `Hand` class should have a list of `Card` objects.

3. **Methods**
   - `public void addCard(Card card)` should add a card to the hand.
   - `public void removeCard(Card card)` should remove a card from the hand.
   - `public void reset()` should clear all cards from the hand.
   - `public int size()` should return the number of cards in the hand.
   - `public Card getCard(int index)` should return the card at the specified index in the hand.
   - `public int getTotalValue()` should calculate the total value of the hand.
   - `public String toString()` should return a well-formatted `String` representation of this `Hand` object.

## Evaluation

### Class Implementation
- **Satisfactory**: The `Hand` class represents a hand of playing cards.

### Attributes
- **Satisfactory**: The `Hand` class has a list of `Card` objects.

### Methods
- **Satisfactory**: The `Hand` class has the `addCard(Card card)`, `removeCard(Card card)`, `reset()`, `size()`, `getCard(int index)`, `getTotalValue()`, and `toString()` methods implemented correctly.

### Documentation
- **Unsatisfactory**: There weren't proper Javadoc comments. I fixed this by adding Javadoc comments to the `Hand` class.

### Code Changes
- **Javadoc Comments**: Added Javadoc comments to the `Hand` class methods.

# Code Review for Blackjack Class

## Relevant Code Review Items

1. **Class Implementation**
   - The `Blackjack` class should implement the actions described above.

2. **Attributes**
   - The `Blackjack` class should have two `Hand` objects for the player and dealer hands.
   - The `Blackjack` class should have a `Deck` object for the deck to be used in the game.

3. **Constructor**
   - `public Blackjack()` should use the `reset()` method to prepare the `Deck` object for a new game.

4. **Methods**
   - `public Hand getPlayerHand()` should return the `Hand` object representing the player's hand.
   - `public Hand getDealerHand()` should return the `Hand` object representing the dealer's hand.
   - `public Deck getDeck()` should return the current state of the object's `Deck`.
   - `public void reset()` should instantiate a new `Deck` object and apply its `shuffle()` method.
   - `public void deal()` should instantiate two `Hand` objects, assigning them to the appropriate player and dealer attributes. It should then add two `Card` objects from the `Deck` object to each `Hand` object.
   - `public boolean playerTurn()` should apply the rules described above to the player's hand. It should return `true` if the value of the player's hand is less than or equal to 21 and `false` otherwise.
   - `public boolean dealerTurn()` should apply the rules described above to the dealer's hand. It should return `true` if the value of the dealer's hand is less than or equal to 21 and `false` otherwise.
   - `public String toString()` should return a well-formatted `String` representation of this `Blackjack` object.

## Evaluation

### Class Implementation
- **Satisfactory**: The `Blackjack` class implements the actions described above.

### Attributes
- **Satisfactory**: The `Blackjack` class has two `Hand` objects for the player and dealer hands.
- **Satisfactory**: The `Blackjack` class has a `Deck` object for the deck to be used in the game.

### Constructor
- **Satisfactory**: The `Blackjack` class has the constructor implemented correctly.
  - `public Blackjack()` uses the `reset()` method to prepare the `Deck` object for a new game.

### Methods
- **Satisfactory**: The `Blackjack` class has the `getPlayerHand()`, `getDealerHand()`, `getDeck()`, `deal()`, `playerTurn()`, `dealerTurn()`, and `toString()` methods implemented correctly.
-**Unsatisfactory**: The `Blackjack` class had the `reset()` implemented uncorrectly as it had a boolean input which wasn't neccessary and wasn't specified in the documentation.

### Documentation
- **Unsatisfactory**: There weren't proper Javadoc comments. I fixed this by adding Javadoc comments to the `Blackjack` class.

### Code Change
- **Javadoc Comments**: Added Javadoc comments to the `Blackjack` class methods.

### Code Change
- **Reset Method**: The original `reset(boolean newDeck)` method was unsatisfactory and was commented out. A new `reset()` method was added to reset the deck and shuffle it without any input.

```java
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
```
# Code Review for LamarckianPoker Class

## Relevant Code Review Items

1. **Class Implementation**
   - The `LamarckianPoker` class should implement the start of a new game and the playing of a single turn.

2. **Attributes**
   - The `LamarckianPoker` class should have two `Hand` objects for the player and dealer hands.
   - The `LamarckianPoker` class should have a `Deck` object for the deck to be used in the game.
   - The `LamarckianPoker` class should have a `Hand` object for the pool.
   - The `LamarckianPoker` class should have a `Deck` object for the discard pile.
   - The `LamarckianPoker` class should have a `Random` object.

3. **Constructors**
   - `public LamarckianPoker()` should create a new game using the `reset()` method.

4. **Methods**
   - `public Hand getPlayer1Hand()` should return the hand of the first player.
   - `public Hand getPlayer2Hand()` should return the hand of the second player.
   - `public Hand getPool()` should return the hand representing the pool.
   - `public void reset(boolean newDeck)` should create a game with a new shuffled deck and discard pile.
   - `public void deal()` should instantiate new `Hand` objects for each player and deal 4 `Card` objects from the deck to each player.
   - `public void makePool()` should create a `Hand` object and deal 4 `Card` objects from the deck to this object.
   - `public boolean turn()` should implement the turn rules described above with the `Card` object from each player chosen randomly. The method should return `true` if the size of both player hands is less than 7 and `false` otherwise.
   - `public String toString()` should return a well-formatted `String` representation of this `LamarckianPoker` object.

## Evaluation

### Class Implementation
- **Satisfactory**: The `LamarckianPoker` class implements the start of a new game and the playing of a single turn.

### Attributes
- **Satisfactory**: The `LamarckianPoker` class has two `Hand` objects for the player and dealer hands.
- **Satisfactory**: The `LamarckianPoker` class has a `Deck` object for the deck to be used in the game.
- **Satisfactory**: The `LamarckianPoker` class has a `Hand` object for the pool.
- **Satisfactory**: The `LamarckianPoker` class has a `Deck` object for the discard pile.
- **Satisfactory**: The `LamarckianPoker` class has a `Random` object.

### Constructors
- **Satisfactory**: The `LamarckianPoker` class has the constructor implemented correctly.
  - `public LamarckianPoker()` creates a new game using the `reset()` method.

### Methods
- **Satisfactory**: The `LamarckianPoker` class has the `getPlayer1Hand()`, `getPlayer2Hand()`, `getPool()`, `deal()`, `makePool()`, and `toString()` methods implemented correctly.
- **Unsatisfactory**: The newDeck boolean input of the `reset()` method was unnecessary. Also in the `turn()` method, the first sacificial card was
sent to the pool hand instead of immediately going to the discard pile which means that the second player could use that same card. Additionally in the `turn()` method, the compareTo method was rewriten in the code instead of just calling it from the Card object.

### Documentation
- **Satisfactory**: The `LamarckianPoker` class has proper Javadoc comments for all methods.

### Code Changes
- **iTurn**: This attribute was unneccesary and wasn't mentioned in the specifications so I removed it.
- **Reset Method**: The `reset()` method was implemented to create a game with a new shuffled deck and discard pile.
- **Get Winner Method**: A `getWinner()` method was added to determine the winner of the game based on the best five-card hand.
- **Best Five-Card Hand Evaluation**: The `getBestFiveCardHandValue(Hand hand)` method was added to evaluate the best five-card hand value for the given hand. First I sorted the cards, then I took the top 5 cards and put them in a hand, and then I found the total value of them. 
- **Turn Method**: First Sacificial card method was fixed. Implemented CompareTo. In addition, I also fixed the Illegal Argument Exception coming from this method.

### IllegalArgumentException Issue

#### Problem Description
When running the program, an `IllegalArgumentException` occasionally occurs in the `LamarckianPoker` class. The error happens the player has zero cards and `rand.nextInt(player1Hand.size())` or `rand.nextInt(player2Hand.size())` is called trying to get a random card.

#### Cause of the Error
The `IllegalArgumentException` is caused by passing an illegal argument to the `rand.nextInt()` method. This method requires a positive, non zero, integer as an argument. If the size of the player's hand is zero, the argument passed to `rand.nextInt()` will be zero, leading to the exception being thrown.

#### Conditions Leading to the Error
The error occurs when one or both players have zero cards in their hand. This happens when a player loses all their cards during the game. When the `turn()` method is called, it attempts to get a random card from an empty hand, resulting in the `IllegalArgumentException`.

#### Proposed Fix
To fix this issue, the `turn()` method should be changed make sure both players have more than zero cards. If a player has zero cards, the game should be considered over, and that player should be declared the loser as there is no way for them to get a card.

#### Code Changes
The `turn()` method was updated to include a check to ensure that both players have more than zero cards before proceeding with the turn. If either player has zero cards, the game ends.

```java
    /**
     * Handles a turn in the game.
     *
     * @return true if the turn was successful, false otherwise
     */
    public boolean turn() {
        if (player1Hand.size() < 7 || player2Hand.size() < 7&& player1Hand.size() > 0 && player2Hand.size() > 0) {
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
```

