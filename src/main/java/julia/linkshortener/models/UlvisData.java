package julia.linkshortener.models;

public class UlvisData {

    private String id;
    private String url;
    private String full;

    public UlvisData(String id, String url, String full) {
        this.id = id;
        this.url = url;
        this.full = full;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }
}
