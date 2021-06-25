import java.util.Random;

public class RandomAI extends AI {

    private static Random randomizer;

    public RandomAI(Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        randomizer = new Random();
    }
    @Override
    public boolean shouldSwapCannonTarget() {
        if (randomizer.nextInt(2) < 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean shouldSelfDestruct() {
        if (randomizer.nextInt(2) < 1) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        
    }
}