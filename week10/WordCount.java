import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class WordCount {
    
    private Map<String, Integer> wordCounts;
    private Map<String, Double> wordCountsNormalize;

    public WordCount(String fileName) throws FileNotFoundException {
        wordCounts = new HashMap<>();
        Scanner fs = new Scanner(new File(fileName));
        while (fs.hasNextLine()){
            // deconstruct the line
            String[] splitLine = fs.nextLine().split(" ");
            
            // System.out.println(splitLine);
            for (String word: splitLine){
                try {
                    int update = wordCounts.get(word.toLowerCase());
                    update++;
                    wordCounts.put(word.toLowerCase(), update);
                } catch (NullPointerException e) {
                    wordCounts.put(word.toLowerCase(), 0);
                    int update = wordCounts.get(word.toLowerCase());
                    update++;
                    wordCounts.put(word.toLowerCase(), update);
                }
            }   
        }
    }

    private void wordCountsNormalize() {
        /**
         * modifies the hashmap
         */
        wordCountsNormalize = new HashMap<>();
        int total = 0;
        for (int count: wordCounts.values()) {
            total += count;
        }
        for (Map.Entry<String, Integer> entry: wordCounts.entrySet()) {
            wordCountsNormalize.put(entry.getKey(), entry.getValue()/ (double) total);
        }
    } 
    public Map<String, Integer> getWordCounts() {
        return wordCounts;
    } 

    public Map<String, Double> getWordCountNorm() {
        return wordCountsNormalize;
    }

    public static void main(String[] args) throws FileNotFoundException {

        WordCount wc = new WordCount(args[0]);
        wc.wordCountsNormalize();
        System.out.println(wc.getWordCountNorm());
        System.out.println(wc.getWordCounts());
    }
}