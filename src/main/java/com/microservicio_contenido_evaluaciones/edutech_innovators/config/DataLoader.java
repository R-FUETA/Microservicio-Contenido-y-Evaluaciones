package com.microservicio_contenido_evaluaciones.edutech_innovators.config;

import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Contenido;
import com.microservicio_contenido_evaluaciones.edutech_innovators.model.Evaluacion;
import com.microservicio_contenido_evaluaciones.edutech_innovators.repository.ContenidoRepository;
import com.microservicio_contenido_evaluaciones.edutech_innovators.repository.EvaluacionRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // 1. Crear 20 contenidos
        for (int i = 0; i < 20; i++) {
            Contenido contenido = Contenido.builder()
                    .titulo(faker.book().title())
                    .descripcion(faker.lorem().sentence(10))
                    .cursoId((long) random.nextInt(10) + 1) // Simula cursoId de 1 a 10
                    .build();

            contenidoRepository.save(contenido);
        }

        // Obtener lista de contenidos generados
        List<Contenido> contenidos = contenidoRepository.findAll();

        if (contenidos.isEmpty()) {
            System.out.println("No se pudieron crear evaluaciones porque no hay contenidos disponibles.");
            return;
        }

        // 2. Crear 30 evaluaciones (todas deben tener contenidoId)
        for (int i = 0; i < 30; i++) {
            Contenido contenido = contenidos.get(random.nextInt(contenidos.size()));

            Evaluacion evaluacion = Evaluacion.builder()
                    .titulo("Evaluación: " + faker.educator().course())
                    .instrucciones(faker.lorem().paragraph())
                    .puntajeMaximo(100)
                    .cursoId(contenido.getCursoId()) // mismo curso que el contenido
                    .contenidoId(contenido.getContenidoId())
                    .build();

            evaluacionRepository.save(evaluacion);
        }

        System.out.println("Datos generados: contenidos + evaluaciones (con contenido obligatorio).");
    }
}
