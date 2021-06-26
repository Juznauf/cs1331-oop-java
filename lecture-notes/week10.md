### collections 

#### The collections framework 

- a collection is an object that represents a group of objects 
- the collections framework allows different kinds of collections to be dealth with in an implementation -independent manner.

#### The collection interface
`Collection` is the root interface of the collections framework, declaring basic operations such as:
    - `add(E e)` to add elements to the collections
    - `contains(Object key)` to determine whether the collection contains `key`
    - `isEmpty()` to test the colletion for emptiness
    - `iterator()` to get an iterator over the elements of the collection 
    - `remove(Object o)` to remove a single instance of o from the collection if present 
    - `size()` to find out the number of elements in the collection

#### Lists and ArrayList

- The List interface extends the Collection interface to represent ordered collections, or sequences. List adds
    - methods for positional(indexed) access to elements (`get(int index)`, `indexOf (Object o)`, `remove (int index)`, `set(int index, E element)`),
    - a special iterator, `ListIterator`, that allows element insertion and replacement, and bidirectional access in adition to the normal operations that the Iterator interface provides, and methods to obtain a `ListIterator`
    - a subList(int fromIndex, int toIndex) that returns a view of a portion of the list.
- ArrayList and LinkedList are the two basic List implementations provided in the Java standard library.
    - Vector also implements List and and can be thought of as a synchronized version of ArrayList. You dont need vector if youre not writing multithreaded code. using vector in single threaded code will decrease performance.

#### ArrayList basics 
- create an ArrayList with operator new:
    - ```java
        ArrayList tasks = new ArrayList();
        ```
- add items 
    - ```java
        tasks.add("Eat");
        tasks.add("Sleep");
        tasks.add("Code");
        ```
- traverse with for each loop 
    - ```java
        for (Object task: tasks) {
            System.out.println(task);
        }```


#### Generics

- we need to specify the type in arraylist and it is a parameterized type.
- the type parameter can be any class name (not a primitive type)

#### using generics 
- we need to use 
    - ```java
        ArrayList<String> strings = new ArrayList<String>();
        ```

- with a typed collection, we get autoboxing on insertion and retrieval
    - ```java
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(42);
        int num = ints.get();
        ```
- we didnt need to supply the type parameter, java inferred it from the declaration

#### Primitives in collections 
- Arraylist can only hold reference types. So must use wrapper classes for primitives
    - ```java
        ArrayList ints = new ArrayList();
        ints.add(new Integer(42));
        ```
- java autoboxes primitives when adding to a collection
    - ```java
        ints.add(99);
        ```
- but auto unboxing can be done when retrieving from an untyped collection 
    - ```java
        int num = ints.get(0); //wont compile
        ```

- the old way to handle this with untyped collections is to cast it:
    - ```java
        int num = (Integer) ints.get(0); // auto unboxing on assignment to int
        ```

#### Sets 
- A set is a collection with no duplicate elements (no two elements where e1.equals(e2)) and in no order.
- ```java
    List<String> nameList = Arrays.asList("Alan", "Ada", "Alan");
    Set<String> nameSet = new HashSet<>(nameList);
    System.out.println("nameSet: " + nameSet);
    // this will print 
    // nameSet: [Alan, Ada]
    ```

#### maps 
- A `map<K, v>` is an object that maps keys of type K to values of type V. the code 
- ```java
    Map<String, String> capitals = new HashMap<>();
    capitals.put("Georgia", "Atlanta");
    capitals.put("Alabama", "Montgomery");
    capitals.put("Florida", "Tallahassee");
    for (String state: capitals.keySet()) {
    System.out.println("Capital of " + state + " is "
    + capitals.get(state));
    }
    // prints 
    //Capital of Georgia is Atlanta
    //Capital of Florida is Tallahassee
    //Capital of Alabama is Montgomery
    ```
- note that the order of the keys differs from the order in which we added them. The keys of a map are a Set, so there can be no duplicates and order is not guaranteed. If you put a new value with the same key as entry it will be overwritten

#### exercise

- write a class called WordCount
    - the constructor should take a String file name
    - WordCount should have an instance variable wordCounts which is a Map from String to int, where each String key is a word that occurs in the file supplied to the constructor, and the corresponding int is the number of times the word appears in the file
    - extra: normalize the word counts to [0,1] so that the word counts represent the probability that a randomly chosen word from the file is a given word.
     




    