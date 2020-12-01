import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.Array;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void print(CountriesTreeMap<Integer, Country> countriesTreeMap) {
        System.out.println("Running the Level-order Iterator...");
        int i = 1;
        for (Country country : countriesTreeMap) {
            System.out.println(i++ + ". " + country.toString());
        }
    }

    public static void main(String[] args) throws IOException, ParseException {

        CountriesTreeMap<Integer, Country> countriesTreeMap = JsonParser.fill();

        print(countriesTreeMap);

        System.out.println(countriesTreeMap.ceilingEntry(4887).toString());
        System.out.println(countriesTreeMap.flooringEntry(4887).toString());
        System.out.println(countriesTreeMap.lowestConfirmedCases());
        System.out.println(countriesTreeMap.mostConfirmedCases());
        System.out.println(countriesTreeMap.getCountriesWithCasesHigherThan(1_000_000));
        countriesTreeMap.remove(4888);
        print(countriesTreeMap);

        System.out.println(countriesTreeMap.hasKey(48666));
    }
}
