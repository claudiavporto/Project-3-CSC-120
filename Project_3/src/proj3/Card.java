package proj3;
public class Card {
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int ACE = 14;

    private int rank;
    private String suit;

    /**
     * Constructs a card with a given rank and suit.
     * @param rank The given rank.
     * @param suit The given suit.
     */
    public Card(int rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    /**
     Gets and returns the rank of the card.
     @return the rank
     */
    public int getRank(){
        return this.rank;
    }

    /**
     * Gets and returns the suit of the card.
     * @return the suit
     */
    public String getSuit(){
        return this.suit;
    }

    public String toString(){
        String stringRank = "";
        if (this.rank == JACK){
            stringRank = "Jack";
        }else if (this.rank == QUEEN){
            stringRank = "Queen";
        }else if (this.rank == KING){
            stringRank = "King";
        }else if (this.rank == ACE){
            stringRank = "Ace";
        }else{
            stringRank = Integer.toString(this.rank);
        }
        return stringRank + " of " + this.suit;
    }

}
