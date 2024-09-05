package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PairedTag extends Tag {

    private final String text;
    private final List<Tag> tags;

    PairedTag(String tagName, Map<String, String> map, String text, List<Tag> tags) {
        this.tagName = tagName;
        this.map = map;
        this.text = text;
        this.tags = tags;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(this.tags.stream().map(x -> x.toString()).collect(Collectors.joining()))
                .append(text)
                .append("</")
                .append(tagName)
                .append(">");
        return sb.toString();
    }
}
// END
