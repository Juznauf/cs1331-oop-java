
public class ShortCircuit {
    private static int counter = 0;
    
    private static boolean inc() {
        counter++;
        return true;
    }
    public static void main(String[] args){
        boolean a = false;
        if (a || inc()){
            System.out.println("Meow");
        }
        System.out.println("Counter: " + counter); //operator overload, counter cast to string
        if (a && inc()) { // as a is false, inc() will not execute due to logicals
            System.out.println("Woof"); // this line does not exec 
        }
        System.out.println("Counter: " + counter);
    } 
}