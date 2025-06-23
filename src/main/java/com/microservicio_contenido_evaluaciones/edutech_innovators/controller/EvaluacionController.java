package com.microservicio_contenido_evaluaciones.edutech_innovators.controller;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Evaluacion;
import com.microservicio_contenido_evaluaciones.edutech_innovators.service.EvaluacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marca esta clase como un controlador REST
@RequestMapping("/api/evaluaciones") // Ruta base para todos los endpoints de evaluaciones
@Tag(name = "Evaluaciones", description = ("Permite crear, eliminar, modificar y listar evaluacines"))
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService; // Inyección del servicio de evaluaciones

    @PostMapping // Crear nueva evaluación
    @Operation(summary = "Crear Evaluacion", description = "Permite Crear una Nueva Evaluacion")
    public Evaluacion crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.crearEvaluacion(evaluacion);
    }

    @PutMapping("/{evaluacionId}") // Actualizar evaluación existente
    @Operation(summary = "Actualizar Evaluacion", description = "Permite actualizar evaluacion existentes")
    public Evaluacion actualizarEvaluacion(@PathVariable Long evaluacionId, @RequestBody Evaluacion evaluacion) {
        return evaluacionService.actualizarEvaluacion(evaluacionId, evaluacion);
    }

    @DeleteMapping("/{evaluacionId}") // Eliminar evaluación por ID
    @Operation(summary = "Eliminar Evaluacion por ID", description = "Permite Eliminar Evaluacion Por su ID ")
    public void eliminarEvaluacion(@PathVariable Long evaluacionId) {
        evaluacionService.eliminarEvaluacion(evaluacionId);
    }

    @GetMapping("/{evaluacionId}") // Obtener evaluación por ID
    @Operation(summary = "Obtener Evaluacion por ID", description = "Permite obtener evaluacion por ID")
    public Evaluacion obtenerPorId(@PathVariable Long evaluacionId) {
        return evaluacionService.obtenerPorId(evaluacionId);
    }

    @GetMapping // Listar todas las evaluaciones
    @Operation(summary = "Lista de todas las Evaluaciones", description = "Permite listar todas las evaluacioens")
    public List<Evaluacion> listarEvaluaciones() {
        return evaluacionService.listarEvaluaciones();
    }

    @GetMapping("/curso/{cursoId}") // Listar evaluaciones por curso
    @Operation(summary = "Lista todas las evaluaciones por curso", description = "Permite Listar todas las evaluaciones por curso")
    public List<Evaluacion> listarPorCurso(@PathVariable Long cursoId) {
        return evaluacionService.listarPorCursoId(cursoId);
    }
    
    @GetMapping("/contenido/{contenidoId}") // Listar evaluaciones por contenido
    @Operation(summary = "Lista Evaluaciones por contenido", description = "Permite Listar evaluaciones por contenido creado")
    public List<Evaluacion> listarPorContenido(@PathVariable Long contenidoId) {
        return evaluacionService.listarPorContenidoId(contenidoId);
    }
} 
