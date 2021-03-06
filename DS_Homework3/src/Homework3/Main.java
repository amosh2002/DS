package Homework3;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;

public class Main {

    public static Country searchSmallestBy(CountriesHashMap<String, Country> countriesHashMap, Comparator<Country> comparator) {
        Country initial = null;
        for (Country country : countriesHashMap) {
            if (initial == null) {
                initial = country;
                continue;
            }
            if (comparator.compare(initial, country) > 0) {
                initial = country;
            }
        }
        return initial;
    }

    public static void main(String[] args) throws IOException, ParseException {
        CountriesHashMap<String, Country> countriesHashMap = JsonParser.fill();

        Country testCountry = searchSmallestBy(countriesHashMap, new Country.CountriesCasesComparator());
        if (testCountry.getTotalConfirmed() == 0) {
            System.out.println("Smallest Cases Function Works!");
        } else {
            System.out.println("Smallest Cases Function Doesn't Work!");
        }
        System.out.println(testCountry);
        System.out.println("----------");

        System.out.println("Running the Value Iterator...");
        int i = 1;
        Iterator<Country> iterator = countriesHashMap.iterator();
        while (iterator.hasNext()) {
            System.out.print(i++ + ". ");
            System.out.println(iterator.next().toString());
        }
        System.out.println("Value Iterator Complete!");
        System.out.println();

        System.out.println("Running the Level-order Iterator...");
        i = 1;
        Iterator<Country> levelOrderIterator = countriesHashMap.levelOrderIterator();
        while (levelOrderIterator.hasNext()) {
            System.out.print(i++ + ". ");
            System.out.println(levelOrderIterator.next().toString());
        }
        System.out.println("Level-order Iterator Complete!");


    }
}
