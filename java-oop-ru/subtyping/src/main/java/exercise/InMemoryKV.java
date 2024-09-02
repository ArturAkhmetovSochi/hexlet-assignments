package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {

    private Map<String, String> data = new HashMap<>();

    public InMemoryKV(Map<String, String> data) {
        this.data.putAll(data);
    }
    @Override
    public void set(String key, String value) {
        this.data.put(key, value);
    }
    @Override
    public void unset(String key) {
        this.data.remove(key);
    }
    @Override
    public String get(String key, String defaulValue) {
        return this.data.getOrDefault(key, defaulValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.data);
    }


}


// END
