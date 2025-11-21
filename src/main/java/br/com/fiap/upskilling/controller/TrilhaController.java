package br.com.fiap.upskilling.controller;

import br.com.fiap.upskilling.model.Trilha;
import br.com.fiap.upskilling.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {

    @Autowired
    private TrilhaService trilhaService;

    @GetMapping
    public ResponseEntity<List<Trilha>> listarTodas() {
        return ResponseEntity.ok(trilhaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(trilhaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Trilha> criar(@Valid @RequestBody Trilha trilha) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(trilhaService.criar(trilha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trilha> atualizar(@PathVariable Long id, 
                                           @Valid @RequestBody Trilha trilha) {
        return ResponseEntity.ok(trilhaService.atualizarTrilha(id, trilha));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        trilhaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/competencias/{competenciaId}")
    public ResponseEntity<Trilha> adicionarCompetencia(@PathVariable Long id, 
                                                       @PathVariable Long competenciaId) {
        return ResponseEntity.ok(trilhaService.adicionarCompetencia(id, competenciaId));
    }
}
