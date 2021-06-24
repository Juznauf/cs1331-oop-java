### HW3


#### solution description 
- `vendingItem.java (enum)` instances of this enum will represent items in your vending machine. Your boss at coke has done extensive analysis and determined that the following items an prices are ideal
- the names of the elements in your enum should be exactly as they appear here, and the price should be a parameter to the enum constructor. Your vendingItem enum should have the following fields, methods, and constructors
    - `private final double price`. this field is the price of an item, and should be set in the constructor 
    - `VendingItem(double price)`. this is the constructor for the enum type and it takes the price as its single parameter
    - `public double getPrice()`. this method is just a simple getter method for the price. `price` is `final` and has no setter because it does not make sense for an objects price to change at runtime
    - `public String toString()`. This method returns a String representation of a VendingItem for use in simulation. The string should look like: "(name): $xx.xx"

- `VendingMachine.java`
- This class represents the vending machine itself and is the bulk of the assignment. It has the following fields, methods, and constructors:
 
    -  `private static double totalSales`. Your boss wants a way to measure the success of this venture, so this field will keep track of the total sales across vending machines. It should be initialized to 0 and properly updated every time a sale that makes money is made. More on this later.

    - `private VendingItem[][][] shelf`. This 3D array of VendingItems represents how the items are arranged in the vending machine. shelf[i][j][k] represents the VendingItem located in the ith row, jth column, and kth position where position 0 (shelf[i][j][0]) is the item at the front of the “stack” and each subsequent position represents the item behind it. The shelf should be initialized to have 6 rows, 3 columns, and 5 positions per location.

    - private int luckyChance. To give Tech students an incentive to use the machines, you have incorpoated the chance to win a free item into the machine. This field represents the percent chance that a user has to win on the current vend() and should be initialized to 0. More details below.

    - private Random rand. This is an instance of the Random class you will be using to generate the random numbers needed in this implementation.

    - public VendingMachine(). This is the single no-arg constructor for VendingMachines. You should initialize your fields and call restock() here so that your vending machine is ready to use as soon as someone initializes it.

    - public VendingItem vend(String code). This method is used to dispense an item from the vending machine. It takes in a parameter code representing the user’s input. This code will be formatted as a letter followed by a number (A6), which represents the the row and column of the selected item. You must dispense the item from the proper row and column and move the items behind it so that there is always (if possible) an item in the 0 position. This method should also take care of checking the code for validity before dispensing anything and should print an error statement and return null if something goes wrong. It should also print an error statement and return null if there is no item in the position that the user selected. If it is determined by the free() method that the item being dispensed is free for the user, this method should print a statement notifying the user as such. Finally, this method should update the totalSales field as needed. Be careful not to update totalSales if the item was free or if something went wrong.

    - private boolean free(). This private helper method should be used in conjuntion with vend() to determine if the current user should recieve their item for free. This method should have a percent chance equal to luckyChance of returning true (use rand). If the method returns true, luckyChance should be reset to 0. However, if the method returns false, luckyChance should be incremented by 1, giving the next user a 1% higher probability of winning a free item.

    - public void restock(). This method should fill each spot in the vending machine with a randomly chosen item every time it is called. HINT: Make use of rand and the values() method of Enum to achieve this functionality. More info here.

    - public static double getTotalSales(). This method is a getter for the totalSales field. It is static because totalSales is a static variable and keeps track of sales across all vending machines.

    - public int getNumberOfItems(). This method should return the total number of VendingItems in the vending machine. NOTE: Although the method is named get...(), it is not a getter method and requires some logic.

    - public double getTotalValue(). This method should return the combined total value of all the VendingItems in the vending machine. NOTE: Although the method is named get...(), it is not a getter method and requires some logic.

    - public int getLuckyChance(). This method should return the current value of luckyChance. NOTE: This is for testing purposes and you shouldn’t have to call this method.

    - public String toString(). To make it easier, this method has been provided for you below and returns a String representation of the VendingMachine for use in your simulation.


