package br.com.fiap.upskilling.service;

import br.com.fiap.upskilling.exception.TrilhaNaoEncontradaException;
import br.com.fiap.upskilling.model.Competencia;
import br.com.fiap.upskilling.model.Trilha;
import br.com.fiap.upskilling.repository.CompetenciaRepository;
import br.com.fiap.upskilling.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class TrilhaService {

    @Autowired
    private TrilhaRepository trilhaRepository;

    @Autowired
    private CompetenciaRepository competenciaRepository;

    public List<Trilha> listarTodas() {
        return trilhaRepository.findAll();
    }

    public Trilha buscarPorId(Long id) {
        Objects.requireNonNull(id, "ID não pode ser nulo");
        return trilhaRepository.findById(id)
                .orElseThrow(() -> new TrilhaNaoEncontradaException("Trilha não encontrada com ID: " + id));
    }

    public Trilha criar(Trilha trilha) {
        Objects.requireNonNull(trilha, "Trilha não pode ser nula");
        return trilhaRepository.save(trilha);
    }

    public Trilha atualizarTrilha(Long id, Trilha trilhaAtualizada) {
        Trilha trilha = buscarPorId(id);
        trilha.setNome(trilhaAtualizada.getNome());
        trilha.setDescricao(trilhaAtualizada.getDescricao());
        trilha.setFocoPrincipal(trilhaAtualizada.getFocoPrincipal());
        trilha.setNivel(trilhaAtualizada.getNivel());
        trilha.setCargaHoraria(trilhaAtualizada.getCargaHoraria());
        return trilhaRepository.save(trilha);
    }

    public void deletar(Long id) {
        Objects.requireNonNull(id, "ID não pode ser nulo");
        Trilha trilha = buscarPorId(id);
        trilhaRepository.delete(trilha);
    }

    public Trilha adicionarCompetencia(Long trilhaId, Long competenciaId) {
        Objects.requireNonNull(trilhaId, "ID da trilha não pode ser nulo");
        Objects.requireNonNull(competenciaId, "ID da competência não pode ser nulo");
        Trilha trilha = buscarPorId(trilhaId);
        Competencia competencia = competenciaRepository.findById(competenciaId)
                .orElseThrow(() -> new RuntimeException("Competência não encontrada com ID: " + competenciaId));
        
        if (!trilha.getCompetencias().contains(competencia)) {
            trilha.getCompetencias().add(competencia);
            return trilhaRepository.save(trilha);
        }
        return trilha;
    }
}
