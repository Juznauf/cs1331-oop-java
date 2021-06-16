public class NameParser {

    static String globalName = "Global Name";
    public static void main(String[] args){
        System.out.println(extractLastName("Naufal,Najib"));
        System.out.println(globalName); // calls the global variable
    }

    public static String extractLastName(String name){
        // takes a single parameter of type string
        int commaPos = name.indexOf(",");
        System.out.println(commaPos);
        int len = name.length();
        String lastName = name.substring(0, commaPos).trim();
        return lastName;
    }
}

