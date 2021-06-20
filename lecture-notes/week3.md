### Data Abstraction 

#### Data abstraction
- An abstraction captures the essence of a concept by ignoreing details that are irrelevant to a particular application.
    - process abstraction - functions, methods
    - data abstraction - encapsulation of data with the operations defined on the data
    - a particular data abstraction is called an abstract data type

- In each case an abstraction hides details -- details of a process or details of a data structure 
- Abstraction is selective ignorance -- Andrew Koenig

#### A complex Number ADT
- ADT: complex data: 
    - real: **double** the real part of a complex number
    - imaginary: **double** the imaginary part of a complex number

- operations:
    - new - construct a new complex number
    - plus - add one complex number to another, yielding a new complex number

- An ADT is abstract because the data and operations of the ADT are declared independently of how they are implemented. We say that an ADT encapsulates the data and the operations on the data.

#### Data abstractions with classes
- java provides language support for defining ADTs in the form of classes.
- a class is a blueprint for objects. A class definition contains
    - instance variables, aka member variables or fields -- the state, or data of an object
    - methods, aka member functions or messages -- the operations defined on objects of the class
- we instantiate or construct an object from a class

#### complex number ADT in java

- ```java
    public class Complex {
        // these are the data of the ADT
        
        private double real; // declare global variables
        private double imaginary; // declare global variables

        // these are the operations of the ADT

        public Complex(double aReal, double anImaginary) {
            // this is the ADT constructor
            real = aReal;
            imaginary = anImaginary;
        }

        public Complex plus(Complex other) {
            double resultReal = this.real + other.real;
            double resultImaginary = this.imaginary + other.imaginary;
            return new Complex(resultReal, resultImaginary);
        }
    }
    ```


#### Reference variables
- Consider the following code
    - ```java
        Complex a = new Complex(1.0, 2.0);
        Complex b = new Complex(3.0, 4.0);
        Complex c = a.plus(b);
        ```
    - a,b,c are reference variables of type complex. Reference variables have one of two values
        - the address of an object in memory (in this case an instance of complex), or 
        - null, meaning the variable reference nothing


#### Using the complex class
- Users or clients of the `Complex` class do not need to be concerned with `Complex` implementation.
- Clients of the class only need to be concerned with its interface, or API, the public methods of the class

