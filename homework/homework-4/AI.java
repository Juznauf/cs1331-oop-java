public abstract class AI {

    private boolean destructed;
    private Coordinates cannonTarget;
    private Coordinates secretHQ;

    public AI(Coordinates cannonTarget, Coordinates secretHQ) {
        this.cannonTarget = cannonTarget;
        this.secretHQ = secretHQ;
    }
    public static void main(String[] args) {
        
    }

    public boolean getDestructed() {
        return destructed;
    }
    public Coordinates getcannonTarget() {
        return cannonTarget;
    }
    public Coordinates getSecretHQ() {
        return secretHQ;
    }

    public boolean swapCannonTarget(Coordinates newCoords) {
        if (!destructed && !newCoords.equals(cannonTarget)) {
            if (shouldSwapCannonTarget()) {
                cannonTarget = newCoords;
                return true;
            } else {
                selfDestruct();
                return false;
            }
        } else {
            return false;
        }
    }

    public abstract boolean shouldSwapCannonTarget();

    public void selfDestruct() {
        destructed = true;
    }

    public abstract boolean shouldSelfDestruct();

    public String toString() {
        return String.format("Dr. Chipotle's guacamole cannon is currently pointed at %s", cannonTarget.toString());
    }


}