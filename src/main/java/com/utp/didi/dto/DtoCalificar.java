package com.utp.didi.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class DtoCalificar {
    @NotNull
    private Long idViaje;
    @NotNull
    private Integer calificar;
}
