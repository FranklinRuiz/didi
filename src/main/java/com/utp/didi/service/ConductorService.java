package com.utp.didi.service;

import com.utp.didi.entity.Conductor;
import com.utp.didi.repository.ConductorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConductorService {

    private final ConductorRepository conductorRepository;

    public Conductor datosConductor(Long idConductor) throws Exception {
        Optional<Conductor> conductor = Optional.ofNullable(conductorRepository.findById(idConductor)).orElseThrow(() -> new Exception("Conductor no encontrado"));
        return conductor.get();
    }

    public ByteArrayResource fotoConductor(Long idConductor) throws IOException {
        File file = null;
        ByteArrayResource resource = null;

        Optional<Conductor> p = conductorRepository.findById(idConductor);
        if (p.isPresent()) {
            file = new File(p.get().getPathFoto());
            Path path = Paths.get(file.getAbsolutePath());
            resource = new ByteArrayResource(Files.readAllBytes(path));
        }

        return resource;
    }
}
