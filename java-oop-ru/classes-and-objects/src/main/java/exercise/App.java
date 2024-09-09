package exercise;

import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {

    public static void main(String[] args) {
    }

    public static List<String> buildApartmentsList(List<Home> apartments, Integer number) {
        return apartments.stream()
                .sorted(Comporator.comparing(x - > x.getArea()))
                .map(x.toString())
                .limit(number)
                .toList();
    }
}
// END
