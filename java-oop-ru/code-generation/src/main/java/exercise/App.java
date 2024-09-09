package exercise;

import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.Files.readString;

// BEGIN
public class App {
    public static void main(String[] args) {
    }

    @SneakyThrows
    public static void save(Path path, Car car) {
        FileWriter writer = new FileWriter(path.toFile(), true);
        writer.write(car.serialize());
        writer.close();
    }

    public static Car extract(Path path) throws IOException {
        String content =  Files.readString(path);
        return Car.deserialize(content);
    }


}
// END
