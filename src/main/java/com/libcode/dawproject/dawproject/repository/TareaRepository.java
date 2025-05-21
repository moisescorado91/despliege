package com.libcode.dawproject.dawproject.repository;

import com.libcode.dawproject.dawproject.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findBySimulacionId(Long simulacionId);
}

