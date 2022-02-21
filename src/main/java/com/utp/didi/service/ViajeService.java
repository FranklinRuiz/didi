package com.utp.didi.service;

import com.utp.didi.dto.DtoCalificar;
import com.utp.didi.dto.DtoDetalleViaje;
import com.utp.didi.dto.DtoMapaViaje;
import com.utp.didi.entity.Viaje;
import com.utp.didi.repository.ViajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ViajeService {

    private final ViajeRepository viajeRepository;

    public boolean calificarViaje(DtoCalificar calificar) throws Exception {
        boolean rpta = false;
        Optional<Viaje> viaje = Optional.ofNullable(viajeRepository.findById(calificar.getIdViaje()).orElseThrow(() -> new Exception("viaje no encontrado para calificar")));
        if (viaje.isPresent()) {
            viaje.get().setCalificacion(calificar.getCalificar());
            rpta = (viajeRepository.save(viaje.get())) != null ? true : false;
        }
        return rpta;
    }

    public List<Viaje> datosViaje() {
        return viajeRepository.findAll();
    }

    public DtoMapaViaje mapaViaje(Long idViaje) throws Exception {
        DtoMapaViaje dto = new DtoMapaViaje();
        Optional<Viaje> viaje = viajeRepository.findById(idViaje);
        if (viaje.isPresent()) {
            dto.setMapa("https://www.google.com/maps/dir/" + viaje.get().getOrigenViaje() + "/" + viaje.get().getDestinoViaje() + "/@" + viaje.get().getOrigenLat() + "," + viaje.get().getOrigenLog());
            dto.setOrigenViaje(viaje.get().getOrigenViaje());
            dto.setOrigenLat(viaje.get().getOrigenLat());
            dto.setOrigenLog(viaje.get().getOrigenLog());
            dto.setDestinoViaje(viaje.get().getDestinoViaje());
            dto.setDestinoLat(viaje.get().getDestinoLat());
            dto.setDestinoLog(viaje.get().getDestinoLog());
        } else {
            Optional.ofNullable(viaje).orElseThrow(() -> new Exception("Mapa no encontrado"));
        }
        return dto;
    }

    public boolean detalleViaje(DtoDetalleViaje dto) throws Exception {
        boolean rpta = false;
        Optional<Viaje> viaje = Optional.ofNullable(viajeRepository.findById(dto.getIdViaje()).orElseThrow(() -> new Exception("viaje no encontrado para detalle")));
        if (viaje.isPresent()) {
            viaje.get().setDetalle(dto.getDetalle());
            rpta = (viajeRepository.save(viaje.get())) != null ? true : false;
        }
        return rpta;
    }
}
