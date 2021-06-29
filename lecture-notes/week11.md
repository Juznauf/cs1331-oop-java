### Collections Algorithms 

#### Collections.sort(`list<T>` list) 
- the collections framework includes algos that operate on collections. these algos are implemented as static methods of the Collections class. A good example is the (Overloaded) sort method: `public static <T extends Comparable<? super T>> void sort(List<T> list)`
- this method signature demonstrates how to declare a generic method: put a type parameter before the return type
    - this sort uses the "natural ordering" of the list, that is, the ordering defined by `Comparable`
    - `<? super T>` is a type bound. It means "some superclass of T"
- The type parameter `<T extends Comparable<? super T>>` means that the element type T or some superclass of T must implement Comparable.

#### The java.lang.Comparable Interface

- ```java
    public interface Comparable<T> {
        public int compareTo(T o);
    }
    ```

- `compareTo(T o)` Compares this object with the specified object for order. Returns 
    - a negative integer if this object is less than the other object, 
    - a zero if this object is equal to the other object or
    - a positive integer if this object is greater than the other object


#### Implementing java.lang.Comparable`<T>` 
here is a person class whose natural ordering is based on age:
- ```java
    public class Person implements Comparable<Person> {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String toString() {
            return name;
        }
        public int compareTo(Person other) {
            return this.age - other.age;
        }
    }
    ```

#### Analyzing <T extends Comparable<? super T>>
- given the Collections static method:
    - `public static <T extends Comparable<? super T>> void sort(List<T> list)`
- and the classes:
    - `public class Person implements Comparable<Person>`
    - `public class GtStudent extends Person {...}`
- can we sort a List<GtStudent>? 
- type checker  proves that a type arguments satisfies a type bound 
- yes we can sort a List<GtStudent> as 
    - GtStudent extends Person
    - Person implements Comparable<Person>, so 
    - GtStudent is a subtype of Comparable<Person> and 
    - Person is a supertype of GtStudent 


#### Using Collections.sort(List<T>) on Raw Lists
- Java uses type erasure to implement generics, meaning that the compiled code is nearly identical to non generic code. Type erasure allows for compile time type checking while preserving the ability to work with legacy code. So you can sort a raw List of Person using the compareTo(Person) method: 
    - ```java
        List rawPeeps = new ArrayList();
        rawPeeps.add(new Person(...));
        ...
        Colllections.sort(rawPeeps);
        ```

- Overriding only happens when methods have identical signatures. to allow generic classes to work in non-generic settings, the compiler inserts bridge methods.So person looks like:
    - ```java
        public class Person implements Comparable<Person> {
            // ...
            // This is a bridge method inserted by the compiler to allow this
            // class to work with legacy non-generic code
            public int compareTo(Object other) {
                return compareTo((Person) other);
            }
            public int compareTo(Person other) {
                return this.age - other.age;
            }
        }```

#### Using java.util.Comparator<T> 
- ```java
    public interface Comparator<T> {
        int compare(T o1, T o2);

        boolean equals(Object obj);

    }```

- Comparator<T> is an interface with two methods:
    - int compare(T o1, T o2) - same contract as o1.compareTo(o2)
    - boolean equals(Object obj)
- Its always safe to use the inherited equals method, so the one you need to implement is compare.


#### Exercise

- Write a class to represent gt students called GtStudent
    - give gtstudent name, major, GPA, and year fields properties
    - have GtStudent implement Comparable<T> with some ordering that makes sense. perhaps some majors are harder than others, so GPAs are adjusted in comparisons.
    - add instances of GtStudents to an ArrayList<E>
    - Sort the ArrayList of GtStudents using Collections.sort(List<E>)
    - Write a Comparator<GtStudent> and sort your list with Collections.sort(List<E>, Comparator<E>)
    - extra. add thousands of randomly generated GtStudents to an ArrayList and a LinkedList and time Collections.sort(List<E>) method invocations for each of them. is one faster?


