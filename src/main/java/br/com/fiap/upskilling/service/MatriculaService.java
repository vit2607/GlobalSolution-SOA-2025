package br.com.fiap.upskilling.service;

import br.com.fiap.upskilling.exception.RegraNegocioException;
import br.com.fiap.upskilling.model.Matricula;
import br.com.fiap.upskilling.model.Trilha;
import br.com.fiap.upskilling.model.Usuario;
import br.com.fiap.upskilling.repository.MatriculaRepository;
import br.com.fiap.upskilling.repository.TrilhaRepository;
import br.com.fiap.upskilling.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TrilhaRepository trilhaRepository;

    public List<Matricula> listarTodas() {
        return matriculaRepository.findAll();
    }

    public Matricula buscarPorId(Long id) {
        Objects.requireNonNull(id, "ID não pode ser nulo");
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada com ID: " + id));
    }

    public Matricula criar(Matricula matricula) {
        Objects.requireNonNull(matricula, "Matrícula não pode ser nula");
        Objects.requireNonNull(matricula.getUsuario(), "Usuário não pode ser nulo");
        Objects.requireNonNull(matricula.getTrilha(), "Trilha não pode ser nula");
        
        // Validar se usuário e trilha existem
        Usuario usuario = usuarioRepository.findById(matricula.getUsuario().getId())
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
        
        Trilha trilha = trilhaRepository.findById(matricula.getTrilha().getId())
                .orElseThrow(() -> new RegraNegocioException("Trilha não encontrada"));
        
        matricula.setUsuario(usuario);
        matricula.setTrilha(trilha);
        matricula.setDataInscricao(LocalDate.now());
        matricula.setStatus("EM_ANDAMENTO");
        
        return matriculaRepository.save(matricula);
    }

    public Matricula atualizarStatus(Long id, String status) {
        Objects.requireNonNull(id, "ID não pode ser nulo");
        Objects.requireNonNull(status, "Status não pode ser nulo");
        
        if (!status.matches("EM_ANDAMENTO|CONCLUIDA|CANCELADA")) {
            throw new RegraNegocioException("Status deve ser: EM_ANDAMENTO, CONCLUIDA ou CANCELADA");
        }
        
        Matricula matricula = buscarPorId(id);
        matricula.setStatus(status);
        
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> listarPorUsuario(Long usuarioId) {
        Objects.requireNonNull(usuarioId, "ID do usuário não pode ser nulo");
        return matriculaRepository.findByUsuarioId(usuarioId);
    }
}
