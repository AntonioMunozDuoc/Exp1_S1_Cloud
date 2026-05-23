package com.duoc.enrollmentservice.service;

import com.duoc.enrollmentservice.model.Inscripcion;
import com.duoc.enrollmentservice.repository.InscripcionRepository;
import com.duoc.enrollmentservice.exception.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

// Servicio encargado de la lógica de negocio relacionada con la entidad Inscripcion.
@Service
public class InscripcionService {

    private final InscripcionRepository repo;

    public InscripcionService(InscripcionRepository repo) {
        this.repo = repo;
    }

    public List<Inscripcion> getAll() {
        return repo.findAll();
    }

    public Inscripcion getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Inscripción no encontrada con id: " + id));
    }

    public List<Inscripcion> getByCurso(Long cursoId) {
        return repo.findByCursoId(cursoId);
    }

    public Inscripcion save(Inscripcion i) {

        if (i.getCursoId() == null) {
            throw new IllegalArgumentException("CursoId es obligatorio");
        }

        if (i.getEstudianteId() == null) {
            throw new IllegalArgumentException("EstudianteId es obligatorio");
        }

        if (i.getFechaInscripcion() == null) {
            throw new IllegalArgumentException("Fecha de inscripción es obligatoria");
        }

        return repo.save(i);
    }

    public Inscripcion update(Long id, Inscripcion i) {

        Inscripcion existente = getById(id);

        existente.setCursoId(i.getCursoId());
        existente.setEstudianteId(i.getEstudianteId());
        existente.setFechaInscripcion(i.getFechaInscripcion());

        return repo.save(existente);
    }

    public void delete(Long id) {
        Inscripcion existente = getById(id);
        repo.delete(existente);
    }
}