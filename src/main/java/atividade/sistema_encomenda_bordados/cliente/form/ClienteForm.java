package atividade.sistema_encomenda_bordados.cliente.form;

import java.time.LocalDate;

public class ClienteForm {
    private String nome;
    private String email;
    private String telefone;
    private LocalDate nascimento;
    private LocalDate dataCadastro;

    public ClienteForm() {
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
}
