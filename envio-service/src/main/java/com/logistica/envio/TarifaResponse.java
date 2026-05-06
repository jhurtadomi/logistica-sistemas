package com.logistica.envio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarifaResponse {
    private String destino;
    private double peso;
    private double costo;
}