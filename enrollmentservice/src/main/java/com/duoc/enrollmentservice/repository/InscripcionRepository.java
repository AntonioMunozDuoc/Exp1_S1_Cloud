package com.duoc.enrollmentservice.repository;

import com.duoc.enrollmentservice.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repositorio encargado de las operaciones de persistencia para la entidad Inscripcion.
@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    /**
     * Obtiene todas las inscripciones asociadas a un curso específico.
     *
     * @param cursoId identificador del curso
     * @return lista de inscripciones
     */
    List<Inscripcion> findByCursoId(Long cursoId);
}