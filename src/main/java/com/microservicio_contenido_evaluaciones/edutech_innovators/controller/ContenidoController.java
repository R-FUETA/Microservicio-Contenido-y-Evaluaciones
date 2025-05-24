package com.microservicio_contenido_evaluaciones.edutech_innovators.controller;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Contenido;
import com.microservicio_contenido_evaluaciones.edutech_innovators.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marca esta clase como un controlador REST
@RequestMapping("/api/contenidos") // Ruta base para todos los endpoints relacionados con Contenido
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService; // Inyección del servicio para manejar lógica de negocio

    @PostMapping // Endpoint para crear un nuevo contenido
    public Contenido crearContenido(@RequestBody Contenido contenido) {
        return contenidoService.crearContenido(contenido);
    }

    @PutMapping("/{contenidoId}") // Endpoint para actualizar un contenido existente
    public Contenido actualizarContenido(@PathVariable Long contenidoId, @RequestBody Contenido contenido) {
        return contenidoService.actualizarContenido(contenidoId, contenido);
    }

    @DeleteMapping("/{contenidoId}") // Endpoint para eliminar un contenido por su ID
    public void eliminarContenido(@PathVariable Long contenidoId) {
        contenidoService.eliminarContenido(contenidoId);
    }

    @GetMapping("/{contenidoId}") // Endpoint para obtener un contenido por su ID
    public Contenido obtenerPorId(@PathVariable Long contenidoId) {
        return contenidoService.obtenerPorId(contenidoId);
    }

    @GetMapping // Endpoint para listar todos los contenidos
    public List<Contenido> listarContenidos() {
        return contenidoService.listarContenidos();
    }

    @GetMapping("/curso/{cursoId}") // Endpoint para listar contenidos según el ID del curso asociado
    public List<Contenido> listarPorCurso(@PathVariable Long cursoId) {
        return contenidoService.listarPorCursoId(cursoId);
    }
} 

