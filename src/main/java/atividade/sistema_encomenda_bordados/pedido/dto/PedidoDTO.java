package atividade.sistema_encomenda_bordados.pedido.dto;

import atividade.sistema_encomenda_bordados.pedido.enums.StatusPedido;
import atividade.sistema_encomenda_bordados.pedido.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;

    private LocalDateTime dataPedido;

    private BigDecimal valorTotal;

    private StatusPedido statusPedido;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.dataPedido = pedido.getDataPedido();
        this.valorTotal = pedido.getValorTotal();
        this.statusPedido = pedido.getStatusPedido();
    }
}


