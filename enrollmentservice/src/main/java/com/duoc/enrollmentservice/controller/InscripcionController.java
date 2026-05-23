package com.duoc.enrollmentservice.controller;

import com.duoc.enrollmentservice.model.Inscripcion;
import com.duoc.enrollmentservice.service.InscripcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/// Controlador encargado de manejar las solicitudes HTTP relacionadas con la entidad Inscripcion.
@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final InscripcionService service;

    public InscripcionController(InscripcionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Inscripcion>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Inscripcion>> getByCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(service.getByCurso(cursoId));
    }

    @PostMapping
    public ResponseEntity<Inscripcion> save(@RequestBody Inscripcion i) {
        return ResponseEntity.status(201).body(service.save(i));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> update(@PathVariable Long id, @RequestBody Inscripcion i) {
        return ResponseEntity.ok(service.update(id, i));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}