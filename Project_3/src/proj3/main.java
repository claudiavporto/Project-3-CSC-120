package proj3;

import java.util.*;

public class main {

    private static final int HAND_SIZE = 5;

    public static void main(String[] args){

        Deck gameDeck = new Deck();
        boolean correctAnswer = true;
        int totalScore = 0;

        ArrayList<Card> hand1Cards = new ArrayList<>();
        ArrayList<Card> hand2Cards = new ArrayList<>();

        while ((gameDeck.size() >= 5) && correctAnswer){
            System.out.println("Hand 1: ");
            PokerHand hand1 = new PokerHand(hand1Cards);
            hand1.dealHand(gameDeck);
            System.out.println(hand1);

            System.out.println("Hand 2: ");
            PokerHand hand2 = new PokerHand(hand2Cards);
            hand2.dealHand(gameDeck);
            System.out.println(hand2);

            int actualResult = hand1.compareTo(hand2);

            Scanner input = new Scanner(System.in);
            System.out.println("\"Which hand is worth more? Are they equal?\nEnter 1 for Hand 1, -1 for Hand 2, or 0 for a Tie\n");
            String userGuess = input.nextLine();

            if (actualResult != Integer.parseInt(userGuess)){
                correctAnswer = false;
                System.out.println("Sorry! You lost!\nThe correct answer was " + actualResult);
            }else{
                totalScore++;
                System.out.println("Nice! You got it right!\n");
            }
        }
        System.out.println("Final score: " + totalScore);

        gameDeck.gather();
        gameDeck.shuffle();
    }
}
