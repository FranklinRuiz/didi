package com.utp.didi.controller;

import com.utp.didi.config.ResponseHandler;
import com.utp.didi.dto.DtoCalificar;
import com.utp.didi.dto.DtoDetalleViaje;
import com.utp.didi.dto.DtoMapaViaje;
import com.utp.didi.entity.Viaje;
import com.utp.didi.service.ViajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/viaje")
public class ViajeController {

    private final ViajeService viajeService;

    @PostMapping("/calificar-viaje")
    public ResponseEntity<Object> calificarViaje(@RequestBody DtoCalificar calificar) {
        try {
            Boolean rpta = viajeService.calificarViaje(calificar);
            return ResponseHandler.generateResponse("calificacion realizada con éxito!", HttpStatus.OK, rpta);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/datos-viaje")
    public ResponseEntity<Object> datosViaje() {
        try {
            List<Viaje> lista = viajeService.datosViaje();
            return ResponseHandler.generateResponse("consulta realizada con éxito!", HttpStatus.OK, lista);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("mapa-viaje/{idViaje}")
    public ResponseEntity<Object> mapaViaje(@PathVariable Long idViaje) {
        try {
            DtoMapaViaje rpta = viajeService.mapaViaje(idViaje);
            return ResponseHandler.generateResponse("mapa consultada con éxito!", HttpStatus.OK, rpta);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/guardar-detalle-viaje")
    public ResponseEntity<Object> datalleViaje(@RequestBody DtoDetalleViaje viaje) {
        try {
            boolean rpta = viajeService.detalleViaje(viaje);
            return ResponseHandler.generateResponse("detalle registrado con éxito!", HttpStatus.OK, rpta);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
