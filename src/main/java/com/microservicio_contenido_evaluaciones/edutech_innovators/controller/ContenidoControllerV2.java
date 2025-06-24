package com.microservicio_contenido_evaluaciones.edutech_innovators.controller;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Contenido;
import com.microservicio_contenido_evaluaciones.edutech_innovators.service.ContenidoService;

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
@RequestMapping("/api/v2/contenidos")
@Tag(name = "Contenidos", description = ("Permite eliminar, crear y mostrar Contenidos"))
public class ContenidoControllerV2 {

    @Autowired
    private ContenidoService contenidoService;

    @Autowired
    private com.microservicio_contenido_evaluaciones.edutech_innovators.hateoas.ContenidoModelAssembler assembler;

    @PostMapping
    @Operation(summary = "Crear Contenido", description = "Permite Crear un nuevo contenido")
    public EntityModel<Contenido> crearContenido(@RequestBody Contenido contenido) {
        return assembler.toModel(contenidoService.crearContenido(contenido));
    }

    @PutMapping("/{contenidoId}")
    @Operation(summary = "Actualizar Contenido", description = "Permite Actualizar Contenido")
    public EntityModel<Contenido> actualizarContenido(@PathVariable Long contenidoId, @RequestBody Contenido contenido) {
        return assembler.toModel(contenidoService.actualizarContenido(contenidoId, contenido));
    }

    @DeleteMapping("/{contenidoId}")
    @Operation(summary = "Eliminar Contenido", description = "Permite Eliminar Contenido Ingresado por ID")
    public void eliminarContenido(@PathVariable Long contenidoId) {
        contenidoService.eliminarContenido(contenidoId);
    }

    @GetMapping("/{contenidoId}")
    @Operation(summary = "Obtener Contenido", description = "Permite Obtener Contenido por su ID")
    public EntityModel<Contenido> obtenerPorId(@PathVariable Long contenidoId) {
        return assembler.toModel(contenidoService.obtenerPorId(contenidoId));
    }

    @GetMapping
    @Operation(summary = "Lista de Contenidos", description = "Permite Visualizar Todos los contenidos registrados y los contenidos ya ingresados anteriormente")
    public CollectionModel<EntityModel<Contenido>> listarContenidos() {
        List<EntityModel<Contenido>> contenidos = contenidoService.listarContenidos().stream()
            .map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(contenidos, linkTo(methodOn(ContenidoController.class).listarContenidos()).withSelfRel());
    }

    @GetMapping("/curso/{cursoId}")
    @Operation(summary = "Lista de Contenidos por ID de curso", description = "Permite Visualizar todos los contenidos segun el ID del curso asociado")
    public List<Contenido> listarPorCurso(@PathVariable Long cursoId) {
        return contenidoService.listarPorCursoId(cursoId);
    }
}