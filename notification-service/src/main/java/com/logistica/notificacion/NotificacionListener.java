package com.logistica.notificacion;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacionListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void recibirEvento(EnvioCalculadoEvent evento) {
        System.out.println("==============================");
        System.out.println("NOTIFICACIÓN RECIBIDA");
        System.out.println("ID Envío   : " + evento.getIdEnvio());
        System.out.println("Destino    : " + evento.getDestino());
        System.out.println("Peso       : " + evento.getPeso() + " kg");
        System.out.println("Costo      : S/. " + evento.getCostoCalculado());
        System.out.println("==============================");
    }
}