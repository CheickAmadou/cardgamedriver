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
- **Satisfactory**: The `shuffle()` method is implemented correctly using `Collections.shuffle(deck)` for more efficient shuffling.

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

