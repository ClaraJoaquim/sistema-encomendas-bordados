package atividade.sistema_encomenda_bordados.item.form;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ItemForm {
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;
}
