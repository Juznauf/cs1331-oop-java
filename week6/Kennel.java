public class Kennel {
    private Dog[] dogs;

    public Kennel(Dog ...args) {

        dogs = new Dog[args.length];
        dogs = args;
    }

    public void soundOff() {
        for(Dog aDog: dogs) {
            System.out.printf("%s says %s!%n", aDog.getName(),aDog.speak());
        }
    }
    public static void main(String[] args) {

        Dog firstDog = new Dog("mike");
        Dog secondDog = new Dog("nike");
        Kennel firstKennel = new Kennel(firstDog, secondDog);
        firstKennel.soundOff();
        
    }
}