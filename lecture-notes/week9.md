### Java projects 

#### professional java projects 
- the classpath 
- separating source and compiler output 
- project directory layout 
- packages
- jar files
- using an IDE

#### The classpath 
- JDK tools (javac and java) look in the `CLASSPATH` for java classes. 
- to specify a classpath
    - set up an env var named CLASSPATH or 
    - specify a classpath on a per application basis by using the -cp switch. the classpath set with -cp overrides the CLASSPATH env var

- Dont use the CLASSPATH env var, if its already set clear with `$ unset CLASSPATH` or `C:> set CLASSPATH=`

#### Seperating src and compiler output 

- to reduce clutter, compile classes to another dir with -d option to javac
- ```shell
    $ mkdir classes
    $ javac -d classes HelloWorld.java
    $ ls classes/
    HelloWorld.class
    ```

- Specify classpath for an application with the -cp option to java 
- ```shell
    $ java -cp ./classes HelloWorld 
    Hello, world!
    ```

- Can also keep source files in the `src` directory and compile from there 


#### Project directory layout 
- source directories
    - `src/main/java` for Java source files
    - `src/main/resource` for resources that will go on the classpath, like image files 
    - `src/test/java` for unit test. note that unit tests will be in the same packages as the classes they test.
- output directories
    - `target/classes` for compiled Java.class files and resources copied from src/main/resources

- more details can be found at Maven Standard Directory Layout 


#### packages

- All professional Java projects organize their code in packages. The standard package naming scheme is to use reverse domain name, followed by project specific packages.
    - use `edu.gatech.cs1331` as a base package name 
    - a company application with one package would contain the following package statement at the top of all source files:
        - `package edu.gatech.cs1331.company;`


#### packages and directory layout 
- compiler output is organized according to packages 
- convention is to organize source directories by packages

So if we have a package edu.gatech.cs1331.company
    - source would go in `src/main/java/edu/gatech/cs1331/company`
    - compiled classes would go in `src/target/classes/edu/gatech/cs1331/company`


#### Jar files

- a jar archive, or jar file, is a zip formatted archive of a directory tree. Java uses jar files as a distribution format for libraries 
    - to create a jar file" `jar cf jar-file input-file(s)` 
    - to view the contents of a JAR file `jar tf jar-file`
    - to extract the contents of JAR file: `jar xff jar-file` or `unzip jar-file`
    - to run an application packaged as a JAR file (requires the main-class manifest header): `java -jar app.jar`



### Exceptions

#### exceptions 

an exception is 
    - an event that occurs during the execution of a program that disrupts the normal flow of instructions 
    - a violation of the semantic constraints of a program;
    - an object that you create when an exception occurs;

an exception is said to be 
    - thrown from the point it occured and 
    - caught at the point to which control is transferred
the basic syntax is 
    - ```
        try{
            // code that may throw an exception 
        } catch (Exception e) {
            // code that is executed if an exception is thrown in the try block
        }
        ```


#### using exceptions

- in this example 
    - ```java
        try {
            employees = initFromFile(new File(employeeDataFile));
        } catch (FileNotFoundException e) {
            System.out.println("Need an employee data file");
            System.out.println(e.getMessage());
        }```

#### java exception heirarchy
- most (checked) exceptions will subclass `Exception`
- most unchecked exceptions will subclass `RuntimeException`

#### Checked and unchecked exceptions 
- checked exceptions are subclasses of `Throwable` that are not subclasses of `RuntimeException` or `Error`. The compiler requires that checked exceptions declared in the throws clauses of methods are handled by:
    - a dynamically enclosing catch clause, or
    - a throws declaraton on the enclosing method or constructor 
- this rule is sometimes called catch or specify or catch or declare

- Unchecked exceptions (subclasses of `RuntimeException` or `Error`) are not subject to the catch or declare rule 

#### Catch or declare

- For example here are the two ways to deal with the FileNotFoundException thrown by initFromFile
    - catch:
        - ```java
            public Company(String employeeDataFile) {
                //..
                try {
                    employees = initFromFile(new File(employeeDataFile));
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }```
    - declare:
        - ```java
            public Company(String employeeDataFile) throws FileNotFoundException {
                initFromFile(new File(employeeDataFile));
            }```


#### taking advantage of unchecked exceptions

- weve been using the Scanner class without having to handle exceptions because its methods throw unchecked exceptions. But we can make use of these exceptions to make our code more robust.
    - ```java
        Scanner kbd = new Scanner(System.in);
        int number = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                System.out.print("Enter an integer: ");
                number = kbd.nextInt();
                // If nextInt() throws an exception, we won’t get here
                isValidInput = true;
            } catch (InputMismatchException e) {
                // InputMismatch is an unchecked exception
                // This nextLine() consumes the token that
                // nextInt() couldn’t translate to an int.
                String input = kbd.nextLine();
                System.out.println(input + " is not an integer.");
                System.out.println("Try again.");
            }
        }```


#### final thoughts
- use exceptions for their intended purpose; seperating your core logic from the code that handles exceptional conditions.
- use exceptions judiciously (not too many)
- think about how you handle exceptions:
    - have sound reasons for propagating exceptions you propagate
    - have sound reasons for catching exceptions where you catch them 
    - recover if you can 
    - store information in your exceptions to aid in debugging or error recovey by the user
    





