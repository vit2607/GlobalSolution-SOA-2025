package br.com.fiap.upskilling.service;

import br.com.fiap.upskilling.model.Competencia;
import br.com.fiap.upskilling.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CompetenciaService {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    public List<Competencia> listarTodas() {
        return competenciaRepository.findAll();
    }

    public Competencia buscarPorId(Long id) {
        Objects.requireNonNull(id, "ID não pode ser nulo");
        return competenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competência não encontrada com ID: " + id));
    }

    public Competencia criar(Competencia competencia) {
        Objects.requireNonNull(competencia, "Competência não pode ser nula");
        return competenciaRepository.save(competencia);
    }

    public Competencia atualizar(Long id, Competencia competenciaAtualizada) {
        Competencia competencia = buscarPorId(id);
        competencia.setNome(competenciaAtualizada.getNome());
        competencia.setCategoria(competenciaAtualizada.getCategoria());
        competencia.setDescricao(competenciaAtualizada.getDescricao());
        return competenciaRepository.save(competencia);
    }

    public void deletar(Long id) {
        Objects.requireNonNull(id, "ID não pode ser nulo");
        Competencia competencia = buscarPorId(id);
        competenciaRepository.delete(competencia);
    }
}
