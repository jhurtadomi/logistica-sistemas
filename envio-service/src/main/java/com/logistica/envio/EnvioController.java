package com.logistica.envio;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envios")
@RequiredArgsConstructor
public class EnvioController {

    private final EnvioService envioService;

    @PostMapping
    public EnvioCalculadoEvent crearEnvio(@RequestBody EnvioRequest request) {
        return envioService.procesarEnvio(request.getDestino(), request.getPeso());
    }
}