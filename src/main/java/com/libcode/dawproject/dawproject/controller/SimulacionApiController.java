package com.libcode.dawproject.dawproject.controller;

import com.libcode.dawproject.dawproject.dto.CrearSimulacionRequest;
import com.libcode.dawproject.dawproject.model.Proyecto;
import com.libcode.dawproject.dawproject.model.Simulacion;
import com.libcode.dawproject.dawproject.repository.ProyectoRepository;
import com.libcode.dawproject.dawproject.repository.SimulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/simulaciones")
public class SimulacionApiController {

    @Autowired
    private SimulacionRepository simulacionRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @PostMapping
    public ResponseEntity<Simulacion> crearSimulacion(@RequestBody CrearSimulacionRequest request) {
        Optional<Proyecto> proyectoOpt = proyectoRepository.findById(request.getProyectoId());

        if (proyectoOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Simulacion simulacion = new Simulacion(
                proyectoOpt.get(),
                request.getTiempoEstimado(),
                request.getCostoEstimado(),
                request.getCalidadEstimada()
        );

        Simulacion guardada = simulacionRepository.save(simulacion);
        return ResponseEntity.ok(guardada);
    }
}

