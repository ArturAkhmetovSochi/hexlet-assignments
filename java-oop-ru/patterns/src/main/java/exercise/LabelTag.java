package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String input;
    private TagInterface tag;

    public LabelTag(String input, TagInterface tag) {
        this.tag = tag;
        this.input = input;
    }

    @Override
    public String render() {
        String htmlTag = tag.render();
        return "<label>" + input + htmlTag + "</label>";
                // <label>Press Submit<input type="submit" value="Save"></label>
    }
}
// END
