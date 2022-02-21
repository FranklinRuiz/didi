package com.utp.didi.dto;

import lombok.Data;

@Data
public class DtoMapaViaje {
    private String mapa;
    private String origenViaje;
    private String origenLat;
    private String origenLog;
    private String destinoViaje;
    private String destinoLat;
    private String destinoLog;
}
