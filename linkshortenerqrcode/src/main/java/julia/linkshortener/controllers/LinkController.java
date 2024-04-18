package julia.linkshortener.controllers;

import julia.linkshortener.models.UlvisResponse;
import julia.linkshortener.models.Solicitacao;
import julia.linkshortener.models.Resposta;
import julia.linkshortener.services.LinkService;
import julia.linkshortener.services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private QRCodeService qrCodeService;
    private ArrayList<Resposta> linkRetornados = new ArrayList<>();

    @GetMapping("/ajuda")
    public Map<String, String> ajuda() {
        Map<String, String> info = new HashMap<>();
         info.put("estudante", "Julia");
         info.put("projeto", "projetobackend");
         return info;
    }

    @GetMapping("/encurtar")
    public ResponseEntity<Object> recupera() {
        return ResponseEntity.status(200).body(linkRetornados);
    }

    @PostMapping("/encurtar")
    public ResponseEntity<Object> encurtar(@RequestBody Solicitacao solicitacao) {
        String urlEncoded = URLEncoder.encode(solicitacao.getLink(), StandardCharsets.UTF_8);
        UlvisResponse ulvisResponse = linkService.encurtaLink(urlEncoded, solicitacao.getCustom());

        if (ulvisResponse.getData() == null || ulvisResponse.getData().getId() == null ||
                ulvisResponse.getData().getUrl() == null || ulvisResponse.getData().getFull() == null) {
            return ResponseEntity.status(400).body("Erro ao encurtar o link.");
        }

        String qrCodeUrl = QRCodeService.generateQRCode(ulvisResponse.getData().getUrl());
        Resposta resposta = new Resposta(ulvisResponse.getData(), qrCodeUrl);

        linkRetornados.add(resposta);
        return ResponseEntity.status(200).body(resposta);
    }
}
