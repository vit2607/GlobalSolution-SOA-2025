package br.com.fiap.upskilling.repository;

import br.com.fiap.upskilling.model.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository para gerenciar operações com Competencias
 */
@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
    
    /**
     * Busca competências por categoria
     */
    List<Competencia> findByCategoria(String categoria);
}
