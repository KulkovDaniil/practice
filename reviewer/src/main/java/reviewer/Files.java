package reviewer;

public class Files {
    private String name;
    private boolean link;

    public Files(String name, boolean link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public boolean isLink() {
        return link;
    }
}
