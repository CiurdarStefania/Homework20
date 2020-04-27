package ro.fasttrackit.mvnbase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryReader {
    private Country readCountry(String line){
        String[] tokens = line.split("[|]");
        return new Country(
                tokens[0],
                tokens[1],
                Long.parseLong(tokens[2]),
                Long.parseLong(tokens[3]),
                tokens[4],
                parseNeighbours(tokens[5])
        );
    }

    private List<String> parseNeighbours(String neighbours) {
        Scanner scanner = new Scanner(neighbours);
        scanner.useDelimiter("~");
        List<String> result = new ArrayList<>();
        while (scanner.hasNext()){
            result.add(scanner.next());
        }
        return result;
    }
}
