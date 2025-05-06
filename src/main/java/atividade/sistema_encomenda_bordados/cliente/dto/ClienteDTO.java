package atividade.sistema_encomenda_bordados.cliente.dto;

import atividade.sistema_encomenda_bordados.cliente.model.Cliente;

import java.time.LocalDate;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate nascimento;
    private LocalDate dataCadastro;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.nascimento = cliente.getNascimento();
        this.dataCadastro = cliente.getDataCadastro();
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

    public ClienteDTO() {
    }

    public ClienteDTO(final Long id, final String nome, final String email, final String telefone, final LocalDate nascimento, final LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.dataCadastro = dataCadastro;
    }
}

