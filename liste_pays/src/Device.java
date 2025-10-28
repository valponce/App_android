import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Device {
    public static void main(String[] args) {
        Set<Currency> currencies = Currency.getAvailableCurrencies();
        List<String> currencyList = new ArrayList<>();

        for (Currency currency : currencies) {
            currencyList.add(currency.getCurrencyCode() + " - " + currency.getDisplayName());
        }
        Collections.sort(currencyList);
        System.out.println("    <array name=\"images\">");
        for (String devise : currencyList) {
            System.out.println("<item>@drawable/image_fr</item>");
        }
        System.out.println("    </array>");

    }
    
        
}
