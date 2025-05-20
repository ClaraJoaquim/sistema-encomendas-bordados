package atividade.sistema_encomenda_bordados.pedido.model;

import atividade.sistema_encomenda_bordados.cliente.model.Cliente;
import atividade.sistema_encomenda_bordados.pedido.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dataPedido")
    private LocalDateTime dataPedido;

    @Column(name = "valorTotal")
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}

