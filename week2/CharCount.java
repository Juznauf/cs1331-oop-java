public class CharCount {
    public static void main(String[] args){
        count("heollo96");
    }
    public static void count(String input){
        // a simple program to count the type of characters in a string
        int digitCount = 0, letterCount = 0;
        for (int i = 0; i < input.length(); ++i){
            char c = input.charAt(i);
            if (Character.isDigit(c)) digitCount++;
            if (Character.isAlphabetic(c)) letterCount++;
        }
        System.out.println(digitCount);
        System.out.println(letterCount);
    }
}