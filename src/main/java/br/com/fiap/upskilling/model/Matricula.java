package br.com.fiap.upskilling.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entidade Matricula - Representa a inscrição de um usuário em uma trilha
 */
@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "trilha_id", nullable = false)
    @JsonIgnore
    private Trilha trilha;

    @NotNull(message = "Data de inscrição é obrigatória")
    @Column(name = "data_inscricao", nullable = false)
    private LocalDate dataInscricao;

    @NotBlank(message = "Status é obrigatório")
    @Pattern(regexp = "EM_ANDAMENTO|CONCLUIDA|CANCELADA", 
             message = "Status deve ser: EM_ANDAMENTO, CONCLUIDA ou CANCELADA")
    @Column(nullable = false, length = 50)
    private String status;

    // Construtores
    public Matricula() {
        this.dataInscricao = LocalDate.now();
        this.status = "EM_ANDAMENTO";
    }

    public Matricula(Usuario usuario, Trilha trilha) {
        this.usuario = usuario;
        this.trilha = trilha;
        this.dataInscricao = LocalDate.now();
        this.status = "EM_ANDAMENTO";
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
