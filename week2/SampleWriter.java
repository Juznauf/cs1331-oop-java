import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;

public class SampleWriter {
    public static void main(String[] args){
        try {
            PrintStream outFile = new PrintStream(new File("somefile.txt"));
            String text = "Test out this new writer yoooo";
            outFile.println(text);
        }catch (FileNotFoundException e){
            System.out.println("Error encountered");
            e.printStackTrace();
        }
    }
}