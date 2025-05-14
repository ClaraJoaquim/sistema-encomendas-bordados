package atividade.sistema_encomenda_bordados.item.dto;

import atividade.sistema_encomenda_bordados.item.model.Item;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ItemDTO {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.nome = item.getNome();
        this.descricao = item.getDescricao();
        this.preco = item.getPreco();
    }
}
