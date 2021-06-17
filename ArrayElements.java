public class ArrayElements {
    public static void main(String[] args){
        double[] scores = new double[5];
        scores[0] = 89;
        scores[1] = 89;
        scores[2] = 89;
        scores[3] = 89;
        scores[4] = 89;
        scores[scores.length - 1] = 99.2;
        // scores[scores.length] = 100; // this will raise an index error
        String[] validSuits = {"diamonds", "clubs", "hearts", "spades"};
        System.out.println(validSuits.length);
        System.out.println(validSuits[1]);

        int[] squares = new int[5];
        for (int i = 0; i < squares.length; ++i) {
            squares[i] = i*i;
        }
        System.out.println(squares[4]);

        System.out.println("For loops with array...\n");
        
        double[] scores_new = new double[5];
        for (int i = 0; i <5; ++i) {
            System.out.printf("scores_new[%d] = %.2f%n", i , scores_new[i]);
        }
        
        System.out.println("For loops with array using for each...\n");

        for (double score: scores_new) {
            System.out.println(score);
        }


    }
}