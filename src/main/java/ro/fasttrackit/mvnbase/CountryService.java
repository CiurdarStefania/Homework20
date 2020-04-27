package ro.fasttrackit.mvnbase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class CountryService {
    private final List<Country> countries;

    public CountryService(List<Country> countries) {
        this.countries = new ArrayList<>();
    }

    public List<String> allCountry() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    public List<String> capital(String name) {
        return countries.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .map(Country::getCapital)
                .collect(Collectors.toList());

    }

    public List<Long> population(String name) {
        return countries.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .map(Country::getPopulation)
                .collect(Collectors.toList());

    }
    public List<String> countriesOfContinent(String name){
        return  countries.stream()
                .filter(c-> c.getName().equalsIgnoreCase(name))
                .map(Country::getContinent)
                .collect(Collectors.toList());
    }
     public List<List<String>> neighbours(String name){
         return  countries.stream()
                 .filter(c-> c.getName().equalsIgnoreCase(name))
                 .map(Country::getNeighbours)
                 .collect(Collectors.toList());

     }
     public List<String> countriesPopulation(){
        return countries.stream()
                .filter(country -> country.getPopulation() > 100.000)
                .map(Country::getName)
                .collect(Collectors.toList());
     }
     public List<Country> countriesInContinent(){
     return countries.stream()
             .sorted(Comparator.comparing(Country::getName).thenComparing(Country::getPopulation))
             .collect(Collectors.toList());
     }
     public List<Country> countriesArea(){
        return countries.stream()
                .sorted(Comparator.comparing(Country::getName).thenComparing(Country::getArea))
                .collect(Collectors.toList());
     }
     public Map<String, Long> nameToPopulation(){
        return countries.stream()
                .collect(toMap(Country::getName,Country::getPopulation));
     }
     public Map<String, List<String>> continentName(){
        return countries.stream()
                .collect(toMap(Country::getContinent, c-> List.of(c.getName())));
     }


}
