package proj3;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    private static final int LOWEST_RANK = 2;
    private static final int HIGHEST_RANK_ACE = 14;
    private static final int SIZE_OF_DECK = 52;
    private static final int FIRST_CARD = 0;
    private static final int EMPTY = 0;

    private int nextToDeal = 0;
    private ArrayList<Card> cardDeck;

    /**
     * Constructs a deck of 52 cards, then shuffles it.
     */
    public Deck(){
        cardDeck = new ArrayList<Card>(SIZE_OF_DECK);

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        for (String suit: suits){
            for(int rank = LOWEST_RANK; rank <= HIGHEST_RANK_ACE; rank++){
                cardDeck.add(new Card(rank, suit));
            }
        }

        shuffle();
    }

    /**
     * Shuffles the card deck.
     */
    public void shuffle(){
        for (int i = nextToDeal; i < size(); i++){
            int currentIndex = i;
            Card cardToSwap = cardDeck.get(currentIndex);
            int randIndex = ThreadLocalRandom.current().nextInt(SIZE_OF_DECK - nextToDeal);
            Card randCard = cardDeck.get(randIndex);

            cardDeck.set(currentIndex, randCard);
            cardDeck.set(randIndex,cardToSwap);
        }
    }

    private boolean isEmpty(){
        return size() == EMPTY;
    }

    /**
     * Checks to see if the card deck is not empty.
     * If it is not empty, get next card to deal and increment nextToDeal.
     *
     * @return the next card to deal if not empty, null if card deck is empty
     */
    public Card deal(){
        if (!isEmpty()) {
            Card c = cardDeck.get(nextToDeal);
            nextToDeal++;
            return c;
        }else{
            return null;
        }
    }

    /**
     * Determines the size of the deck of undealt cards.
     *
     * @return the size of the deck
     */
    public int size(){
        return SIZE_OF_DECK - nextToDeal;
    }

    /**
     * Returns card deck to its original state with no cards dealt.
     *
     * @return the card deck
     */
    public void gather() {
        nextToDeal = FIRST_CARD;
    }

    public String toString(){
        StringBuilder strCardDeck = new StringBuilder();
        for (Card c: cardDeck){//change for loop){
            strCardDeck.append(c);
            strCardDeck.append("\n");
        }
        return strCardDeck.toString();
    }
}
