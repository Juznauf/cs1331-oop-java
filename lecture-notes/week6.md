### Inheritance 

#### Subclasses 

- the `extends` clause names the direct superclass of the current class
- Consider the super class Employee1 and the subclass HourlyEmployee1
    - ```java
        public class Employee1 {
            private String name;
            private Date hireDate;
            public Employee1(String aName, Date aHireDate) {
                disallowNullArguments(aName, aHireDate);
                name = aName;
                hireDate = aHireDate;
            }
            public String getName() {
                return name;
                }
            public Date getHireDate() {
                return hireDate;
                } // and toString(), etc. ...
        }
        ```
    - ```java
        public class HourlyEmployee extends Employee {
            public HourlyEmployee(String aName, Date aHireDate) {
                super(aName, aHireDate);
            }
        }
        ```

    - the subclass cannot access private members of the superclass
    - the super call in the constructor calls the superclass constructor to init the subclass instances
    - the subclass extends the concept of the superclass

#### Super substleties

- If using `super` it must be the first statement in a constructor 
- If not present, and the superclass has a no-arg constructor, `super()`will implicitly be the first statement in any constructor
- If there is a no no-arg constructor in a superclass ( for eg, if the superclass defines other constructors without explicitly defining a no-arg constructor), then subclass constructors must explicitly include a `super` call

#### Access modifiers 

<table>
    <tr style="border:solid">
        <td>Modifier<td>
        <td>Class<td>
        <td>Package<td>
        <td>Subclass<td>
        <td>World<td>
    </tr>
    <tr>
        <td>public<td>
        <td>Y<td>
        <td>Y<td>
        <td>Y<td>
        <td>Y<td>
    </tr>
    <tr>
        <td>protected<td>
        <td>Y<td>
        <td>Y<td>
        <td>Y<td>
        <td>N<td>
    </tr>
    <tr>
        <td>no modifier<td>
        <td>Y<td>
        <td>Y<td>
        <td>N<td>
        <td>N<td>
    </tr>
    <tr>
        <td>private<td>
        <td>Y<td>
        <td>N<td>
        <td>N<td>
        <td>N<td>
    </tr>
</table>


- Every member has an access level.
- `private` members of superclasses are present in subclasses, but can't be directly accessed. 

#### overriding methods 
- overriding a method means providing a new definition of a superclass method in a subclass. We've been doing this all along with `toString` and `equals` which are defined in `java.lang.Object`, the highest superclass of all Java classes.
- We override these methods as the default of toString just prints the class name and hash code (whicc is the memory address by default)
- the default of `equals` just compares object references, what we want is value equality

#### @Override annotation
- The optional `@Override annotation` informs the compiler that the element is meant to override an element declared in a superclass
- Now if the method doesnt actually override then the compiler will inform us (good for checking)
- ```java
    public class Employee2 {
    // ...
        @Override
        public String toString() {
            return name + "; Hire Date: " + hireDate;
        }
    }   
    ```


#### Explicit Constructor invocation with this

- If we wanted to have default values for hourly wages and monthly hours, we can provide an alternate constuctor that delegates to our main constructor with `this`
- ```java
    public final class HourlyEmployee3 extends Employee3 {
    /**
    * Constructs an HourlyEmployee with hourly wage of 20 and
    * monthly hours of 160.
    */
    public HourlyEmployee3(String aName, Date aHireDate) {
        this(aName, aHireDate, 20.00, 160.0);
        }
    public HourlyEmployee3(String aName, Date aHireDate,
        double anHourlyWage, double aMonthlyHours) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anHourlyWage, aMonthlyHours);
        hourlyWage = anHourlyWage;
        monthlyHours = aMonthlyHours;
        }
    // ...
    }
    ```
#### this and super

- If present, an explicit constructor call must be the first statement in the constructor 
- Cant have both `super` and `this` call in a constructor
- A constructor with a `this` call must call, either directly or indirectly, a constructor with a `super` call (implicit or explicit)
- Can set multiple instance flow 
- ```java
    public final class HourlyEmployee3 extends Employee3 {
        public HourlyEmployee3(String aName, Date aHireDate) {
            this(aName, aHireDate, 20.00);
        }
        public HourlyEmployee3(String aName, Date aHireDate, double anHourlyWage) {
            this(aName, aHireDate, anHourlyWage, 160.0);
        }
        public HourlyEmployee3(String aName, Date aHireDate,
            double anHourlyWage, double aMonthlyHours) {
            super(aName, aHireDate);
            disallowZeroesAndNegatives(anHourlyWage, aMonthlyHours);
            hourlyWage = anHourlyWage;
            monthlyHours = aMonthlyHours;
        }
    // ...
    }
    ```

