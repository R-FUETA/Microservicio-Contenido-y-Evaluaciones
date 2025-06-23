package com.microservicio_contenido_evaluaciones.edutech_innovators.controller;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Contenido;
import com.microservicio_contenido_evaluaciones.edutech_innovators.service.ContenidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marca esta clase como un controlador REST
@RequestMapping("/api/contenidos") // Ruta base para todos los endpoints relacionados con Contenido
@Tag(name = "Contenidos", description = ("Permite eliminar, crear y mostrar Contenidos"))
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService; // Inyección del servicio para manejar lógica de negocio
    @Operation(summary = "Crear Contenido", description = "Permite Crear un nuevo contenido")
    @PostMapping // Endpoint para crear un nuevo contenido
    public Contenido crearContenido(@RequestBody Contenido contenido) {
        return contenidoService.crearContenido(contenido);
    }
    @Operation(summary = "Actualizar Contenido", description = "Permite Actualizar Contenido")
    @PutMapping("/{contenidoId}") // Endpoint para actualizar un contenido existente
    public Contenido actualizarContenido(@PathVariable Long contenidoId, @RequestBody Contenido contenido) {
        return contenidoService.actualizarContenido(contenidoId, contenido);
    }
    @Operation(summary = "Eliminar Contenido", description = "Permite Eliminar Contenido Ingresado por ID")
    @DeleteMapping("/{contenidoId}") // Endpoint para eliminar un contenido por su ID
    public void eliminarContenido(@PathVariable Long contenidoId) {
        contenidoService.eliminarContenido(contenidoId);
    }
    @Operation(summary = "Obtener Contenido", description = "Permite Obtener Contenido por su ID")
    @GetMapping("/{contenidoId}") // Endpoint para obtener un contenido por su ID
    public Contenido obtenerPorId(@PathVariable Long contenidoId) {
        return contenidoService.obtenerPorId(contenidoId);
    }
    @Operation(summary = "Lista de Contenidos", description = "Permite Visualizar Todos los contenidos registrados y los contenidos ya ingresados anteriormente")
    @GetMapping // Endpoint para listar todos los contenidos
    public List<Contenido> listarContenidos() {
        return contenidoService.listarContenidos();
    }
    @Operation(summary = "Lista de Contenidos por ID de curso", description = "Permite Visualizar todos los contenidos segun el ID del curso asociado")
    @GetMapping("/curso/{cursoId}") // Endpoint para listar contenidos según el ID del curso asociado
    public List<Contenido> listarPorCurso(@PathVariable Long cursoId) {
        return contenidoService.listarPorCursoId(cursoId);
    }
} 

