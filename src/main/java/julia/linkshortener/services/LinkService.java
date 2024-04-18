package julia.linkshortener.services;

import julia.linkshortener.models.UlvisResponse;

public interface LinkService {
    public UlvisResponse encurtaLink(String link, String custom);
}
