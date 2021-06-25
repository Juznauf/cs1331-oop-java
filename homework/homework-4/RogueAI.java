public class RogueAI extends AI {

    private int firewallProtection;
    private int alertLevel;
    private final int maxAlert;

    
    public int getFirewallProtection() {
        return firewallProtection;
    }

    public int getAlertLevel() {
        return alertLevel;
    }

    public int getMaxAlert() {
        return maxAlert;
    }

    public RogueAI(int firewallProtection, Coordinates cannonTarget, Coordinates secretHQ) {
        this(firewallProtection, 10, cannonTarget, secretHQ); // constructor delegation
    }
    
    public RogueAI(int firewallProtection, int maxAlert, Coordinates cannonTarget, Coordinates secretHQ) {
        this(firewallProtection, 0, maxAlert, cannonTarget, secretHQ); // constructor delegation
    }

    public RogueAI(int firewallProtection, int alertLevel, int maxAlert, Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        this.maxAlert = maxAlert;
        this.alertLevel = alertLevel;
    }

    public void lowerFirewall() {
        firewallProtection-=2;
        alertLevel++;
    }

    @Override
    public boolean shouldSwapCannonTarget() {
        if (firewallProtection <= 2) {
            return true;
        } else {
            return false;
        }
        // return (firewallProtection <= 2);
    }

    @Override
    public boolean shouldSelfDestruct() {
        return (alertLevel>=maxAlert);
    }

    @Override
    public String toString() {
        return String.format("Dr. Chipotle’s guacamole cannon is currently pointed at %s, " + 
        "and is at alert level %d with firewall protection %d.", this.getcannonTarget().toString(), alertLevel, 
        firewallProtection );
    }
    public static void main(String[] args) {
        Coordinates coords = new Coordinates(13.31, 23.16);
        RogueAI ai = new RogueAI(10, 0, 15, coords, new Coordinates(50.0, 25.5));
        // DoctorCS cs = new DoctorCS(new RogueAI(10, 0, 15, coords,
        //     new Coordinates(50.0, 25.5)), "Robert Paulson", 13310001);
        System.out.println(ai);        
    }
}