package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private String path;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        Utils.writeFile(this.path, Utils.serialize(map));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> map = Utils.deserialize(Utils.readFile(this.path));
        map.put(key, value);
        Utils.writeFile(this.path, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        Map<String, String> map = Utils.deserialize(Utils.readFile(this.path));
        map.remove(key);
        Utils.writeFile(this.path, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> map = Utils.deserialize(Utils.readFile(this.path));
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.deserialize(Utils.readFile(this.path));
    }
}
// END
