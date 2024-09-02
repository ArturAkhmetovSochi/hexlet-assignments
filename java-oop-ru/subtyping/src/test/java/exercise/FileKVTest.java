package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void fileVkTest() {
        KeyValueStorage kvs = new FileKV(filepath.toString(), Map.of("k1", "v1", "k2", "v2"));
        kvs.set("k3", "v3");
        assertThat(kvs.toMap()).isEqualTo(Map.of("k1", "v1", "k2", "v2", "k3", "v3"));
        kvs.unset("k3");
        assertThat(kvs.toMap()).isEqualTo(Map.of("k1", "v1", "k2", "v2"));
    }
    // END
}
