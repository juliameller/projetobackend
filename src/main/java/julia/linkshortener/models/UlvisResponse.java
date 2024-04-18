package julia.linkshortener.models;

public class UlvisResponse {
    private Boolean success;
    private UlvisData data;

    public UlvisResponse(Boolean success, UlvisData data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public UlvisData getData() {
        return data;
    }

    public void setData(UlvisData data) {
        this.data = data;
    }
}
