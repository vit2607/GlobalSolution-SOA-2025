package br.com.fiap.upskilling.repository;

import br.com.fiap.upskilling.model.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository para gerenciar operações com Trilhas
 */
@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
    
    /**
     * Busca trilhas por nível
     */
    List<Trilha> findByNivel(String nivel);
    
    /**
     * Busca trilhas por foco principal
     */
    List<Trilha> findByFocoPrincipal(String focoPrincipal);
    
    /**
     * Busca trilhas com carga horária menor ou igual
     */
    List<Trilha> findByCargaHorariaLessThanEqual(Integer cargaHoraria);
}
