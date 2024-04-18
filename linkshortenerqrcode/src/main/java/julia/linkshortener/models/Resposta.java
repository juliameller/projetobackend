package julia.linkshortener.models;

public class Resposta {
    private UlvisData link;
    private String qrCodeUrl;

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public Resposta(UlvisData urlOriginal, String qrCodeUrl) {
        this.link = urlOriginal;
        this.qrCodeUrl = qrCodeUrl;
    }

    public UlvisData getLink() {
        return link;
    }

    public void setLink(UlvisData link) {
        this.link = link;
    }
}
