public enum VendingItem {

/**
 * VendingItem enums.
 *
 * @author naufal
 */


    Lays(1.5),
    Doritos(1.5),
    Coke(2.5),
    Ramblin_Reck_Toy(180.75),
    Rubiks_Cube(30.0),
    Rat_Cap(15.0),
    FASET_Lanyard(10.0),
    Graphing_Calculator(120.0),
    UGA_Diploma(0.1),
    Pie(3.14),
    Clicker(55.55),
    Cheetos(1.25),
    Sprite(2.5),
    Red_Bull(4.75),
    Ramen(3.15),
    Cold_Pizza(0.99);
    
    private final double price;
    
    VendingItem(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        /**
         * Returns the price of the enum type.
         * 
         * @return the price of the enum type which calls this method
         *  
         */
        return this.price;
    }

    public String toString() {
        /**
         * @return returns the string representation 
         * 
         */
        return String.format("(%s): $%.2f", this.name().toString(), this.price); // check if can remove the toString here
    }
    
    public static void main(String[] args) {
        // VendingItem test = VendingItem.values()[0];
        // VendingItem test = VendingItem.values()[0].price;
        // System.out.println(test);
        // for (int i=0; i<VendingItem.values().length; ++i) {
        //     System.out.println(VendingItem.values()[i]);
        // }
    }

}