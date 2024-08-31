package exercise;

import java.util.Comparator;
import java.util.List;

class App {
    public static void main(String[] args) {

    }

    public static final List<String> buildApartmentsList(List<Home> apartments, int top) {
        return apartments.stream()
                .sorted(Comparator.comparing(x -> x.getArea()))
                .map(x -> x.toString())
                .limit(top)
                .toList();

    }
}

