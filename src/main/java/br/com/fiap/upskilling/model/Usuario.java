package br.com.fiap.upskilling.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade Usuario - Representa os profissionais/alunos da plataforma
 * Relacionado com ODS 4 (Educação de Qualidade) e ODS 8 (Trabalho Decente)
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Size(max = 100, message = "Área de atuação deve ter no máximo 100 caracteres")
    @Column(name = "area_atuacao", length = 100)
    private String areaAtuacao;

    @Size(max = 50, message = "Nível de carreira deve ter no máximo 50 caracteres")
    @Column(name = "nivel_carreira", length = 50)
    private String nivelCarreira;

    @NotNull(message = "Data de cadastro é obrigatória")
    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Matricula> matriculas = new HashSet<>();

    // Construtores
    public Usuario() {
        this.dataCadastro = LocalDate.now();
    }

    public Usuario(String nome, String email, String areaAtuacao, String nivelCarreira) {
        this.nome = nome;
        this.email = email;
        this.areaAtuacao = areaAtuacao;
        this.nivelCarreira = nivelCarreira;
        this.dataCadastro = LocalDate.now();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getNivelCarreira() {
        return nivelCarreira;
    }

    public void setNivelCarreira(String nivelCarreira) {
        this.nivelCarreira = nivelCarreira;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
