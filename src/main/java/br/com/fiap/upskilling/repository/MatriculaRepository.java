package br.com.fiap.upskilling.repository;

import br.com.fiap.upskilling.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository para gerenciar operações com Matriculas
 */
@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    
    /**
     * Busca matrículas por usuário
     */
    List<Matricula> findByUsuarioId(Long usuarioId);
    
    /**
     * Busca matrículas por trilha
     */
    List<Matricula> findByTrilhaId(Long trilhaId);
    
    /**
     * Busca matrículas por status
     */
    List<Matricula> findByStatus(String status);
}
