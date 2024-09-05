package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {
    protected String tagName;
    protected Map<String, String> map;

    Tag(String tagName, Map<String, String> map) {
        this.tagName = tagName;
        this.map = map;
    }

    protected Tag() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.tagName);
        for (Map.Entry e: map.entrySet()) {
            sb.append(" ").append(e.getKey()).append("=\"").append(e.getValue()).append("\"");
        }
        return sb.append(">").toString();
    }

}
// END
