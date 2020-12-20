package Generic_ADTs.Treemap;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class MainForTreeMap {
    public static void print(GenericsTreeMap<Integer, Country> genericsTreeMap) {
        System.out.println("Running the Level-order Iterator...");
        int i = 1;
        for (Country country : genericsTreeMap) {
            System.out.println(i++ + ". " + country.toString());
        }
    }

    public static void main(String[] args) throws IOException, ParseException {

        GenericsTreeMap<Integer, Country> genericsTreeMap = JsonParser.fill();

        print(genericsTreeMap);

        System.out.println(genericsTreeMap.ceilingEntry(4887).toString());
        System.out.println(genericsTreeMap.flooringEntry(4887).toString());
        System.out.println(genericsTreeMap.lowestConfirmedCases());
        System.out.println(genericsTreeMap.mostConfirmedCases());
        System.out.println(genericsTreeMap.getCountriesWithCasesHigherThan(1_000_000));
        genericsTreeMap.remove(4888);
        print(genericsTreeMap);

        System.out.println(genericsTreeMap.hasKey(48666));
    }
}
