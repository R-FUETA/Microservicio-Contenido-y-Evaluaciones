package com.microservicio_contenido_evaluaciones.edutech_innovators.hateoas;

import com.microservicio_contenido_evaluaciones.edutech_innovators.controller.ContenidoControllerV2;
import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Contenido;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ContenidoModelAssembler implements RepresentationModelAssembler<Contenido, EntityModel<Contenido>> {
    @Override
    public EntityModel<Contenido> toModel(Contenido contenido) {
        return EntityModel.of(
            contenido,
            linkTo(methodOn(ContenidoControllerV2.class).obtenerPorId(contenido.getCursoId())).withSelfRel(),
            linkTo(methodOn(ContenidoControllerV2.class).listarContenidos()).withRel("contenidos")
        );
    }
}