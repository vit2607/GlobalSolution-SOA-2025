package br.com.fiap.upskilling.controller;

import br.com.fiap.upskilling.model.Matricula;
import br.com.fiap.upskilling.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<Matricula>> listarTodas() {
        return ResponseEntity.ok(matriculaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Matricula> criar(@Valid @RequestBody Matricula matricula) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(matriculaService.criar(matricula));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Matricula> atualizarStatus(@PathVariable Long id, 
                                                     @RequestParam String status) {
        return ResponseEntity.ok(matriculaService.atualizarStatus(id, status));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Matricula>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(matriculaService.listarPorUsuario(usuarioId));
    }
}
