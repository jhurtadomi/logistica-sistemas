package com.logistica.tarifa;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {

    @PostMapping("/calcular")
    public TarifaResponse calcular(@RequestBody TarifaRequest request) {
        double costo = request.getPeso() * 2.5;
        if (request.getDestino().equalsIgnoreCase("internacional")) {
            costo *= 3;
        }
        return new TarifaResponse(request.getDestino(), request.getPeso(), costo);
    }
}