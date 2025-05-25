package com.libcode.dawproject.dawproject.service;

import com.libcode.dawproject.dawproject.model.Metodologia;
import com.libcode.dawproject.dawproject.model.Proyecto;
import com.libcode.dawproject.dawproject.model.Simulacion;
//import com.libcode.dawproject.dawproject.model.Tarea;
import com.libcode.dawproject.dawproject.repository.MetodologiaRepository;
import com.libcode.dawproject.dawproject.repository.ProyectoRepository;
import com.libcode.dawproject.dawproject.repository.SimulacionRepository;
import com.libcode.dawproject.dawproject.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;
    private final MetodologiaRepository metodologiaRepository;
    private final SimulacionRepository simulacionRepository;
  

    public ProyectoService(ProyectoRepository proyectoRepository,
            MetodologiaRepository metodologiaRepository,
            SimulacionRepository simulacionRepository,
            TareaRepository tareaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.metodologiaRepository = metodologiaRepository;
        this.simulacionRepository = simulacionRepository;
    }

    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> obtenerPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    public void guardarProyecto(String nombre, Long metodologiaId, String descripcion) {
        Optional<Metodologia> metodologiaOpt = metodologiaRepository.findById(metodologiaId);

        if (metodologiaOpt.isPresent()) {
            Proyecto nuevoProyecto = new Proyecto();
            nuevoProyecto.setNombre(nombre);
            nuevoProyecto.setMetodologia(metodologiaOpt.get());
            nuevoProyecto.setDescripcion(descripcion);
            proyectoRepository.save(nuevoProyecto);

        } else {
            throw new IllegalArgumentException("Metodología no encontrada con ID: " + metodologiaId);
        }
    }

    // agregado
    public List<Proyecto> obtenerPorMetodologiaId(Long metodologiaId) {
        return proyectoRepository.findByMetodologiaId(metodologiaId);
    }
}