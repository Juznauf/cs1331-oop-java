### Intro to Java

#### Values and variables

- Variables must be declared before use. 
    - `float twoThirds;`
    - float is the variables type. twoThirds is the variable name
- can combine declaration and assignment 
    - `float twoThirds = 2/3;`
- legal assignments 
    - ```java
        int x = 1; // int literal
        float y = 3.14159f; // float literal
        double z = 3.1415; // double literal 
        boolean thisSentence = false; // boolean literal
        String goedel = "incomplete"; // String literal
        ```
- illegal assignments
    - ```java
        int x = 1.0; // 1.0 is a double value
        float y = 3.14159; // 3.14159 is a double value 
        boolean thisSentence = 1; // 1 is an int value
        ```

- type conversions
    - ```java
        public class Expressions {
        public static void main(String[] args){
            float twoThirds = 2/3;
            System.out.println(twoThirds);
            }
        }
        ```
    - output of this is `0.0`
    - twoThirds is a float, so it can hold fractioanl values 
    - but 2 and 3 are literal int values
    - so 2/3 performed integer division, resulting in a value of 0
    - float variables can hold integer values, so Java performed automatic conversion to float upon assignment to twoThirds 
    - there is an implicit widening conversion 
    - float is wider than int because all int are also floating point values
    - to perform a narrowing conversion, you must explicitly cast the value
    - `int threeFourths = 3.0/4.0;` this wont compile because an int cant hold a fractional value; converting may cause a loss of precision, we have to cast the double to an int first; `int threeFourths = (int) (3.0/4.0);`

- floating point primitive types
    - floating point types should never be used for precise values, such as currency. For that, you need to use the java.math.Big.Decimal class instead. Numbers and Strings cover BigDecimal and other useful classes provided by the Java platform 


- shortcut assigments
    - pre-incrementL variable incremented before used in expression 
    - ```java
        int x =1 ;
        int y = ++x;
        // x == 2, y ==2;
        ```
    - post increment, variable incremented after used in expression
    - ```java
        int x = 1;
        int y = x++;
        // x == 2, y == 1;
        ```
    
- Strings
    - String is a class
    - because Strings are objects, beware of null references;
        ```java
            String boom = null;
            int aPosInBoom = boom.indexOf("a");
        ```
    - this will raise an error at runtime ```Exception in thread "main" java.lang.NullPointerException at FinalTarget.main(FinalTarget.java:7)```

- every powerfule language has three mechanisms for combining simple ideas to form more complex ideas:
    - primitive expressions, which represent the simplest entities the language is concerned with,
        - values are the atoms of programs
    - means of combination, by which compound elements are built from simpler ones, and 
        - programs combine and manipulate values 
    - means of abstrations, by which compound elements can be named and manipulated as units
        - variables are the simplest forms of abstractions naming values
