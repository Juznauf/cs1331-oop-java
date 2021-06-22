import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.io.FileReader;

public class SourceModel {
    
    private String modelName;
    private String fileName;
    private int[][] countMatrix;
    private double[][] tMatrix;

    // constructor
    public SourceModel(String aModelName, String aFileName) throws Exception {
        modelName = aModelName;
        fileName = aFileName;
        countMatrix = new int[26][26];
        tMatrix = new double[26][26];

    
        System.out.print(String.format("Training %s model...", modelName));

        // this portion is to read in the corpus
        FileReader fileScanner = new FileReader(new File(aFileName));
        int d;
        char c;
        char prev = '1'; //set as 1 first, store the prev char, the row of countMatrix is the precedent 
        // the int represent of 'a' is 97, the int represent of 'z' is 122
        while ((d = fileScanner.read()) != -1) {
            c = (char) d;
            if (Character.isAlphabetic(c)) {
                c = Character.toLowerCase(c);
                // start the count algorithm
                // if prev is null then prev is current char
                if (prev == '1') {
                    // System.out.println(c);
                    prev = c;
                } else {
                    countMatrix[prev-97][c-97] += 1;
                    // System.out.printf("%s,%s = %d%n", prev, c, countMatrix[prev-97][c-97]); // to check count
                    prev = c;
                }
                // System.out.print(c);
            }
        }
        // compute the transition matrix
        
        // the algo is for element_(i,j) take countMatrix[i,j]/sum(countMatrix[i])
        
        // find the rowsums 
        int[] aggRowMatrix = new int[26];
        int rowSum;
        for (int row=0; row < countMatrix.length; ++row) {
            rowSum = 0;  
            for (int col=0; col < countMatrix[row].length; ++col) {
                rowSum += countMatrix[col][row];
            }
            // add to the aggRowMatrix
            aggRowMatrix[row] = rowSum;
        }

        // compute the actual probabilities

        for (int row=0; row < tMatrix.length; ++row) {
            for (int col=0; col < tMatrix[row].length; ++col) {
                if (!(countMatrix[row][col] == 0)){
                    // if not 0 then calculate
                    tMatrix[row][col] = (double) countMatrix[row][col]/aggRowMatrix[row];
                } else {
                    tMatrix[row][col] = 0.01;
                }
            }
        }

        // print done
        System.out.print("done.\n");
    }
    public static void main(String[] args) throws Exception {

        // the first n-1 are training sets
        SourceModel sm;
        String[] splitFile = new String[2];
        double[] probArray = new double[args.length-1];

        for (int i = 0; i<args.length-1; ++i) {
            splitFile = args[i].split("\\.");
            sm = new SourceModel(splitFile[0], args[i]);

            // store the probabilities
            probArray[i] = sm.probability(args[args.length-1]);
        }

        System.out.printf("Analyzing: %s%n", args[args.length-1]);


        // we need to normalize the probabilities of all the models 
        double totalProb = 0;
        for (double prob: probArray) {
            totalProb += prob;
        }


        for (int i=0; i<args.length-1; ++i) {
            double normProb = probArray[i]/totalProb;
            System.out.printf("Probability that test string is %s: %.2f%n",
            args[i].split("\\.")[0], normProb);
        }


        // sm1.visualizeArray(sm1.countMatrix);
        // System.out.println();
        // sm1.visualizeArray(sm1.tMatrix);
        // char a = 'a';
        // System.out.println((int) a);
        // System.out.println((int) 'b');
        // System.out.println((int) 'z');
        // System.out.println('b' - a);
        // System.out.println('d' - a);

    }

    private double probability(String aString) {
        double prob = 1.0;
        char[] charsArr = aString.toCharArray();
        StringBuilder builder = new StringBuilder();
        // filter the array first 
        for (char c : charsArr) {
            if (Character.isAlphabetic(c)) {
                c = Character.toLowerCase(c);
                builder.append(c);
            }
        }
        // this is the filtered array
        charsArr = builder.toString().toCharArray();

        // calculate the prob
        // System.out.println(charsArr);
        double tProb;
        for (int i=0; i < charsArr.length-1; ++i) {
            tProb = tMatrix[charsArr[i]-97][charsArr[i+1]-97]; 
            prob *= tProb;
        }

        return prob;
    }

    private void getName() {
        System.out.println(modelName);
    }
    
    public String toString() {
        return "Model: " + modelName + "\n" + stringVisualArray(tMatrix); 
    }

    private String stringVisualArray(double[][]  tMatrix) {
        // will be called in toString() method 
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%-6c", ' '));
        for (int i = 0; i < tMatrix.length; ++i) {
            char e = (char) (i + 97);
            builder.append(String.format("%-6c", e));
        }
        System.out.println();
        for (int row = 0; row < tMatrix.length; ++row) {
            char f = (char) (row + 97);
            builder.append(String.format("%-6c", f));
            for (int col = 0; col < tMatrix[row].length; ++col) {
                builder.append(String.format("%-6.2f",tMatrix[row][col]));
            }
            builder.append("\n");
        }
        return builder.toString();
    }


    private void visualizeArray(double[][] countMatrix) {
        // displays the tMatrix
        System.out.printf("%-6c", ' ');
        for (int i = 0; i < countMatrix.length; ++i) {
            char e = (char) (i + 97);
            System.out.printf("%-6c", e);
        }
        System.out.println();
        for (int row = 0; row < countMatrix.length; ++row) {
            char f = (char) (row + 97);
            System.out.printf("%-6c", f);
            for (int col = 0; col < countMatrix[row].length; ++col) {
                System.out.printf("%-6.3f",countMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private void visualizeArray(int[][] countMatrix) {
        // displays the countmatrix 
        System.out.printf("%-4c", ' ');
        for (int i = 0; i < countMatrix.length; ++i) {
            char e = (char) (i + 97);
            System.out.printf("%-4c", e);
        }
        System.out.println();
        for (int row = 0; row < countMatrix.length; ++row) {
            char f = (char) (row + 97);
            System.out.printf("%-4c", f);
            for (int col = 0; col < countMatrix[row].length; ++col) {
                System.out.printf("%-4d",countMatrix[row][col]);
            }
            System.out.println();
        }
    }
}