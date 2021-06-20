// to test the histogram class


public class TestCases {

    public static void main(String[] args) throws Exception{
        
        String[] newArgs = new String[2];
        newArgs[0] = "grades.csv";
        
        
        // test case with bins = 10
        System.out.println("Test case with bins = 10...");
        newArgs[1] = "10";
        Histogram.main(newArgs);
        System.out.println();
        
        // test case with bins = 20
        System.out.println("Test case with bins = 20...");
        newArgs[1] = "20";
        Histogram.main(newArgs);
        System.out.println();
        
        // test case with bins = 101
        System.out.println("Test case with bins = 101...");
        newArgs[1] = "101";
        Histogram.main(newArgs);
        System.out.println();
    }
}