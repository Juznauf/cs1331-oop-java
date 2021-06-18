#### Programs and methods 

- The main method 
    - In order to make a class executable with the java command, it must have a main method 
    - public means method can be called from outside the class 
    - static means the method can be called without instantianting an object of the class
    - void is the return type. In particular, main returns nothing

- Local variables
    - method params and var declared inside the method are local to the method, invisible outside the method. Local variables "shadow" variables of the same name in an enclosing scope
    - ```java
        public class Methods {
            // Note that static variables cannot appear inside methods
            static String message = "Global message.";
            static int a = 5;

            public static int add(int a, int b) {
                String message = "Adding" + a + " and " + b;
                System.out.println(message);
                return a + b;   
            }
        }
        ```


#### Control structures

- Structured programming
    - all algos expressed by 
        - sequence - one statement after another
        - selection - conditional execution (not conditional jumping)
        - iteration - loops

- switch expressions
    - ```java
        switch (expr) {
            case 1:
                //executed only when case1 holds 
                break;
            case 2: 
                //executed only when case 2 holds 
            default:
                //executed only when other cases dont hold
        }
        ```


- Java loop/iteration structures
    - while loop
    - do-while loop
    - for iteration statement

    - while loops are pre-test loops: the loop condition is tested before the loop body is executed
        - ```java
            while (condition){
                // loop body executes as long as condition is true
            }
            ```

    - do-while loops are post-test loops: the loop condition is tested after the loop body is executed
        - ```java
            do {
                // loop body executes as long as condition is true

            } while (condition)
            ```
    - the general statement for loops is 
        - ```java
            for(initializer; condition; update){
                // body executed as long as condition is true
            }
            ```
        - initializer is a statement, condition is a boolean expression, update is a statement

    
    - Multiple loop variables
        - can have multiple loop indexes seperated by commas:
        - ```java
            String mystery = "menfafa", solved = "" ;
            int len = mystery.length();
            for (int i = 0, j = len - 1; i<len/2; ++i, --j){
                solved = solved + mystery.charAt(i) + mystery.charAt(j);
            }
            ```
        - this is one loop running
    
    - Loop gotchas
        - Beware of common extra semicolon syntax error:
        - ```java
            for (int i = 0;i <10; ++i); // semicolon here ends the statement
                print(meow); // this will only execute once, not 10 times
                ```
    
    - for statement subtleties
        - Better to declare loop index in for to limit its scope; we prefer
            - ```java
                for (int i = 0; i < 10; ++i)
                ```
            - than this
            - ```java
                int i; // this is bad as loop index variable is visible outside loop
                for (i = 0; i < 10; ++i)
                ```

    - Infinite loops
        - with for:
            - ```java
                for (;;){
                    //ever
                }
                ```
        - with while:
            - ```java
                while (true) {
                    // forever
                }
                ```


    - Breaking out of a while loop
        - Use the structured programming method to break out
        - ```java
            boolean shouldContinue = true;
            while (shouldContinue){
                System.out.println("Enter some input (exit to quit):");
                String input = System.console().readLine();
                if (input.equalsIgnoreCase("exit")){
                    shouldContinue = false;
                } else {
                    doSomethingWithInput(input);
                }
            }
            ```


#### Basic Input/Output 

- `System.out.printf`
    - This command takes a format string and any number of additional arguments, and prints the result of inserting the additional arguments into the format string according to the format specifiers in the format string 
        - The format string can contain other text in addition to format specifiers
        - Each format specifier begins with `%` and ends with a <i>conversion character</i>
        - Think of each format specifier as defining a field into which a value is inserted

- Number formatting
    - If you need to print currency amounts and you want to internationalize your code, use a CurrencyFormatter `NumberFormat`.
    - ```java
        NumberFormat us = NumberFormat.getCurrencyInstance();
        System.out.println(us.format(3.14));

        NumberFormat de = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(de.format(3.14));
        ```
- Packages and Imports
    - All java classes are organised in packages
    - We've been using the default package by not specifying
    - To use a class from a different package, you must either fully qualify it every time you use it, or import it
    - See CurrencyFormatting.java for the example
    
