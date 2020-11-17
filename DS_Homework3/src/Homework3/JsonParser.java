package Homework3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class JsonParser {

    public static CountriesHashMap<String,Country> fill() throws IOException, ParseException {
        // parsing file "CountryData.json"
        Object obj = new JSONParser().parse(new FileReader("CountryData.json"));
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        // getting the array of countries, using the key "Countries"
        JSONArray countriesArr = (JSONArray) jo.get("Countries");

        CountriesHashMap<String, Country> countriesHashMap = new CountriesHashMap<>();
        Iterator iterator = countriesArr.iterator();
        Iterator<Map.Entry> iterator1;
        while (iterator.hasNext()) {
            Country country = new Country();
            iterator1 = ((Map) iterator.next()).entrySet().iterator();
            while (iterator1.hasNext()) {
                Map.Entry pair = iterator1.next();
                switch ((String) pair.getKey()) {
                    case "Country":
                        country.setCountry((String) pair.getValue());
                        break;
                    case "CountryCode":
                        country.setCountryCode((String) pair.getValue());
                        break;
                    case "Slug":
                        country.setSlug((String) pair.getValue());
                        break;
                    case "NewConfirmed":
                        country.setNewConfirmed(Integer.parseInt(pair.getValue().toString()));
                        break;
                    case "TotalConfirmed":
                        country.setTotalConfirmed(Integer.parseInt(pair.getValue().toString()));
                        break;
                    case "NewDeaths":
                        country.setNewDeaths(Integer.parseInt(pair.getValue().toString()));
                        break;
                    case "TotalDeaths":
                        country.setTotalDeaths(Integer.parseInt(pair.getValue().toString()));
                        break;
                    case "NewRecovered":
                        country.setNewRecovered(Integer.parseInt(pair.getValue().toString()));
                        break;
                    case "TotalRecovered":
                        country.setTotalRecovered(Integer.parseInt(pair.getValue().toString()));
                        break;
                    case "Date":
                        country.setDate((String) pair.getValue());
                        break;
                }
            }
            countriesHashMap.put(country.getCountryCode(), country);
        }

        return countriesHashMap;

    }
}
