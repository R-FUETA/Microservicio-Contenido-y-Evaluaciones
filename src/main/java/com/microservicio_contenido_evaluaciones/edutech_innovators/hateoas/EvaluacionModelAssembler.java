package com.microservicio_contenido_evaluaciones.edutech_innovators.hateoas;

import com.microservicio_contenido_evaluaciones.edutech_innovators.controller.EvaluacionControllerV2;
import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Evaluacion;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class EvaluacionModelAssembler implements RepresentationModelAssembler<Evaluacion, EntityModel<Evaluacion>> {
    @Override
    public EntityModel<Evaluacion> toModel(Evaluacion evaluacion) {
        try {
            return EntityModel.of(evaluacion,
                linkTo(methodOn(EvaluacionControllerV2.class).obtenerPorId(evaluacion.getCursoId())).withSelfRel(),
                linkTo(methodOn(EvaluacionControllerV2.class).listarEvaluaciones()).withRel("evaluaciones"),
                linkTo(methodOn(EvaluacionControllerV2.class).listarPorCurso(evaluacion.getCursoId())).withRel("curso")
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al generar enlaces HATEOAS para la evaluación", e);
        }
    }
}