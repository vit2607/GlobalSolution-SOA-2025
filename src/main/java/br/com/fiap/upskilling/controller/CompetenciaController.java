package br.com.fiap.upskilling.controller;

import br.com.fiap.upskilling.model.Competencia;
import br.com.fiap.upskilling.service.CompetenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencias")
public class CompetenciaController {

    @Autowired
    private CompetenciaService competenciaService;

    @GetMapping
    public ResponseEntity<List<Competencia>> listarTodas() {
        return ResponseEntity.ok(competenciaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(competenciaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Competencia> criar(@Valid @RequestBody Competencia competencia) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(competenciaService.criar(competencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competencia> atualizar(@PathVariable Long id, 
                                                 @Valid @RequestBody Competencia competencia) {
        return ResponseEntity.ok(competenciaService.atualizar(id, competencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        competenciaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
