import java.util.Arrays;

public class Dealer {

    public static void main(String[] args) {
        // Card c = new Card("queen", "hearts");
        // Card c = new Card("queen", "spades");
        // Card c = new Card(Rank.ACE, Suit.SPADES);
        // c.rank = "ace"; // cannot access the private var
        // c.suit = "base";// cannot access the private var
        // c.setRank("ace");
        // c.setSuit("base");
        // System.out.println(c);
        // c.setSuit("hello");
        // System.out.println(Arrays.toString(d.VALID_RANKS));
        // System.out.println(Arrays.toString(Card.VALID_RANKS));

        Card c1 = new Card(Rank.ACE, Suit.SPADES);
        Card c2 = new Card(Rank.ACE, Suit.SPADES);
        Card c3 = c1;
        System.out.println("c1 == c2 returns " + (c1 == c2 )); // will return false as for non prim check reference only
        System.out.println("c1.equals(c2) returns " + c1.equals(c2)) ;
        System.out.println("c1 == c3 returns " + ( c1 == c3 )); // will return true as same reference
        System.out.println("c1.equals(c3) returns " + c1.equals(c3)) ;
    }
}