- Console input 
    - we can read input from console using the Scanner class
        - ```java
            import java.util.Scanner;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter your 3 test scores, seperated by spaces.");
            exam1 = keyboard.nextInt();
            exam2 = keyboard.nextInt();
            exam3 = keyboard.nextInt();
            examAvg = (exam1 + exam2 + exam3) / 3.0; //3.0 as we do not want to do integer division
            System.out.printf("Your exam average is %.1f%n", examAvg); 
            ```
- Basic file input using `scanner`
    - Instead of system.in, we specify the file name
    - ```java
        Scanner gradeFile = new Scanner(new File("grades.txt"));
        ```
    - Scanner hasnext method tells us if theres more input to consume
    - ```java
        Scanner fileScanner = new Scanner(new File("ScannerFun.java"));
        while (fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            // do something with line 
        }
        ```
    - check `CourseAverage.java` for more info on scanning files

- Basic File output using `PrintStream` 
    - `System.out` is initialized to use the programs `stdout` file descriptor, which is the **console** if output hasnt been redirected.
    - We can create `PrintStreams` with other files or `OutputStreams` and write to them just like weve been writing to the console.
    - ```java
        PrintStream outFile = new PrintStream(new File("somefile.txt"));
        outFile.println(...);
        ```
    - As this procedure can cause errors to be thrown at runtime, errors such as file not found must be handled in the program, see `SampleWriter.java` for more info 




- Programming exercise
    - Write a program that 
        - reads all the lines of a file whose name is given at the command line
        - creates a new file whose file name is the original file name with "-uppercase" appended to the base name(base name is the prefix before the .java), and
        - writes all the lines of the original file to the new file but in uppercase letters
    - to do this we need to use the string methods `lastIndexOf, substring, toUppercase` in the java API
    - as file constructors throw a FileNotFoundException, we need to handle this 
    - for now use the syntax
        - ```java
            public static void main(String[] args) throws Exception
            ```

    - for answers look at `ScannerWriter.java`

- Guess Number exercise
    - Introduction
        - We will practice 
            - writing simple console programs
            - using objects of classes from the Java standard library
            - basic console input/output and 
            - control structures 
    - Problem description 
        - You like guessing secret numbers and your friends wont play with you 
    - Solution description 
        - write a program that randomly chooses a secret number from 1 to 10 and asks the user to guess the number 
        - as long as the user guesses incorrectly or doesnt enter quit the program should keep asking the user to keep guessing 
            - if the user guesses the correct number then, before exiting, pring "Yay! You guessed it. It was N." Where N is the randomly chosen secret number 
            - if the user guesses incorrectly print "Higher" or "Lower" depending on whether the secret number is higher or lower
            - if the user quits before guessing correctly print "try again, it was N", where N is the randomly chosen number
        - Create the program `SecretGame.java` with proper javadocs 

    
        


#### Arrays

- java Arrays ()
    - are objects 
    - are dynamically allocated (eg. with operator new), and 
    - have a fixed number of elements of the same type 
- creating arrays
    - consider the expression:
        - ```java
            double[] scores = new double[5];
            ```
    - this declaration:
        - allocated a 5 element array
        - the 5 in the eg can be any expression that is unary promotable to an `int` 
        - stores the address of this new array in scores, and 
        - initializes each value to its default value (0 for numeric types, false for boolean types and null for references)
- array declarations 
    - the preceding array definition can be split into a declaration and initialization
    -  ```java
        double[] scores;
        scores = new double[5];
        ```
    - we can put the [] on the type or the variable. these two are equivalent
        - `double[] scores;`
        - `double scores[];`

- Mixed declarations
    - we can mix array and variable declarations when element type same as variable type. by using `double scores[], average;`
    - if we dont specify the size of the array then it will be dynamic

- Array objects 
    - after the definition
    - the indexes start from 0
    - size of array stored in a public final instance variable named length
    - ```java
        double[] scores = new double[5];
        scores[0] = 89;
        scores[1] = 89;
        scores[2] = 89;
        scores[3] = 89;
        scores[4] = 89;
        scores[scores.length - 1] = 99.2;
        // scores[scores.length] = 100; // this will raise an index error
        ```

