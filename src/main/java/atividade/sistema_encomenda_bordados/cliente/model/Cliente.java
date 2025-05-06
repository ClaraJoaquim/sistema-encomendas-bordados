package atividade.sistema_encomenda_bordados.cliente.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "cliente"
)
public class Cliente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "nome"
    )
    private String nome;
    @Column(
            name = "email"
    )
    private String email;
    @Column(
            name = "telefone"
    )
    private String telefone;
    @Column(
            name = "nascimento"
    )
    private LocalDate nascimento;
    @Column(
            name = "data_cadastro"
    )
    private LocalDate dataCadastro;

    public Cliente() {
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public LocalDate getNascimento() {
        return this.nascimento;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }

    public void setNascimento(final LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void setDataCadastro(final LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}