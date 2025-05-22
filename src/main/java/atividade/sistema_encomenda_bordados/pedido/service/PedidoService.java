package atividade.sistema_encomenda_bordados.pedido.service;

import atividade.sistema_encomenda_bordados.cliente.repository.ClienteRepository;
import atividade.sistema_encomenda_bordados.execoes.ResourceNotFoundException;
import atividade.sistema_encomenda_bordados.pedido.dto.PedidoDTO;
import atividade.sistema_encomenda_bordados.pedido.model.Pedido;
import atividade.sistema_encomenda_bordados.pedido.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<List<PedidoDTO>> listarTodos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDTO> response = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            List<Pedido> itensDoPedido = pedidoRepository.findAll();
            response.add(new PedidoDTO(pedido));
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public Pedido buscarPorId (Long id) {
        return this.pedidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido", id));
    }

    public ResponseEntity<PedidoDTO> buscarPedidoCompletoPorId(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido", pedidoId));

        Optional<Pedido> itens = pedidoRepository.findById(pedidoId);

        PedidoDTO response = new PedidoDTO(pedido);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    @Transactional
    public void deletarDados (Long idPedido) {
        this.pedidoRepository.deleteById(idPedido);
    }
}
