import java.util.Random;
/**
 * Vending Machine class
 * 
 * @author naufal
 */

public class VendingMachine {

    private static double totalSales = 0; /*keep track of the total sales across vending machines  
    updated every time a sale that makes money is made*/
    private VendingItem[][][] shelf; /* how the items are arranged in the vending machine. */
    private int luckyChance; /* percent chance that a user has to win on the current vend()  */
    private Random rand; /* instance of the random class to generate random numbers */
    private boolean[][][] shelfAvailable; /* this is to keep track of the available items */
    
    public VendingMachine() {
        /**
         * single no arg constructor 
         * 
         * init the fields here and call restock() so that vending machine is ready to use at init
         * 
         */
        luckyChance = 0;
        rand = new Random();
        shelf = new VendingItem[6][3][5];
        // shelfAvailable = new boolean[6][3][5];
        restock();

    }

    public VendingItem vend(String code) {
        /**
         * this method is used to dispense an item
         * 
         * @param code represents the user input, represents row and col (eg A6) 
         * @throws code invalid and item not found error
         * @return item an item from the vending machine
         */

        // check code validity
        if (!codeChecker(code)){
            System.out.println("The code that you have entered is invalid!");
            return null;
            // System.exit(0);
        } else {
            int row;
            int col;
            row =  code.split("")[0].charAt(0) - 65; //return the first char
            col =  Integer.parseInt(code.split("")[1]) - 1; // as index for this starts from 1
            if (!(shelf[row][col][0] == null)) {
                VendingItem item = shelf[row][col][0];
                for (int i=0; i < shelf[row][col].length-1;++i) {
                    shelf[row][col][i] = shelf[row][col][i+1];
                }
                // set last one to null always
                shelf[row][col][4] = null;

                // check if free item or not
                if (!free()) {
                    totalSales += item.getPrice();
                }
                return item;
            } else {
                System.out.println("Item is not available!");
                return null;
            }
        }
    }

    private static boolean codeChecker(String code) {
        /**
         * checks if the code is properly formatted 
         * 
         * @param the user input code
         * @return true/false depends on the validation 
         */

        char row;
        int col;
        row =  code.split("")[0].charAt(0); //return the first char
        col =  Integer.parseInt(code.split("")[1]);
        if ((row < 65 || row > 70) || (col < 1 || col > 3)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean free() {
        /**
         * this helper method is used in vend to determine if user receives the 
         * item for free. it should also print a statement notifying the user as such 
         * 
         * @return true if current user receives item for free
         */

        if (rand.nextInt(100) < (luckyChance-1)){
            return true;
        } else {
            return false;
        }
    }

    public void restock() {
        /**
         * should fill each spot in the vending machine with a rand
         * chosen item every time it is called 
         */

        // there are 16 items, we randomise 16 ints to correspond with our enums

        for (int row=0; row<shelf.length; ++row) {
            for (int col=0; col<shelf[row].length; ++col) {
                for (int slot=0; slot<shelf[row][col].length; ++slot) {
                    // get a random number 
                    int aRanNum = rand.nextInt(16);
                    // store the item
                    shelf[row][col][slot] = VendingItem.values()[aRanNum];
                    // shelfAvailable[row][col][slot] = true; 
                }
            }
        }

    }

    public static double getTotalSales() {
        return totalSales;
    }

    public int getNumberOfItems() {
        int num=0;
        for (int row=0; row<shelf.length; ++row) {
            for (int col=0; col<shelf[row].length; ++col) {
                for (int slot=0; slot<shelf[row][col].length; ++slot) {
                    if (!(shelf[row][col][slot] == null)) {
                        ++num;
                    }
                }
            }
        }
        
        return num;
    }
    
    public double getTotalValue() {
        double total=0.0;
        for (int row=0; row<shelf.length; ++row) {
            for (int col=0; col<shelf[row].length; ++col) {
                for (int slot=0; slot<shelf[row][col].length; ++slot) {
                    if (!(shelf[row][col][slot] == null)) {
                        total += shelf[row][col][slot].getPrice();
                    }
                }
            }
        }
        return total;
    }

    public int getLuckyChance() {
        return luckyChance;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                            VendaTron 9000                "
            + "            \n");
        for (int i = 0; i < shelf.length; i++) {
            s.append("------------------------------------------------------"
                + "----------------\n");
            for (int j = 0; j < shelf[0].length; j++) {
                VendingItem item = shelf[i][j][0];
                String str = String.format("| %-20s ",
                    (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("There are %d items with a total "
            + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
        s.append(String.format("Total sales across vending machines "
            + "is now: $%.2f.%n", getTotalSales()));
        return s.toString();
    }

    public static void main(String[] args) {
        VendingMachine vm1 = new VendingMachine();
        System.out.println(vm1);
        System.out.println(vm1.vend("A1"));
        System.out.println(vm1);
        System.out.println(vm1.vend("A1"));
        System.out.println(vm1);
        System.out.println(vm1.vend("A1"));
        System.out.println(vm1);
        System.out.println(vm1.vend("A1"));
        System.out.println(vm1);
        System.out.println(vm1.vend("A1"));
        System.out.println(vm1);
        System.out.println(vm1.vend("A1"));


    }
}