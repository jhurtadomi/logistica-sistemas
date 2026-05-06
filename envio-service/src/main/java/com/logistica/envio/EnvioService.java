package com.logistica.envio;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnvioService {

    private final TarifaClient tarifaClient;
    private final RabbitTemplate rabbitTemplate;

    public EnvioCalculadoEvent procesarEnvio(String destino, double peso) {
        // 1. Orquestación SÍNCRONA: llama a tarifa-service
        TarifaResponse tarifa = tarifaClient.obtenerTarifa(destino, peso);

        // 2. Construye el evento
        EnvioCalculadoEvent evento = new EnvioCalculadoEvent(
                UUID.randomUUID().toString(),
                destino,
                peso,
                tarifa.getCosto()
        );

        // 3. Coreografía ASÍNCRONA: publica evento a RabbitMQ
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                evento
        );

        return evento;
    }
}