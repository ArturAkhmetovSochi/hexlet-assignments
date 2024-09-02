package exercise;

import java.util.Map.Entry;


// BEGIN
public class App {

    public static void main(String[] args) {
    }

    public static final void swapKeyValue(KeyValueStorage kvs) {
        for (Entry entry: kvs.toMap().entrySet()) {
            kvs.unset((String) entry.getKey());
            kvs.set((String) entry.getValue(), entry.getKey().toString());
        }
    }


}
// END
