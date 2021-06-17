import java.util.Scanner;

public class ExamAvg{
    public static void main(String[] arg){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your 3 test scores, seperated by spaces.");
        int exam1 = keyboard.nextInt();
        int exam2 = keyboard.nextInt();
        int exam3 = keyboard.nextInt();
        double examAvg = (exam1 + exam2 + exam3) / 3.0; //3.0 as we do not want to do integer division
        System.out.printf("Your exam average is %.1f%n", examAvg); 
    }
}