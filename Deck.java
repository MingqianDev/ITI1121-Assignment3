import java.util.Random;

/**
 *  Deck represents a deck of playing cards and contains 52 regular cards.
 */
public class Deck {

    private Card[] deck;  // an array of 52 cards.  
    private int number;  //the number of cards that have been dealt from the deck

    /**
     * Constructs a regular 52-card poker deck.  Initially, the cards
     * are in a sorted order.  
     */
    public Deck() {
        // YOUR CODE COMES HERE
        this.deck = new Card[52];
        this.number = 0;

        // loop for the 4 suits
        for (int i = 0; i < 4; i++) {
            // loop for the 13 values
            for (int j = 0; j < 13; j++) {
                deck[j + 13 * i] = new Card(j + 1, i);
            }
        }
 }


    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() {
        // YOUR CODE COMES HERE
        number = 0;

        for (int i = deck.length - 1; i > 0; i--) {
            int j = (int)(Math.random() * (i + 1));

            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    /**
     * Returns the number of cards left in the deck.  
     */
    public int numberLeft() {
        // YOUR CODE COMES HERE
        return 52 - number;
    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the numberLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card take() {
        // YOUR CODE COMES HERE
        if (numberLeft() <= 0) {
            throw new IllegalStateException("No card are left");
        }

        return deck[number++];
    }
} // end class Deck
