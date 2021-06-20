import java.util.Arrays;

public class Person {
    private String name;
    private int age;


    public Person(String aName, int aAge) {
        name = aName;
        age = aAge;
    }
    public String toString() {
        return "name is " + name + " age is " + age;
    }

    public static void main (String[] args) {
        // creates an array of person objects 

        Person[] manyPersons = new Person[3];
        manyPersons[0] = new Person("Naufal", 25);
        manyPersons[1] = new Person("Mikhail", 25);
        manyPersons[2] = new Person("Arif", 20);

        for (Person singlePerson : manyPersons) {
            if (singlePerson.age > 21) {
                System.out.println(singlePerson);
            }
        }
    }
}