// to test the histogram class


public class TestCases {

    public static void main(String[] args) throws Exception{
        
        String[] newArgs = new String[2];
        newArgs[0] = "grades.csv";
        
        String[] testCases = {"10", "20","101"};
        
        for (String bin : testCases) {
            System.out.printf("Test case with bins = %s...%n",bin);
            newArgs[1] = bin;
            Histogram.main(newArgs);
            System.out.println();
        }
    }
}