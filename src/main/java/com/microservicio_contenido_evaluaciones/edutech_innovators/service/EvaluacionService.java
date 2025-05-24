package com.microservicio_contenido_evaluaciones.edutech_innovators.service;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Evaluacion;
import com.microservicio_contenido_evaluaciones.edutech_innovators.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Clase de servicio que contiene la lógica para manejar evaluaciones
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository; // Inyección del repositorio de evaluaciones

    // Guarda una nueva evaluación
    public Evaluacion crearEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    // Actualiza una evaluación existente
    public Evaluacion actualizarEvaluacion(Long evaluacionId, Evaluacion evaluacion) {
        Evaluacion existente = evaluacionRepository.findById(evaluacionId)
                .orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));

        existente.setTitulo(evaluacion.getTitulo());
        existente.setInstrucciones(evaluacion.getInstrucciones());
        existente.setPuntajeMaximo(evaluacion.getPuntajeMaximo());
        existente.setCursoId(evaluacion.getCursoId());
        existente.setContenidoId(evaluacion.getContenidoId());

        return evaluacionRepository.save(existente);
    }

    // Elimina una evaluación por su ID
    public void eliminarEvaluacion(Long evaluacionId) {
        evaluacionRepository.deleteById(evaluacionId);
    }

    // Obtiene una evaluación por su ID
    public Evaluacion obtenerPorId(Long evaluacionId) {
        return evaluacionRepository.findById(evaluacionId)
                .orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));
    }

    // Lista todas las evaluaciones
    public List<Evaluacion> listarEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    // Lista evaluaciones asociadas a un curso
    public List<Evaluacion> listarPorCursoId(Long cursoId) {
        return evaluacionRepository.findByCursoId(cursoId);
    }

    // Lista evaluaciones asociadas a un contenido específico
    public List<Evaluacion> listarPorContenidoId(Long contenidoId) {
        return evaluacionRepository.findByContenidoId(contenidoId);
    }
} 
