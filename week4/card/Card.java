public class Card {
    // private String rank;
    // private String suit; 
    private Rank rank;
    private Suit suit; 



    // we create enum objects for type checking at compile time 
    // public enum Rank {
    //     TWO , THREE , FOUR , FIVE , SIX , SEVEN , EIGHT , NINE , TEN , JACK ,
    //         QUEEN , KING , ACE, SPADES
    // }
    // public enum Suit {
    //     TWO , THREE , FOUR , FIVE , SIX , SEVEN , EIGHT , NINE , TEN , JACK ,
    //         QUEEN , KING , ACE, SPADES
    // }
    // writing a constructor so that rank and suit do not default to null

    // public Card(String aRank, String aSuit) {
    public Card(Rank aRank, Suit aSuit) {
        // if (!isValidRank(aRank)) {
        //     System.out.println(aRank + " is not a valid rank.");
        //     System.exit(0);
        // }
        rank = aRank; /* use aRank to avoid shaddowing the global variable and to also avoid using
        the this keyword */

        // if (!isValidSuit(aSuit)) {
        //     System.out.println(aSuit + " is not a valid suit.");
        //     System.exit(0);
        // }
        suit = aSuit;
    }

    // implement the equals check which checks for value equality as defined by the class
    public boolean equals(Object other) {
        // example of definition of equals for the Card class
        if (null == other) { return false; }
        if (this == other) { return true; }
        if (!(other instanceof Card)) { return false; }
        Card that = (Card) other; // cast to type card
        return this.rank.equals(that.rank) && 
            this.suit.equals(that.suit);
    }

    // rank and suit are instance variables 
    // every instance of card has its own copy of instance variables
    // we protect the instance variables by making them private
    /* 
    every instance of a class has a this reference which refers to the instance on which a 
    method is being called 
    
    this.rank refers to the rank instance variable for the Card instance on which setRank is being called
    */
    // static means that this is shared across all instances 
    public static final String[] VALID_RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
    // public void setRank(String rank) {
    //     if (!isValidRank(rank)) {
    //         System.out.println(rank + " is not a valid rank.");
    //         System.exit(0);
    //     }
    //     this.rank = rank;
    // }
    private boolean isValidRank(String someRank) {
        return contains(VALID_RANKS, someRank);
    }
    private boolean contains(String[] array, String item) {
        for (String element: array) {
            if (element.equals(item)){
                return true;
            }
        }
        return false;
    }

    private static final String[] VALID_SUITS = {"diamonds", "clubs", "hearts", "spades"};
    // public void setSuit(String suit) {
    //     if (!isValidSuit(suit)) {
    //         System.out.println(suit + " is not a valid suit.");
    //         System.exit(0);
    //     }
    //     this.suit = suit;
    // }
    private boolean isValidSuit(String someSuit) {
        return contains(VALID_SUITS, someSuit);
    }
    
    public String toString() {
        // this will overload the string representation of the class object 
        return  rank + " of " + suit;
    }
    public static void main(String[] args) {
        // we can put a main method in any class
        // the main method is still able to see its private instance variables
        // Card swedishPop = new Card();
        // swedishPop.rank = "ace";
        // swedishPop.suit = "base";

        // Card handy = new Card();
        // handy.rank = "jack";
        // handy.suit = "all trades";
        // System.out.println(swedishPop);
        // System.out.println(handy);
    }
}