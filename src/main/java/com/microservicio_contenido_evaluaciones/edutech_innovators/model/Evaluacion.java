package com.microservicio_contenido_evaluaciones.edutech_innovators.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // Marca esta clase como una entidad JPA
@Table(name = "evaluaciones") // Especifica el nombre de la tabla
@Data // Lombok genera getters, setters, toString, equals, etc.
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los campos
@Builder // Permite crear objetos con el patrón builder
public class Evaluacion {

    @Id // Identificador único de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se genera automáticamente como autoincremental
    @Column(name = "id") // Nombre explícito de la columna
    private Long evaluacionId;

    @Column(nullable = false)
    private String titulo; // Título de la evaluación

    @Column(nullable = false)
    private String instrucciones; // Instrucciones para el estudiante

    @Column(nullable = false)
    private Integer puntajeMaximo; // Puntaje total asignado a la evaluación

    @Column(nullable = false)
    private Long cursoId; // ID del curso relacionado (desde otro microservicio)

    @Column
    private Long contenidoId; // ID opcional del contenido al que está asociada la evaluación
}

