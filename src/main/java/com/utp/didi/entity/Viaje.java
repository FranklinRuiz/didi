package com.utp.didi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "viajes")
public class Viaje {
    @Id
    private Long idViaje;
    @JsonIgnore
    private Long idConductor;
    private String origenViaje;
    private String origenLat;
    private String origenLog;
    private String destinoViaje;
    private String destinoLat;
    private String destinoLog;
    private float precio;
    private Integer calificacion;
    private String detalle;
    private LocalDateTime fechaViaje;
}
