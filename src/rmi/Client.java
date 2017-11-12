package rmi;
import java.rmi.Naming;
 
public class Client {
 
    public static void main(String[] args) throws Exception{
        CurrencyInterface currency = (CurrencyInterface)Naming.lookup("//localhost/currency");
        System.out.println(currency.convert("EUR", "GBP", 100.0));
        System.out.println(currency.convert("USD", "EUR", 100.0));
        System.out.println(currency.convert("GBP", "GBP", 100.0));
        System.out.println(currency.convert("GBP", "USD", 100.0));
        System.out.println(currency.convert("EUR", "GBP", 0.0));
        System.out.println(currency.convert("USD", "GBP", 12345.6789));
    }
}
