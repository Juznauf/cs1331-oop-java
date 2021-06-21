### Classes


#### Example of creating usable ADT
- check `Card.java`
- We have encapsulation by setting private variables and using public setter methods

#### Dealing with the this keyword
- Every instance of a class has a `this` reference which refers to the instance on which a method is being called.
- `this.rank` refers to the rank instance variable for the Card instance on which setRank is being called
- `this.rank` is different from the `local` rank variable that is a parameter to the `setRank` method 



#### Class invariant
- A condition that must hold for all instances of a class in order for instances of the class to be considered valid.
- Invariants for Card class:
    - rank must be one of `{"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"}`
    - suit must be one of `{"diamonds", "clubs", "hearts", "spades"}`

#### Object initialization
- two ways to initialize the instance variables of an object 
    - declaration point init
        - ```java
            public class Card {
                private String rank = "2";
            }
            ```
    - constructors 
        - ```java
            public class Card {
                public Card() {
                    rank = "2";
                }
            }
        - A constructor is what's being called when you invoke the operator `new`.


#### Initialization style
- since we didnt write our own constructor, Java provided a default no-arg constructor
- we have to call the setters on a `Card` instance before we have a valid object
- in general its poor style to require a multi-step initialization
    - after new Card() is called, instance variables have useless defaults.
    - client programmer must remember to call setter methods
    - often there can be order depedencies that we don't want to burden client programmers with
- if we write a constructor, java wont provide a default no-arg constructor
- if we want a no-arg constructor in addition to other constructors, we must write it explicitly (we can have it set to null first)


#### Valid ranks and suits and static members

- recall that in order to set validations we used the API
    - ```java
        public final String[] VALID_RANKS = {"some values"};
        ```

- by using the above API, we are creating a **seperate instance** of `VALID_RANKS` for **each** instance of our Card class

- `static` members are shared wwith all instances of a class
    - ```java
        public static final String[] VALID_RANKS = {"some values"};
        ```
- given the above declarations, each instance shares a single copy of VALID_RANKS and a single copy of VALID_SUITS. Since theyre final, we can safely make them public so clients of our card class can use them. They also cannot be modified


#### Immutable Objects 
- Card objects dont change. We can model this behavior by removing the setters and putting the initialization code in the constructor (or making the setters private and calling them from the constructor)
    - ```java
        public Card(String aRank, String aSuit) {
            if (!isValidRank(aRank)) {
                System.out.println(aRank + " is not a valid rank.");
                System.exit(0);
            }
            rank = aRank; /* use aRank to avoid shaddowing the global variable and to also avoid using
            the this keyword */

            if (!isValidSuit(aSuit)) {
                System.out.println(aSuit + " is not a valid suit.");
                System.exit(0);
            }
            suit = aSuit;
        }
        ```

#### Enums

- learn the role of the `equals()` method 
- implement the `enum s` for type checking instead of run time validity checks
- ```java
        public enum Rank {
        TWO , THREE , FOUR , FIVE , SIX , SEVEN , EIGHT , NINE , TEN , JACK ,
            QUEEN , KING , ACE
    }
        public enum Suit {
        TWO , THREE , FOUR , FIVE , SIX , SEVEN , EIGHT , NINE , TEN , JACK ,
            QUEEN , KING , ACE
    }
    ```

#### Equality 
- For reference types:
    - `==` means identity equality (aliasing testing)
    - `equals(Object)` test value equality, as defined by the class.
- For primitive types `==` means value equality and is the only equality test

- Given our finished Card class with a properly implemented equals
    - ```java
        public boolean equals(Object other) {
            // example of definition of equals for the Card class
            if (null == other) { return false; }
            if (this == other) { return true; }
            if (!(other instanceof Card)) { return false; }
            Card that = (Card) other; // cast to type card
            return this.rank.equals(that.rank) && 
                this.suit.equals(that.suit);
        }
        ```

#### Exercise: Treating People as Objects
- Using the encapsulation techniques we just learned, write a class named `Person` with a name field of type `String` and an age field of type `int`. 
- Write a suitable `toString` method for your Person class
- Add a main method that:
    - creates an array of Person objects
    - Iterates through the array and prints each Person object who's age is greater than 21

#### Exercise: Vector2
- write an immutable `Vector2` class with:
    - two public final instance variables for the two components, `x` and `y` 
    - a single constructor that takes two double params to initialize `x` and `y`
    - a `toString()` method that returns a `String` representation of a `Vector2` that looks like `(1,2)`
    - a `plus` method that takes another `Vector2` parameter and returns the `Vector2` result of adding this `Vector2` to the argument `Vector2`. vector addition is defined as `(x_1, y_1) + (x_2, y_2) = (x_1 + x_2, y_1 + y_2)`
    - a `minus` method that takes another `Vector2` parameter and returns the vector2 result of subtracting the argument vector2 object from this vector2. Vector substraction is defined as `(x_1, y_1) - (x_2, y_2) = (x_1 - x_2, y_1 - y_2)`
    - a `dot` method that takes another vector2 parameter and returned the double dot product of this vector2 and the argument vector2. Dot product is defined as `(x_1, y_1) . (x_2, y_2) = (x_1 . x_2) + (y_1 . y_2)`
        