import java.util.Scanner;

public class TestFormat {
    public static void main (String[] args) throws Exception{
        int bins = 20;
        String[] outputArr = new String[bins];
        int range = (int) 100.0/bins;
        for (int i = 0; i<bins; ++i){
            // outputArr[i] = Double.toString(i*range +1) + ',' + Double.toString(i*range+range);
            outputArr[i] = Integer.toString(i*range+range) + ',' + Integer.toString(i*range +1) + ':';
        }
        // print the array
        Scanner formatString = new Scanner(ArrayUtil.toString(outputArr));
        // System.out.println(formatString.next());
        formatString.useDelimiter(":");
        
        while(formatString.hasNext()){
            System.out.println(formatString.next());
        }
        // formatString.close();
        // System.out.println(ArrayUtil.toString(outputArr));
    }
}