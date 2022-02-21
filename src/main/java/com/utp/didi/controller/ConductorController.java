package com.utp.didi.controller;

import com.utp.didi.config.ResponseHandler;
import com.utp.didi.entity.Conductor;
import com.utp.didi.service.ConductorService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/conductor")
public class ConductorController {

    private final ConductorService conductorService;

    @GetMapping("/datos/{idConductor}")
    public ResponseEntity<Object> datosConductor(@PathVariable Long idConductor) {
        try {
            Conductor conductor = conductorService.datosConductor(idConductor);
            return ResponseHandler.generateResponse("busqueda realizada con éxito!", HttpStatus.OK, conductor);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/foto/{idConductor}")
    public ResponseEntity<?> foto(@PathVariable Long idConductor) {
        ByteArrayResource resource = null;
        try {
            resource = conductorService.fotoConductor(idConductor);
            if (resource == null) {
                return ResponseHandler.generateResponse("foto no encontrado", HttpStatus.INTERNAL_SERVER_ERROR, null);
            }
        } catch (Exception e) {
            return new ResponseEntity<ByteArrayResource>(resource, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=foto.jpg")
                .contentType(MediaType.parseMediaType("image/jpeg"))
                //.contentLength(resource.contentLength())
                .body(resource);
    }
}
