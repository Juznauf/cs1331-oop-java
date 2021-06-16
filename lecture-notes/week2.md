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
            for (int i = 0, j = len - 1; i<len/2, ++i, --j){
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

