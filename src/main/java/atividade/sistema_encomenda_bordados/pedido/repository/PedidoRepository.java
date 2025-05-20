package atividade.sistema_encomenda_bordados.pedido.repository;

import atividade.sistema_encomenda_bordados.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
}
