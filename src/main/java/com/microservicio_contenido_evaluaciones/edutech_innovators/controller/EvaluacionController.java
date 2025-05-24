package com.microservicio_contenido_evaluaciones.edutech_innovators.controller;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Evaluacion;
import com.microservicio_contenido_evaluaciones.edutech_innovators.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marca esta clase como un controlador REST
@RequestMapping("/api/evaluaciones") // Ruta base para todos los endpoints de evaluaciones
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService; // Inyección del servicio de evaluaciones

    @PostMapping // Crear nueva evaluación
    public Evaluacion crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.crearEvaluacion(evaluacion);
    }

    @PutMapping("/{evaluacionId}") // Actualizar evaluación existente
    public Evaluacion actualizarEvaluacion(@PathVariable Long evaluacionId, @RequestBody Evaluacion evaluacion) {
        return evaluacionService.actualizarEvaluacion(evaluacionId, evaluacion);
    }

    @DeleteMapping("/{evaluacionId}") // Eliminar evaluación por ID
    public void eliminarEvaluacion(@PathVariable Long evaluacionId) {
        evaluacionService.eliminarEvaluacion(evaluacionId);
    }

    @GetMapping("/{evaluacionId}") // Obtener evaluación por ID
    public Evaluacion obtenerPorId(@PathVariable Long evaluacionId) {
        return evaluacionService.obtenerPorId(evaluacionId);
    }

    @GetMapping // Listar todas las evaluaciones
    public List<Evaluacion> listarEvaluaciones() {
        return evaluacionService.listarEvaluaciones();
    }

    @GetMapping("/curso/{cursoId}") // Listar evaluaciones por curso
    public List<Evaluacion> listarPorCurso(@PathVariable Long cursoId) {
        return evaluacionService.listarPorCursoId(cursoId);
    }

    @GetMapping("/contenido/{contenidoId}") // Listar evaluaciones por contenido
    public List<Evaluacion> listarPorContenido(@PathVariable Long contenidoId) {
        return evaluacionService.listarPorContenidoId(contenidoId);
    }
} 
