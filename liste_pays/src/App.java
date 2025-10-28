import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        String[] locales = Locale.getISOCountries();
        List<String> countries = new ArrayList<>();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            countries.add(obj.getDisplayCountry());
        }
        Collections.sort(countries);
        System.out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        System.out.println("<resources>");
        System.out.println("    <string-array name=\"liste_pays\">");
        for (String country : countries) {
            System.out.println("        <item>" + country + "</item>");
        }
        System.out.println("    </string-array>");
        System.out.println("</resources>");
    }
}