#### the liskov substitution principle

- Subtypes must be substitutable for their supertypes
- The Object-oriented `is-a` relationship is about behavior. Squares setWidth and setHeight methods dont behave the way a Rectangles setWidth and setHeight methods are expected to behave, so a Square doesn't fit the object oriented `is-a` Rectangle definition. 


#### conforming to LSP: design by contract
- Author of a class specifies the behavior of each method in terms of preconditions and postconditions. Subclasses must follow two rules;
    - preconditions of overriden methods must be equal to or weaker than those of the superclass (enforces or assumes no more than the constraints of the superclass method)
    - postconditions of overriden methods must be equal to or greater than those of the superclass (enforces all of the constraints of the superclass method and possibly more)
    - hence square doesnt satisfy the object oriented is-a relationship to rectangle

#### LSP Conforming 2D shapes

- ```java 
    public interface 2dShape {
        double area();
    }
    public class Rectangle implements 2dShape {
        public void setWidth(double w) { ... }
        public void setHeight(double h) { ... }
        public double area() {
            return width * height;
        }
    }
    public class Square implements 2dShape {
        public void setSide(double w) { ... }
        public double area() {
            return side * side;
        }
    }
    ```

- An interface represents an object oriented type: a set of public methods (declarations, not definitions) that any object of the type supports
- Cannot instantiate interfaces. Must define a class that implements the interface in order to use it. Implementing an interface is similar to extending a class. but uses the `implementing` keyword
- Now square is-a 2dshape

#### Interfaces define a type 
- this means that any object of type 2dShape supports the area method
- two kinds of inheritance: `implementation` and `interface` inheritance
    - extending a class means inheriting both the interface and the implementation of the superclass 
    - implementing an interface means inheriting only the interface, that is, the public methods 

#### Default methods in interfaces 
- Interface methods can have default method inplementations. default methods can only reference local variables and static variables defined in the interface or any superinterfaces
- ```java
    public interface Destiny {
        default public String getName() {
            return "Child";
        }
        default public String say() {
            return "my " + getName();
        }
    }
    ```

#### Conflicting methods from interfaces and superclasses
- superclasses win 
    - ```java
        public abstract class AbstractPerson {
            private String name;
            public AbstractPerson(String name) {
                this.name = name;
            }
            public String getName() {
                return name;
            }
        }
        ```
- this is ok, the `getName` method from `AbstractPerson` wins
    - ```java 
        public class GoodPerson extends AbstractPerson implements Destiny {
            public GoodPerson(String name) {
                super(name);
            }
        }
        ```
    
    
#### Conflicting default methods from interfaces 
- if interfaces clash, they wont compile
    - ```java
        public interface Destiny {
            default public String getName() {
            return "Child";
            } // ...
        }
        public interface Maggot {
            default public String getName() {
            return "Robert Paulson";
            }
        }
        ```
- so this wont compile
    - ```java
        public class BadPerson implements Destiny, Maggot {
            // Won’t compile -- Destiny and Maggot both define default getName methods
        }
        ```

#### Programming excercise 
to get some practice writing classes that use inheritance, write:
    - a class named `Animal` with:
    - a private instance variable `name`, with a public getter and setter. (Note. name is a name of an animal, not the species)
    - a single constructor that takes the name of the Animal 
    - a public instance method `speak` that returns a String representation of the sound it makes.
    - a class named `Dog` that extends `animal` and specializes the speak method appropriately
    - A `kennel` class with
    - a private instance variable dogs that is an array of Dog 
    - a single constructor that takes a variable number of single Dog parameters and initializes the dogs instance variable with the constructors actual parameters
    - a method `soundOff()` that prints to STDOUT (System.out) one line for each Dog in dogs that reads "[dog name] says [ouput of speak method]!",   



### Polymorphism
- The idea of polymorphism is dynamic method binding 


#### Class hierarchies
- UML class hierarchies depict the superclass-subclass relationships between families of related classes
    - Employee is the superclass of HourlyEmployee and SalariedEmployee 
    - Both subclass have `monthlyPay` but this is not found in the superclass hence these methods are not polymorphic

