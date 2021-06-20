import java.util.Scanner;
import java.io.File;
// import java.io.FileNotFoundException;

public class Histogram {
    public static void main(String[] args) throws Exception {
        
        int bins;
        String fileName;
        
        // check if the number of bins is given at console 
        if (args.length == 1){
            // create a scanner to accept input from console
            // then we prompt for the number of bins
            Scanner keyboard = new Scanner(System.in);
            System.out.println("How many bins would you like?");
            bins = keyboard.nextInt();
            fileName = args[0];
        } else {
            // we get the number of bins from the prompt
            fileName = args[0];
            bins = Integer.parseInt(args[1]);
        }
        // continue on with the main program flow
        
        // get the data from the csv file 
        Scanner fileScanner = new Scanner(new File(fileName)); //infile

        // create the array bins to store the count in each bin
        int[] binsArr = new int[bins];
        
        // create the output arr to store the string formatting of the results ranges
        String[] outputArr = createOutputArr(bins);  

        // System.out.println(toString(outputArr));

        // we can only scan through the rows once
        while (fileScanner.hasNext()){

            Scanner scanDelim = new Scanner(fileScanner.nextLine());
            scanDelim.useDelimiter(".*,\\s*"); //extract only the number
            int score = scanDelim.nextInt();
            
            // check if number of bins is divisible by 101;
            if (bins == 1){
                // if bins is 1 then we return all in one bin
                binsArr[0] += 1;
                if (!fileScanner.hasNext()){
                    outputArr[0] = "100,0"; 
                }

            } else if (bins == 101){
                // if bins is 101, then the range of each bin is 1
                binsArr[score] += 1;
            } else {
                // in this case, the smaller bin range will always be one more to include the 0
                double range = 100.0/bins;
                if (score == 0){
                    binsArr[0] += 1;
                } else {
                    for (int i = 0; i<binsArr.length; ++i){
                        if (score >= (i*range +1) && score <=(i*range+range)){
                            binsArr[i] += 1;
                        }
                    }
                }
            }
        }

        // format the results
        // 100 - 96 | [][][][][][][] //example output
        for (int i = outputArr.length-1; i>=0; --i){
            String brackets = new String("[]").repeat(binsArr[i]);
            Scanner line = new Scanner(outputArr[i]);
            line.useDelimiter(",");
            String left = String.format("%3s - %2s |", line.next(),line.next());
            System.out.printf("%s %s%n", left, brackets);
        }
        
        
        
        // System.out.println(toString(binsArr));
        // System.out.println(outputArr.length == binsArr.length); // assert the length of both arrays 
    }

    public static String[] createOutputArr(int bins){
        // this is to create the output of "upper range - lower range"  of each bin
        String[] outputArr = new String[bins];

        if (bins==1){
            outputArr[0] = "100,0";
        }else if (bins == 101){
            for (int i = 100; i>-1; --i){
                outputArr[i] = " " + "," + Integer.toString(i);
            }
        }else {
            int range = (int) 100.0/bins;
            for (int i = 0; i<bins; ++i){
                if (i == 0){
                    outputArr[i] = Integer.toString(i*range+range) + ',' + '0';
                }else {
                    outputArr[i] = Integer.toString(i*range+range) + ',' + Integer.toString(i*range+1);
                    
                }
            }
        }
        return outputArr;
    }

    public static String toString(int[] xs) {
        // change the array into a string
        String x = ""; // local variables must be initialized
        for (int i = 0; i < xs.length; i++){
            x += String.valueOf(xs[i]) + ' ';
        }
        return x;
    }

    public static String toString(String[] xs) {
        // change the array into a string
        String x = ""; // local variables must be initialized
        for (int i = 0; i < xs.length; i++){
            x += xs[i] + ' ';
        }
        return x;
    }
}