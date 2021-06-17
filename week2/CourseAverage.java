import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CourseAverage {
    public static void main(String[] args){
        try{
            // File f = new File("ScannerFun.java");
            // File f = new File("words.txt");
            // Scanner fileScanner = new Scanner(f);
            Scanner fileScanner = new Scanner(new File("ScannerFun.java"));

            while (fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                // do something with line 
                System.out.println(line);
            }
            fileScanner.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}