- Initializing arrays
    - you can provide initial values for small arrays
    - ```java
        String[] validSuits = {"diamonds", "clubs", "hearts", "spades"};
        ```
    - `validSuits.length` is 4
    - `validSuits[1]` is clubs
    - you can also use a loop to initialize the values of an array:
        - ```java
            int[] squares = new int[5];
            for (int i = 0; i < squares.length; ++i) {
                squares[i] = i*i;
            }
            ```

- Traversing arrays
    - arrays and for go hand in hand 
    - ```java 
        double[] scores = new double[5];
        for (int i = 0; i <5; ++i) {
            System.out.printf("scores[%d] = %.2f%n", i , scores[i]);
        }
        ```
    - we can also use the enhanced for 
    - ```java
        for (double score: scores) {
            System.out.println(score);
        }
        ```
    - we read this as for each element in array 

- for versus for each
    - if we dont need the index, then use the enhanced for loop
    - enhanced for is cleaner

- Array creation gotchas 
    - because arrays are allocated dynamically, this will compile:
        - ```java
            double[] scores = new double[-5];
            ```
        - because the compiler only checks that -5 is an `int` expression, but the code will produce an error at run time

- Array access gotchas 
    - array access expressions are also merely type checked at compile time but are evaluated and checked for validity at run time. Negative indexes like `scores[-1] = 100;` will produce an error at run time.

- Array parameters 
    - weve already seen an array parameter:
    - ```java
        public static void main(String[] args)
        ```
    - we can use this array just like we use any other array
    - ```java
        public class Shout {
            public static void main(String[] args){
                for (String arg: args) {
                    System.out.print(arg.toUpperCase()+" ");
                }
                System.out.println();
            }
        }
        ```
- Variable arity parameters
    - the arity of a method is its number of formal parameters
    - the last parameter to a method may be a variable arity parameter, whose syntax is simply to add an ellipse (...) after the type name.
    - ```java 
        public static int max(int ... numbers)
        ```

- Accessing Var Args Parameters
    - Var args parameter is an array inside the method 
    - ```java
        public static int max(int ... numbers) {
            // find the max number in the numbers array 
            int max = numbers[0];
            for (int i = 1; i < numbers.length; ++i) {
                if (numbers[i] > max) max = number;
            }
            return max;
        }
        ```

- Multidimensional arrays 
    - you can create multidimensional arrays by adding additional square brackets for dimensions and sizes.
    - ```java 
        char[][] grid;
        ```
    - declares a 2-dimensional array of `char` 
    - as with one dimensional arrays, `char` is the element type 
    - each element of `grid`, which is indexed by two `int` expressions, is a `char` variable

- Initializing 2D arrays 
    - With `new`
    - ```java
        grid = new char[10][10];
        ```

- Initializing 2D arrays literally
    - ```java
        char[][] grid = {{' ', ' ',},
                         {' ', ' ',},
                         {' ', ' ',},
                         {' ', ' ',}}; 
                         ```
    - Example of a 4*2 array
    - We access the individual element by supplying 2 indices. eg `grid[2][2]`

- Traversing 2D arrays
    - Traverse 2D array by nesting loops. Key is to use the right `length`. row major traversal:
    - ```java 
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++row){
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }
        ```
    - check `TraverseArray.java` for example


- Exercise
    - Array utilities 
        - write a class called `ArrayUtil` with the following methods:
            - `public static int[] take(int n, int[] xs)` which returns a new array containing the first n elements of xs
            - `public static int[] drop(int n, int[] xs)` which returns a new array containing the last n elements of xs
            - `public static boolean equals(int[] xs, int[] ys)` which returns true if `xs.length == ys.length` and `xs[i] == ys[i] for 0 <=i<xs.length`
            - `public static int[] concat(int[] xs, int[] ys)` which returns a new array containing the elements of ys after the elements of xs 
            - `public static String toString(int[] xs)` 
            - `public static String toString(int[][] xs)`
            - `public static int[][] identity(int n)` which returns an n x n identity matrix 
