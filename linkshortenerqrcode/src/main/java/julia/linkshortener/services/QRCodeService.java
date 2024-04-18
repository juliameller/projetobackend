package julia.linkshortener.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QRCodeService {
    private static final String QRCODE_API_URL = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&";

    private final RestTemplate restTemplate;

    public QRCodeService() {
        this.restTemplate = new RestTemplate();
    }

    public static String generateQRCode(String link) {
        String qrCodeUrl = QRCODE_API_URL + "data=" + link;
        return qrCodeUrl;
    }
}
