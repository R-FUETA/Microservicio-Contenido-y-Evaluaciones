package com.microservicio_contenido_evaluaciones.edutech_innovators.service;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Contenido;
import com.microservicio_contenido_evaluaciones.edutech_innovators.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Anotación que indica que esta clase contiene la lógica de negocio
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository; // Inyección del repositorio de contenidos

    // Crea y guarda un nuevo contenido
    public Contenido crearContenido(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    // Actualiza un contenido existente
    public Contenido actualizarContenido(Long contenidoId, Contenido contenido) {
        Contenido existente = contenidoRepository.findById(contenidoId)
                .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));

        existente.setTitulo(contenido.getTitulo());
        existente.setDescripcion(contenido.getDescripcion());
        existente.setCursoId(contenido.getCursoId());

        return contenidoRepository.save(existente);
    }

    // Elimina un contenido por su ID
    public void eliminarContenido(Long contenidoId) {
        contenidoRepository.deleteById(contenidoId);
    }

    // Obtiene un contenido por su ID
    public Contenido obtenerPorId(Long contenidoId) {
        return contenidoRepository.findById(contenidoId)
                .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
    }

    // Lista todos los contenidos
    public List<Contenido> listarContenidos() {
        return contenidoRepository.findAll();
    }

    // Lista los contenidos asociados a un curso
    public List<Contenido> listarPorCursoId(Long cursoId) {
        return contenidoRepository.findByCursoId(cursoId);
    }
} 
