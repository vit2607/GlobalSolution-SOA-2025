package br.com.fiap.upskilling.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade Trilha - Representa trilhas de aprendizagem focadas no futuro do trabalho
 * Relacionado com ODS 4 (Educação de Qualidade) e ODS 9 (Indústria, Inovação)
 */
@Entity
@Table(name = "trilhas")
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da trilha é obrigatório")
    @Size(min = 3, max = 150, message = "Nome deve ter entre 3 e 150 caracteres")
    @Column(nullable = false, length = 150)
    private String nome;

    @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @NotBlank(message = "Nível é obrigatório")
    @Pattern(regexp = "INICIANTE|INTERMEDIARIO|AVANCADO", 
             message = "Nível deve ser: INICIANTE, INTERMEDIARIO ou AVANCADO")
    @Column(nullable = false, length = 50)
    private String nivel;

    @NotNull(message = "Carga horária é obrigatória")
    @Min(value = 1, message = "Carga horária deve ser maior que zero")
    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @Size(max = 100, message = "Foco principal deve ter no máximo 100 caracteres")
    @Column(name = "foco_principal", length = 100)
    private String focoPrincipal;

    @ManyToMany
    @JoinTable(
        name = "trilha_competencia",
        joinColumns = @JoinColumn(name = "trilha_id"),
        inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    private Set<Competencia> competencias = new HashSet<>();

    @OneToMany(mappedBy = "trilha", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Matricula> matriculas = new HashSet<>();

    // Construtores
    public Trilha() {
    }

    public Trilha(String nome, String descricao, String nivel, Integer cargaHoraria, String focoPrincipal) {
        this.nome = nome;
        this.descricao = descricao;
        this.nivel = nivel;
        this.cargaHoraria = cargaHoraria;
        this.focoPrincipal = focoPrincipal;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getFocoPrincipal() {
        return focoPrincipal;
    }

    public void setFocoPrincipal(String focoPrincipal) {
        this.focoPrincipal = focoPrincipal;
    }

    public Set<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(Set<Competencia> competencias) {
        this.competencias = competencias;
    }

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
