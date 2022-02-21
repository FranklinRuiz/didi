package com.utp.didi.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class DtoDetalleViaje {
    @NotNull
    private Long idViaje;
    @NotNull
    private String detalle;
}
