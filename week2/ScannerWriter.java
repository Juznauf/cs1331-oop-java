import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;

public class ScannerWriter {

    public static void main(String[] args) throws Exception {
        // read all the lines of a file whose name is given at command line
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the file name to be copied:");
        String fileName = keyboard.nextLine();

        // create a new file with -uppercase appended
        int splitIndex = fileName.indexOf('.');
        String fileNameOut = fileName.substring(0, splitIndex);
        fileNameOut = fileNameOut.toUpperCase();

        // write all the lines of the original file to the new file but in uppercase letters
        Scanner fileScanner = new Scanner(new File(fileName)); // infile
        PrintStream outFile = new PrintStream(new File(fileNameOut + ".txt")); //outfile

        while (fileScanner.hasNext()){
            String line = fileScanner.nextLine(); // get the next line in infile
            outFile.println(line.toUpperCase());
            System.out.println(line); //print out the lines in infile
        }
        fileScanner.close();
    }
}