package com.microservicio_contenido_evaluaciones.edutech_innovators.repository;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Indica que esta interfaz es un componente de acceso a datos
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {

    // Encuentra evaluaciones asociadas a un curso
    List<Evaluacion> findByCursoId(Long cursoId);

    // Encuentra evaluaciones asociadas a un contenido específico
    List<Evaluacion> findByContenidoId(Long contenidoId);
} 
