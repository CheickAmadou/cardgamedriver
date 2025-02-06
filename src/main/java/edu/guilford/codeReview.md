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
- **Satisfactory**: The `toString()` and `compareTo(Card otherCard)` methods are implement correctly in the provided code.

### Documentation
- **Unsatisfactory**: There weren't proper Java Doc Comments. I fixed this by adding Java Doc Comments to the Card Class.