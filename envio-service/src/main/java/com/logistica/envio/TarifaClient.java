package com.logistica.envio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TarifaClient {

    private final RestTemplate restTemplate;

    public TarifaResponse obtenerTarifa(String destino, double peso) {
        TarifaRequest request = new TarifaRequest(destino, peso);
        return restTemplate.postForObject(
                "http://localhost:8082/api/tarifas/calcular",
                request,
                TarifaResponse.class
        );
    }
}