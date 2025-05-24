package com.microservicio_contenido_evaluaciones.edutech_innovators.repository;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marca esta interfaz como un componente Spring para acceso a datos
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {

    // Método personalizado para buscar todos los contenidos por el ID del curso asociado
    List<Contenido> findByCursoId(Long cursoId);
} 

