// package java.text; // to use the NumberFormat class
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatting{
    public static void main(String[] arg){
        NumberFormat us = NumberFormat.getCurrencyInstance();
        System.out.println(us.format(3.14));
        NumberFormat de = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(de.format(3.14));
    }
}