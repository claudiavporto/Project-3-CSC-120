package proj3;

import java.util.ArrayList;

/** I affirm that I have carried out the attached academic endeavors
 *  with full academic honesty, in accordance with the Union College
 *  Honor Code and the course syllabus.
 */
public class PokerComparisonTests {
    public static void main(String[] args){

        testCompareTo();
        testCard();
        testDeck();
        proj3.Testing.finishTests();
    }

    public static void testCompareTo(){
        proj3.Testing.setVerbose(true);
        proj3.Testing.testSection("Testing compareTo()");

        testHand1WinsByType();
        testHand2WinsByType();
        testFlushHands();
        testTwoPairHands();
        testPairHands();
        testHighCardHands();
    }

    public static void testHand1WinsByType(){
        proj3.Testing.testSection("Testing Hand 1 wins by Comparing Type");

        ArrayList<Card> handList = new ArrayList<>();
        PokerHand hand = new PokerHand(handList);
        ArrayList<Card> otherList = new ArrayList<>();
        PokerHand other = new PokerHand(otherList);

        Card f1 = new Card(3, "Spades");
        Card f2 = new Card(14, "Spades");
        Card f3 = new Card(8, "Spades");
        Card f4 = new Card(5, "Spades");
        Card f5 = new Card(10, "Spades");

        Card p1 = new Card(3, "Spades");
        Card p2 = new Card(4, "Diamonds");
        Card p3 = new Card(8, "Spades");
        Card p4 = new Card(7, "Hearts");
        Card p5 = new Card(8, "Clubs");

        hand.addCard(f1);
        hand.addCard(f2);
        hand.addCard(f3);
        hand.addCard(f4);
        hand.addCard(f5);

        other.addCard(p1);
        other.addCard(p2);
        other.addCard(p3);
        other.addCard(p4);
        other.addCard(p5);

        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + other.toString() + "This hand is worth MORE than Other hand by Type", 1, hand.compareTo(other));
    }

    public static void testHand2WinsByType(){
        proj3.Testing.testSection("Testing Hand 2 wins by Comparing Type");

        ArrayList<Card> handList = new ArrayList<>();
        PokerHand hand = new PokerHand(handList);
        ArrayList<Card> otherList = new ArrayList<>();
        PokerHand other = new PokerHand(otherList);

        Card hc1 = new Card(3, "Clubs");
        Card hc2 = new Card(5, "Hearts");
        Card hc3 = new Card(8, "Spades");
        Card hc4 = new Card(13, "Diamonds");
        Card hc5 = new Card(10, "Hearts");

        Card tp1 = new Card(3, "Spades");
        Card tp2 = new Card(3, "Diamonds");
        Card tp3 = new Card(8, "Spades");
        Card tp4 = new Card(7, "Hearts");
        Card tp5 = new Card(8, "Clubs");

        hand.addCard(hc1);
        hand.addCard(hc2);
        hand.addCard(hc3);
        hand.addCard(hc4);
        hand.addCard(hc5);

        other.addCard(tp1);
        other.addCard(tp2);
        other.addCard(tp3);
        other.addCard(tp4);
        other.addCard(tp5);

        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + other.toString() + "This hand is worth LESS than Other hand by Type", -1, hand.compareTo(other));
    }

    public static void testFlushHands(){
        proj3.Testing.testSection("Testing which Flush Hand Wins");

        ArrayList<Card> handList = new ArrayList<>();
        PokerHand hand = new PokerHand(handList);
        ArrayList<Card> otherList = new ArrayList<>();
        PokerHand other = new PokerHand(otherList);
        ArrayList<Card> otherFlshList = new ArrayList<>();
        PokerHand otherFlsh = new PokerHand(otherFlshList);
        ArrayList<Card> otherFlushList = new ArrayList<>();
        PokerHand otherFlush = new PokerHand(otherFlushList);

        Card thisF1 = new Card(3, "Spades");
        Card thisF2 = new Card(14, "Spades");
        Card thisF3 = new Card(8, "Spades");
        Card thisF4 = new Card(5, "Spades");
        Card thisF5 = new Card(10, "Spades");

        Card otherF1 = new Card(2, "Hearts");
        Card otherF2 = new Card(7, "Hearts");
        Card otherF3 = new Card(6, "Hearts");
        Card otherF4 = new Card(9, "Hearts");
        Card otherF5 = new Card(13, "Hearts");

        Card otherFlsh1 = new Card(2, "Diamonds");
        Card otherFlsh2 = new Card(7, "Diamonds");
        Card otherFlsh3 = new Card(14, "Diamonds");
        Card otherFlsh4 = new Card(9, "Diamonds");
        Card otherFlsh5 = new Card(13, "Diamonds");

        Card otherFlush1 = new Card(8, "Clubs");
        Card otherFlush2 = new Card(5, "Clubs");
        Card otherFlush3 = new Card(14, "Clubs");
        Card otherFlush4 = new Card(3, "Clubs");
        Card otherFlush5 = new Card(10, "Clubs");

        hand.addCard(thisF1);
        hand.addCard(thisF2);
        hand.addCard(thisF3);
        hand.addCard(thisF4);
        hand.addCard(thisF5);

        other.addCard(otherF1);
        other.addCard(otherF2);
        other.addCard(otherF3);
        other.addCard(otherF4);
        other.addCard(otherF5);

        otherFlsh.addCard(otherFlsh1);
        otherFlsh.addCard(otherFlsh2);
        otherFlsh.addCard(otherFlsh3);
        otherFlsh.addCard(otherFlsh4);
        otherFlsh.addCard(otherFlsh5);

        otherFlush.addCard(otherFlush1);
        otherFlush.addCard(otherFlush2);
        otherFlush.addCard(otherFlush3);
        otherFlush.addCard(otherFlush4);
        otherFlush.addCard(otherFlush5);

        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + other.toString() + "This hand is worth MORE than Other hand", 1, hand.compareTo(other));
        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + otherFlsh.toString() + "This hand is worth LESS than Other hand", -1, hand.compareTo(otherFlsh));
        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + otherFlush.toString() + "This hand is worth the SAME as Other hand", 0, hand.compareTo(otherFlush));
    }

    public static void testTwoPairHands(){
        proj3.Testing.testSection("Testing which Two-Pair Hand Wins");
        ArrayList<Card> handList = new ArrayList<>();
        PokerHand hand = new PokerHand(handList);
        ArrayList<Card> otherList = new ArrayList<>();
        PokerHand other = new PokerHand(otherList);
        ArrayList<Card> otherTPList = new ArrayList<>();
        PokerHand otherTP = new PokerHand(otherTPList);
        ArrayList<Card> otherTwoPairList = new ArrayList<>();
        PokerHand otherTwoPair = new PokerHand(otherTwoPairList);

        Card thisTP1 = new Card(3, "Spades");
        Card thisTP2 = new Card(3, "Diamonds");
        Card thisTP3 = new Card(8, "Spades");
        Card thisTP4 = new Card(7, "Hearts");
        Card thisTP5 = new Card(8, "Clubs");

        Card otherTP1 = new Card(3, "Hearts");
        Card otherTP2 = new Card(3, "Clubs");
        Card otherTP3 = new Card(8, "Hearts");
        Card otherTP4 = new Card(4, "Hearts");
        Card otherTP5 = new Card(8, "Spades");

        Card otherTwoP1 = new Card(3, "Spades");
        Card otherTwoP2 = new Card(3, "Diamonds");
        Card otherTwoP3 = new Card(8, "Spades");
        Card otherTwoP4 = new Card(14, "Hearts");
        Card otherTwoP5 = new Card(8, "Clubs");

        Card otherTwoPair1 = new Card(3, "Hearts");
        Card otherTwoPair2 = new Card(3, "Clubs");
        Card otherTwoPair3 = new Card(8, "Hearts");
        Card otherTwoPair4 = new Card(7, "Spades");
        Card otherTwoPair5 = new Card(8, "Diamonds");

        hand.addCard(thisTP1);
        hand.addCard(thisTP2);
        hand.addCard(thisTP3);
        hand.addCard(thisTP4);
        hand.addCard(thisTP5);

        other.addCard(otherTP1);
        other.addCard(otherTP2);
        other.addCard(otherTP3);
        other.addCard(otherTP4);
        other.addCard(otherTP5);

        otherTP.addCard(otherTwoP1);
        otherTP.addCard(otherTwoP2);
        otherTP.addCard(otherTwoP3);
        otherTP.addCard(otherTwoP4);
        otherTP.addCard(otherTwoP5);

        otherTwoPair.addCard(otherTwoPair1);
        otherTwoPair.addCard(otherTwoPair2);
        otherTwoPair.addCard(otherTwoPair3);
        otherTwoPair.addCard(otherTwoPair4);
        otherTwoPair.addCard(otherTwoPair5);

        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + other.toString() + "This hand is worth MORE than Other hand", 1, hand.compareTo(other));
        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + otherTP.toString() + "This hand is worth LESS than Other hand", -1, hand.compareTo(otherTP));
        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + otherTwoPair.toString() + "This hand is worth the SAME as Other hand", 0, hand.compareTo(otherTwoPair));
    }

    public static void testPairHands(){
        proj3.Testing.testSection("Testing which Pair Hand Wins");

        ArrayList<Card> handList = new ArrayList<>();
        PokerHand hand = new PokerHand(handList);
        ArrayList<Card> otherList = new ArrayList<>();
        PokerHand other = new PokerHand(otherList);
        ArrayList<Card> otherPList = new ArrayList<>();
        PokerHand otherP = new PokerHand(otherPList);
        ArrayList<Card> otherPairList = new ArrayList<>();
        PokerHand otherPair = new PokerHand(otherPairList);

        Card thisTP1 = new Card(3, "Spades");
        Card thisTP2 = new Card(4, "Diamonds");
        Card thisTP3 = new Card(8, "Spades");
        Card thisTP4 = new Card(7, "Hearts");
        Card thisTP5 = new Card(8, "Clubs");

        Card other1 = new Card(6, "Spades");
        Card other2 = new Card(6, "Hearts");
        Card other3 = new Card(9, "Spades");
        Card other4 = new Card(4, "Diamonds");
        Card other5 = new Card(13, "Hearts");

        Card otherP1 = new Card(2, "Clubs");
        Card otherP2 = new Card(7, "Hearts");
        Card otherP3 = new Card(11, "Spades");
        Card otherP4 = new Card(8, "Diamonds");
        Card otherP5 = new Card(11, "Clubs");

        Card otherPair1 = new Card(7, "Clubs");
        Card otherPair2 = new Card(3, "Clubs");
        Card otherPair3 = new Card(8, "Spades");
        Card otherPair4 = new Card(8, "Diamonds");
        Card otherPair5 = new Card(4, "Diamonds");

        hand.addCard(thisTP1);
        hand.addCard(thisTP2);
        hand.addCard(thisTP3);
        hand.addCard(thisTP4);
        hand.addCard(thisTP5);

        other.addCard(other1);
        other.addCard(other2);
        other.addCard(other3);
        other.addCard(other4);
        other.addCard(other5);

        otherP.addCard(otherP1);
        otherP.addCard(otherP2);
        otherP.addCard(otherP3);
        otherP.addCard(otherP4);
        otherP.addCard(otherP5);

        otherPair.addCard(otherPair1);
        otherPair.addCard(otherPair2);
        otherPair.addCard(otherPair3);
        otherPair.addCard(otherPair4);
        otherPair.addCard(otherPair5);

        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + other.toString() + "This hand is worth MORE than Other hand", 1, hand.compareTo(other));
        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + otherP.toString() + "This hand is worth LESS than Other hand", -1, hand.compareTo(otherP));
        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + otherPair.toString() + "This hand is worth the SAME as Other hand", 0, hand.compareTo(otherPair));
    }

    public static void testHighCardHands(){
        proj3.Testing.testSection("Testing which High Card Hand Wins");

        ArrayList<Card> handList = new ArrayList<>();
        PokerHand hand = new PokerHand(handList);
        ArrayList<Card> otherList = new ArrayList<>();
        PokerHand other = new PokerHand(otherList);
        ArrayList<Card> otherHCList = new ArrayList<>();
        PokerHand otherHC = new PokerHand(otherHCList);
        ArrayList<Card> otherHighCardList = new ArrayList<>();
        PokerHand otherHighCard = new PokerHand(otherHighCardList);

        Card thisHC1 = new Card(3, "Spades");
        Card thisHC2 = new Card(5, "Diamonds");
        Card thisHC3 = new Card(8, "Spades");
        Card thisHC4 = new Card(13, "Hearts");
        Card thisHC5 = new Card(10, "Clubs");

        Card other1 = new Card(6, "Spades");
        Card other2 = new Card(10, "Hearts");
        Card other3 = new Card(9, "Spades");
        Card other4 = new Card(4, "Diamonds");
        Card other5 = new Card(8, "Hearts");

        Card otherHC1 = new Card(2, "Clubs");
        Card otherHC2 = new Card(3, "Hearts");
        Card otherHC3 = new Card(9, "Spades");
        Card otherHC4 = new Card(14, "Diamonds");
        Card otherHC5 = new Card(6, "Clubs");

        Card otherHighCard1 = new Card(13, "Clubs");
        Card otherHighCard2 = new Card(3, "Clubs");
        Card otherHighCard3 = new Card(8, "Spades");
        Card otherHighCard4 = new Card(5, "Diamonds");
        Card otherHighCard5 = new Card(10, "Diamonds");

        hand.addCard(thisHC1);
        hand.addCard(thisHC2);
        hand.addCard(thisHC3);
        hand.addCard(thisHC4);
        hand.addCard(thisHC5);

        other.addCard(other1);
        other.addCard(other2);
        other.addCard(other3);
        other.addCard(other4);
        other.addCard(other5);

        otherHC.addCard(otherHC1);
        otherHC.addCard(otherHC2);
        otherHC.addCard(otherHC3);
        otherHC.addCard(otherHC4);
        otherHC.addCard(otherHC5);

        otherHighCard.addCard(otherHighCard1);
        otherHighCard.addCard(otherHighCard2);
        otherHighCard.addCard(otherHighCard3);
        otherHighCard.addCard(otherHighCard4);
        otherHighCard.addCard(otherHighCard5);

        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + other.toString() + "This hand is worth MORE than Other hand", 1, hand.compareTo(other));
        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + otherHC.toString() + "This hand is worth LESS than Other hand", -1, hand.compareTo(otherHC));
        proj3.Testing.assertEquals("This Hand:\n" + hand.toString() + "\nOther Hand:\n" + otherHighCard.toString() + "This hand is worth the SAME as Other hand", 0, hand.compareTo(otherHighCard));
    }

    public static void testDeck(){
        proj3.Testing.setVerbose(true);
        proj3.Testing.testSection("Testing Deck Methods");

        Deck d = new Deck();

        proj3.Testing.assertFalse("Deck is empty", false);

        proj3.Testing.assertEquals("Size of deck before deal", 52, d.size());
        d.deal();
        proj3.Testing.assertEquals("Size of deck after deal", 51, d.size());
        d.deal();
        proj3.Testing.assertEquals("Size of deck after two dealt cards", 50, d.size());

        d.gather();
        proj3.Testing.assertEquals("Size of deck after cards gathered", 52, d.size());

    }
    public static void testCard(){
        proj3.Testing.setVerbose(true);
        proj3.Testing.testSection("Testing Card Methods");

        Card c = new Card(10, "Diamonds");

        proj3.Testing.assertEquals(c + "\nGet card rank", 10, c.getRank());
        proj3.Testing.assertEquals(c + "\nGet card suit", "Diamonds", c.getSuit());
    }
}
