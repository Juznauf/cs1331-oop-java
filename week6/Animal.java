public class Animal {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String aName) { 
        name = aName;
    }

    public Animal(String aName) {
        setName(aName);
    }

    public String speak() {
        return "aSound";
    }

    public static void main(String[] args) {
        
    }
}