package Generic_ADTs.Treemap;

import java.util.Comparator;

/*
   "Country": "Afghanistan",
           "CountryCode": "AF",
           "Slug": "afghanistan",
           "NewConfirmed": 132,
           "TotalConfirmed": 41633,
           "NewDeaths": 5,
           "TotalDeaths": 1541,
           "NewRecovered": 16,
           "TotalRecovered": 34342,
           "Date": "2020-11-03T09:29:07Z",
           "Premium": {}

    */
public class Country {
    private String country;
    private String countryCode;
    private String slug;
    private int newConfirmed;
    private int totalConfirmed;
    private int newDeaths;
    private int totalDeaths;
    private int newRecovered;
    private int totalRecovered;
    private String date;


    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setNewConfirmed(int newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public void setNewRecovered(int newRecovered) {
        this.newRecovered = newRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public String getDate() {
        return date;
    }

    public String toString() {
        return getCountryCode() + " : " + getCountry() + ", Total Cases: " + totalConfirmed;
    }

    public static class CountriesCasesComparator implements Comparator<Country> {
        @Override
        public int compare(Country o1, Country o2) {
            return o1.totalConfirmed - o2.totalConfirmed;
        }
    }
}
