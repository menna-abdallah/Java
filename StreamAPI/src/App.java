import lab.dao.InMemoryWorldDao;
import lab.domain.City;
import lab.domain.Country;

import java.util.*;

public class App {

 
    public static void main(String[] args) {
    
        InMemoryWorldDao worldDao = InMemoryWorldDao.getInstance(); // get instance from InMemoryWorldDao class
        Map<String, Country> countries = worldDao.getCountries(); // creat a map of countries from the instance
        Set<String> continents = worldDao.getContinents();
        Map<String, City> highestPopulatedCitiesforCountry = new HashMap<>();
        Map<String, City> highestPopulatedCitiesforcontinent = new HashMap<>();
        
       
        // Find the highest populated city of each country

        for (Country country : countries.values()) {
            List<City> citiesInCountry = country.getCities();
            City highestPopulatedCity = citiesInCountry.stream()
                    .max(Comparator.comparingInt(City::getPopulation))
                    .orElse(null);
        
            if (highestPopulatedCity != null) {
                highestPopulatedCitiesforCountry.put(country.getCode(), highestPopulatedCity);
            }
        }        
    highestPopulatedCitiesforCountry.forEach((key, val) -> {
        System.out.println("countryCode: " + key + "     cityName: " + val.getName() + "    population:"+val.getPopulation());
    });

// Find the most populated city of each continent
for (String continent : continents) {
    List<Country> countriesInContinent = worldDao.findCountriesByContinent(continent);

    City mostPopulatedCity = countriesInContinent.stream()
            .flatMap(country -> country.getCities().stream())
            .max(Comparator.comparingInt(City::getPopulation))
            .orElse(null);

    if (mostPopulatedCity != null) {
        highestPopulatedCitiesforcontinent.put(continent, mostPopulatedCity);
    }
}

    highestPopulatedCitiesforcontinent.forEach((key, val) -> {
        System.out.println("continentName: " + key + "     cityName: " + val.getName() + "    population:"+val.getPopulation());
    });

    // Find the highest populated capital city
List<City> capitals = new ArrayList<>();
countries.values().forEach(country -> 
        capitals.add(worldDao.findCityById(country.getCapital())));
        
City highest = capitals.stream().filter(Objects::nonNull)
                    .max(Comparator.comparing(City::getPopulation))
                    .orElse(null);
System.out.println(highest.getName());
System.out.println(highest.getPopulation());

    
    }
}
