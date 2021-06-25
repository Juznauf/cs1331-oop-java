### The object superclass


#### Fitting classes into the java hierarchy

- java.lang.Object defines several methods that are designed to be overriden in subclass 
    - The method `equals(Object)` defines a notion of object equality, which is based on value
    - the method `hashCode` is very used together with equals(Object) in hashtables such as java.util.Hashmap
    - the method `toString` returns a String representation of the object 
    - the method `clone` is used to make a duplicate of an object (dont touch)
    - the method `finalize` is run just before an object is destroyed (dont touch )

- A class hierarchy is also sometimes called a framework


#### When to override the equals(object) method 

- When logical equality differs from object identity, as is the case for value classes like `Date`
- When classes dont implement instance control. eg., enum values
- When a suitable `equals(Object)` method is not provided by a superclass

#### How to Override the equals (Object) method 
- Obey the general contract of equals(Object), which says that equals(Object) defines an equivalence relation. So for non-null references, equals(Object) is 
    - reflexive - any object equals(Object) itself
    - symmetric - if a.equals(Object)(b) is true than b.equals(a) must be true
    - transitive - if a.equals(b) and b.equals(c) are true then a.equals(c) must be true
    - consistent - if a and b do not change between invocations of a.equals(b) or b.equals(a) then each invocation must return the same result
    - a.equals(null) must always return false

#### A recipe for implementing equals(Object) 
1. Check for reference equality with `==` (are we comparing to self?)
2. check that the other object is an `instanceof` this object's class
3. cast the other object to this type (guaranteed to work after instanceof test)
4. Check that each "significant" field in the other object equals(Object) the corresponding field in this object


#### An example equls(Object) Method 
Assume we have a Person class with a single name field
- ```java
    public boolean equals(Object other) {
    1: if (this == other) { return true; }
    2: if (!(other instanceof Person)) { return false; }
    3: Person that = (Person) other;
    4: return this.name.equals(that.name);
}```

- apply the recipe

#### Arrays and ArrayList

- Arrays are fixed size of any data types
- ArrayLists are dynamically-allocated collections of reference types 
- ArrayLists use arrays internally

#### Array list basics

- ```java
    // Create an ArrayList with operator new:
    ArrayList tasks = new ArrayList();
    // Add items with add():
    tasks.add("Eat");
    tasks.add("Sleep");
    tasks.add("Code");
    // Traverse with for-each loop:
    for (Object task: tasks) {
        System.out.println(task);
    }
    // Note that the for-each loop implicitly uses an iterator.
    ```

#### equals method and collections
- a class whose instances will be stored in a collection must have properly implemented equals(Object) method 
- the contains method in collections uses the equals(Object) method in the stored objects.


#### equals(Object) method examples
- in this simple class hierarchy, FoundPerson has a properly implemented equals(Object) method and LostPerson does not

- ```java
    abstract static class Person {
        public String name;
        public Person(String name) {
            this.name = name;
        }
    }
    static class LostPerson extends Person {
        public LostPerson(String name) { super(name); }
    }
    static class FoundPerson extends Person {
        public FoundPerson(String name) { super(name); }
        
        public boolean equals(Object other) {
            if (this == other) { return true; }
            if (!(other instanceof Person)) { return false; }
            return ((Person) other).name.equals(this.name);
        }
    }```

#### Override equivalence 
- two methods are override-equivalent if 
    - they have the same name
    - they have the same parameter lists
    - their return values are covariant
- these rules lead to a few pitfalls:
    - you cant define override-equivalent methods in the same class.
    - in subclasses its easy to accidentally overload a superclass method when you meant to override


#### Covariant returns 

- `covariantReturn` is covariant in Person and LostPerson because LostPerson is a `subtype` of Object;
- ```java
    abstract static class Person {
        public String name;
        public Person(String name) { this.name = name; }
        public Object covariantReturn() { return new Object(); }
    }
    static class LostPerson extends Person {
        public LostPerson(String name) { super(name); }
        @Override public LostPerson covariantReturn(){return this;}
    }```
- But SubLostPerson wont compile, because its `covarinatReturn` return type, Person is a supertype of LostPerson and not a subtype, would be okay to use sublostperson as a return type instead
- ```java
    static class SubLostPerson extends LostPerson {
        public SubLostPerson(String name) { super(name); }
        @Override public Person covariantReturn() {return this;}
    }```
    
#### Non covariant return 
- `NoncompilingPerson` wont compile because `int` is not a subtype of boolean and because return-type covariance only applies to reference types, not primitives.

- ```java
    static class NonCompilingPerson extends Person {
        public NonCompilingPerson(String name) { super(name); }
        /**
        * This method won’t compile because int is not a subtype of
        boolean.
        */
        public int equals(Object other) {
            if (this == other) return 1;
            if (!(other instanceof Person)) return 0;
            return ((Person) other).name.equals(this.name) ? 1 : 0;
        }
    }```
    
#### Accidental overloading 
- Its easy to make this mistake:
- ```java
    static class OverloadedPerson extends Person {
        public OverloadedPerson(String name) { super(name); }
    
        public boolean equals(OverloadedPerson other) {
            if (this == other) { return true; }
            if (!(other instanceof OverloadedPerson)) { return false; }
            return ((OverloadedPerson) other).name.equals(this.name);
        }
    }```    
- Signature of equals in Object is `public boolean equals(Object other)` - param type is Object
- In `OverloadedPerson` we have accidentally overloaded equals instead of overriding equals by making the parameter type OveloadedPerson. use the `@Override` annotation to avoid this





