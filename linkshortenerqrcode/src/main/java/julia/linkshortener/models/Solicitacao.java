package julia.linkshortener.models;

public class Solicitacao {
    private String link;
    private String custom;

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public Solicitacao(String link, String custom) {
        this.link = link;
        this.custom = custom;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Solicitacao() {
    }

}
