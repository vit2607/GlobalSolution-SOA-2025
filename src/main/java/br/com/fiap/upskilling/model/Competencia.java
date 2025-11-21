package br.com.fiap.upskilling.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entidade Competencia - Representa competências do futuro do trabalho
 * (IA, Análise de Dados, Empatia, Colaboração, etc.)
 */
@Entity
@Table(name = "competencias")
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da competência é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @Size(max = 100, message = "Categoria deve ter no máximo 100 caracteres")
    @Column(length = 100)
    private String categoria;

    @Size(max = 500, message = "Descrição deve ter no máximo 500 caracteres")
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToMany(mappedBy = "competencias")
    @JsonIgnore
    private Set<Trilha> trilhas = new HashSet<>();

    // Construtores
    public Competencia() {
    }

    public Competencia(String nome, String categoria, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Trilha> getTrilhas() {
        return trilhas;
    }

    public void setTrilhas(Set<Trilha> trilhas) {
        this.trilhas = trilhas;
    }
}
