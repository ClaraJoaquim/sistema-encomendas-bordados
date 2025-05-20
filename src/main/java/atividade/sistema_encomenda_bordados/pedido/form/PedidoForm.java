package atividade.sistema_encomenda_bordados.pedido.form;

import atividade.sistema_encomenda_bordados.cliente.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PedidoForm {

    private Long id;

    private LocalDateTime dataPedido;

    private BigDecimal valorTotal;

    private Cliente cliente;
}
