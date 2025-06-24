package com.microservicio_contenido_evaluaciones.edutech_innovators.controller;

import com.microservicio_contenido_evaluaciones.edutech_innovators.hateoas.EvaluacionModelAssembler;
import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Evaluacion;
import com.microservicio_contenido_evaluaciones.edutech_innovators.service.EvaluacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/evaluaciones")
@Tag(name = "Evaluaciones", description = ("Permite crear, eliminar, modificar y listar evaluacines"))
public class EvaluacionControllerV2 {

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired  
    private EvaluacionModelAssembler assembler;

    @PostMapping
    @Operation(summary = "Crear Evaluacion", description = "Permite Crear una Nueva Evaluacion")
    public EntityModel<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return assembler.toModel(evaluacionService.crearEvaluacion(evaluacion));
    }

    @PutMapping("/{evaluacionId}")
    @Operation(summary = "Actualizar Evaluacion", description = "Permite actualizar evaluacion existentes")
    public EntityModel<Evaluacion> actualizarEvaluacion(@PathVariable Long evaluacionId, @RequestBody Evaluacion evaluacion) {
        return assembler.toModel(evaluacionService.actualizarEvaluacion(evaluacionId, evaluacion));
    }

    @DeleteMapping("/{evaluacionId}")
    @Operation(summary = "Eliminar Evaluacion por ID", description = "Permite Eliminar Evaluacion Por su ID ")
    public void eliminarEvaluacion(@PathVariable Long evaluacionId) {
        evaluacionService.eliminarEvaluacion(evaluacionId);
    }

    @GetMapping("/{evaluacionId}")
    @Operation(summary = "Obtener Evaluacion por ID", description = "Permite obtener evaluacion por ID")
    public EntityModel<Evaluacion> obtenerPorId(@PathVariable Long evaluacionId) {
        return assembler.toModel(evaluacionService.obtenerPorId(evaluacionId));
    }

    @GetMapping
    @Operation(summary = "Lista de todas las Evaluaciones", description = "Permite listar todas las evaluacioens")
    public CollectionModel<EntityModel<Evaluacion>> listarEvaluaciones() {
        List<EntityModel<Evaluacion>> evaluaciones = evaluacionService.listarEvaluaciones().stream()
        .map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(evaluaciones, 
            linkTo(methodOn(EvaluacionControllerV2.class).listarEvaluaciones()).withSelfRel()); // Cambiar a EvaluacionControllerV2
}

    @GetMapping("/curso/{cursoId}")
    @Operation(summary = "Lista todas las evaluaciones por curso", description = "Permite Listar todas las evaluaciones por curso")
    public List<Evaluacion> listarPorCurso(@PathVariable Long cursoId) {
        return evaluacionService.listarPorCursoId(cursoId);
    }

    @GetMapping("/contenido/{contenidoId}")
    @Operation(summary = "Lista Evaluaciones por contenido", description = "Permite Listar evaluaciones por contenido creado")
    public List<Evaluacion> listarPorContenido(@PathVariable Long contenidoId) {
        return evaluacionService.listarPorContenidoId(contenidoId);
    }
}