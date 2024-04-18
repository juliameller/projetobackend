package julia.linkshortener.services;

import julia.linkshortener.models.UlvisResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ViaLinkService implements LinkService {
    private RestClient client = RestClient.create("https://ulvis.net/API/write/get");

    public ViaLinkService() {
        this.client = RestClient.create("https://ulvis.net/API/write/get");
    }
    @Override
    public UlvisResponse encurtaLink(String link, String custom) {
        return client
                .get()
                .uri("?url={link}&custom={custom}", link, custom)
                .retrieve()
                .body(UlvisResponse.class);
    }
}
