public class DoctorCS {
    
    private AI ai;
    private String secretIdentity;
    private int jlaid;
    private boolean safe;

    public AI getAI() {
        return ai;
    }

    public int getJlaid() {
        return jlaid;
    }

    public DoctorCS(AI ai, String secretIdentity, int jlaid) {
        this.ai = ai;
        this.secretIdentity = secretIdentity;
        this.jlaid = jlaid;
        safe = false;

    }


    public void saveTheDay() {
        if (ai instanceof RogueAI) {
            RogueAI that = (RogueAI) ai; 
            do {
                that.lowerFirewall();
            }while(that.getFirewallProtection() > 0);
            safe = that.swapCannonTarget(that.getSecretHQ());
        } else {
            safe = ai.swapCannonTarget(ai.getSecretHQ());
        }
    }

    public String getStatus() {
        if (safe) {
            return "Doctor CS has saved the day!";
        } else if (!safe && ai.getDestructed()) {
            return "Dr. Chipotle has succeeded in his plan...";
        } else {
            return "Georgia Tech is still in danger!";
        }
    }

    @Override
    public String toString() {
        return String.format("%s aka Doctor CS with JLAID: %d", secretIdentity, jlaid);
    }

    public static void main(String[] args) {
        
    }
}