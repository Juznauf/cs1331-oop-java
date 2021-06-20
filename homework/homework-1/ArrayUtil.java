public class ArrayUtil {

    public static void main(String[] args) {
        // used to test out the util functions
        int[] xs = new int[4];

        // populate in a for loop
        
        System.out.println("Printing the array xs....");
        for (int i = 0; i<4; ++i) {
            xs[i] = i;
            System.out.print(xs[i]);
        }
        System.out.println();
        
        // test take method
        int[] result = take(2, xs);
        
        System.out.println("\nPrinting the array xs after the \"test method\"....");
        for (int i = 0; i<2; ++i) {
            System.out.print(result[i]);
        }
        System.out.println();
        // test drop method
        System.out.println("\nPrinting the array xs after the \"test method\"....");
        result = drop(2 , xs);
        for (int i = 0; i<2; ++i) {
            System.out.print(result[i]);
        }
        System.out.println();
        
        // test equals method 
        System.out.println("\nPrinting the output of the equals method....");
        int[] ys = new int[2];
        // populate ys 
        for (int i = 1; i<3;i++) {
            ys[i-1] = i*i;
        }
        boolean newResult = equals(xs, ys);
        System.out.println(newResult);
        
        // test concat method
        System.out.println("\nPrinting the output of the concat method....");
        int[] concatArr;
        concatArr = concat(xs, ys);
        for (int i = 0; i < concatArr.length; i++){
            System.out.print(concatArr[i]);
        }
        System.out.println();
        
        System.out.println("\nPrinting the output of the toString method....");
        System.out.println(toString(xs));


        // create the 2d array
        int[][] grid = {{1, 4},
                         {4, 4},
                         {4, 4},
                         {4, 4}};

        System.out.println("\nPrinting the output of the toString method....");
        System.out.println(toString(grid));
        
        System.out.println("\nPrinting the output of the identity method....");
        System.out.println(toString(identity(20)));

    }

    public static int[] take(int n, int[] xs) {
        // returns a new array containing the first n elements of xs
        int[] xNew = new int[n];
        // traverse the first n elements;
        for (int i = 0; i<n; ++i) {
            xNew[i] = xs[i];
        }
        return xNew;
    }
    
    public static int[] drop(int n, int[] xs) {
        // returns a new array containing the last n elements of xs 
        int[] xNew = new int[n];
        // traverse the first n elements;
        for (int i = xs.length-1, j = 0; i > xs.length-(n+1); --i, ++j) {
            // System.out.print(i);
            xNew[j] = xs[i];
        }
        return xNew;
    }

    public static boolean equals(int[] xs, int[] ys) {
        // returns true if xs.len == ys.len and xs[i] == ys[i] for 0 <= i< xs.len
        if (xs.length == ys.length){
            for (int i = 0; i<xs.length; ++i) {
                if (!(xs[i] == ys[i])) {
                    return false;
                }
            }
            return true; 
        } else {
            return false;
        }
    }

    public static int[] concat(int[] xs, int[] ys) {
        // returns a new array containing the elements of ys after the elements of xs
        int totalLen = xs.length + ys.length;
        int[] concatArr = new int[totalLen];
        // add xs first
        for (int i = 0; i < (xs.length); ++i) {
            concatArr[i] = xs[i];
        }
        for (int i = 0; i < (ys.length); ++i) {
            concatArr[i+xs.length-1] = ys[i];
        }
        return concatArr;
    }

    public static String toString(int[] xs) {
        // change the array into a string
        String x = ""; // local variables must be initialized
        for (int i = 0; i < xs.length; i++){
            x += String.valueOf(xs[i]);
        }
        return x;
    }

    public static String toString(String[] yz) {
        // change the array into a string
        String x = ""; // local variables must be initialized
        for (int i = 0; i < yz.length; i++){
            x += String.valueOf(yz[i]);
        }
        return x;
    }

    public static String toString(int[][] as) {
        String x = "";
        for (int row = 0; row < as.length; ++row) {
            for (int col = 0; col < as[row].length; ++col){
                x += as[row][col];
                // System.out.print(as[row][col]);
            }
            x += "\n";
        }

        return x;
    }

    public static int[][] identity(int n) {
        // which returns an n x n identity matrix;

        int[][] identity = new int[n][n];

        for (int row=0; row<n; ++row) {
            for (int col=0; col<n; ++col){
                if (col == row){
                    identity[row][col] = 1;
                } else {
                    identity[row][col] = 0;
                }
            }
        }
        return identity;
    }


}