#### Company spec 
- before making the method polymorphic, we need an application to demonstrate why doing so is useful. Lets design a company class with the following specs: 
    - A company4 ahs exactly 9 employees (because no dynamic arrays yet)
    - a company calculates its monthly payroll by adding up the monthly pay of each of its employees 
    - a company can have any mix of hourly and salaried employees
        - this motivates the use of of polymorphism 

- For this to work, we need to maintain two seperate list for each type of employees, we then need to parrelize the computations for each type, it also makes it harder if we wanted to add a third type of employee, hence we need a more general way that can scale. In order to do this we need to update the design of our Employee class hierarchy with abstract classes

#### Abstract classes 
- we need `Employee` to declare a monthlyPay method for subclasses to define. Since we dont have a general definition for `monthlyPay` suitable for `Employee`, `Employee` will need to be abstract.

- An abstract class
    - cannot be instantiated
    - may contain zero or more abstract methods and 
    - subclasses must either provide an implementation for abstract methods, or be declared abstract themselves
    - Employee4 and its monthlyPay method are abstract 
    - `monthlyPay` is polymorphic because it is overriden in subclasses
    - Example for our companyclass
        - ```java
            public class Company4 {
                private Employee4[] employees;
                public double monthlyPayroll() {
                    double payroll = 0.0;
                    for (Employee4 employee: employees) {
                        payroll += employees.monthlyPay();
                    }
                    return payroll;
                }
            }
            ```
    
    - The static type of the elements of employees is Employee4
    - The dynamic type can be any subclass of Employee4 in this case they are all SalariedEmployee4 and HourlyEmployee4
    - when a method is invoked on an object, the method of the dynamic (run-time) type is used, no matter what the static (compile-time) type is 
    - so though the static types of employees is Employee, the monthlyPay methods invoked on them are the ones defined in SalariedEmployee4 and HourlyEmployee4

#### Refactoring duplicate code in a class hierarchy
- ```java
    private void disallowZeroesAndNegatives(double ... args) {
        boolean shouldThrowException = false;
        String nonPositives = "";
        for (double arg: args) {
            if (arg <= 0.0) {
                shouldThrowException = true;
                nonPositives += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "Following arguments were <= 0: " + nonPositives;
            throw new IllegalArgumentException(msg);
        }
    }```

- this method is duplicated in the subclasses 
- move the definition into the superclass

- private members of a superclass are effectively invisible to subclasses. 
- to make a member accessible to subclasses, use protected:
- ```java 
    public abstract class Employee5 {
        protected void disallowZeroesAndNegatives(double ... args) {
            // ...
        }
        // ...
    }
    ```
- protected members are accessible to subclasses and other classes in the same package and can be overriden in subclasses
- protected members provide encapsulation within a class hierarchy and package, private provides encapsulation within a single class. 
-
#### Implementation inheritance hinders reuse 
- recall the `disallowZeroesAndNegatives` method
- there is nothing about this method that is specific to Employees
- this method could be useful in other classes that are not part of the employee class hierarchy
- since its protected, it cant be used outside of the Employee class hierarchy or package
- In software engineering terms, we say the code in employee lacks cohesion, it has parts that arent part of the employee concept. Such a design hinders reuse.


#### Favor composition over inheritance 

- if we moved these protected methods into a seperate class we can use them anywhere

#### closing thoughts on polymorphism 
- weve now seen two kinds of polymorphism 
    - ad hoc polymorphism (method overloading) and 
    - subtype polymorphism (overriding methods in subtypes)
- subtype polymorphism is core feature of OOP. Polymorphism makes it possible to reuse concepts in a way that makes programs extensible without requiring rewriting existing code (open closed principle)


#### OO design

- With encapsulation, inheritance, and polymorphism we have all the language features we need to employ three important object design principles
- *S*ingle responsibility principle: a module should only contain code related to the definition of the module
    - Employee classes contain only employee related code, validation code is in utility class
- *O*pen closed principle: open for extension, closed for modification 
    - Can add new Employee subclasses without changing other classes in the Employee hierarchy or classes that use Employees, such as Company
- *L*iskov substitution principle: instances of subtypes should be substitutable wherever instances of supertypes are expected 
    - A square is not a rectangle in an OO sense, but both are 2-D shapes





