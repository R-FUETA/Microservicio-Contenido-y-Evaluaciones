package com.microservicio_contenido_evaluaciones.edutech_innovators.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // Indica que esta clase es una entidad JPA (tabla en la base de datos)
@Table(name = "contenidos") // Nombre de la tabla
@Data // Genera getters, setters, equals, hashCode y toString
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los campos
@Builder // Soporte para el patrón builder
public class Contenido {

    @Id // Identificador primario de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    @Column(name = "contenido_id") // Nombre de columna personalizado
    private Long contenidoId;

    @Column(nullable = false) // No puede ser nulo en la base de datos
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Long cursoId; // Relación lógica con el microservicio de cursos
} 