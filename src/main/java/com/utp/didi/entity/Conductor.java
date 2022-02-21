package com.utp.didi.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "conductores")
public class Conductor {
    @Id
    private Long idConductor;
    private String nombre;
    private String placa;
    private String modeloVehiculo;
    private String colorVehiculo;
    private String pathFoto;
    private LocalDate fechaIngreso;
    private boolean flgAntecedentes;
    private boolean flgLicenciaConducir;
    private boolean flgVehiculo;
}
