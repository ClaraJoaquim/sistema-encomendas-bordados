package atividade.sistema_encomenda_bordados.pedido.controller;

import atividade.sistema_encomenda_bordados.pedido.dto.PedidoDTO;
import atividade.sistema_encomenda_bordados.pedido.form.PedidoForm;
import atividade.sistema_encomenda_bordados.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/buscar")
    public ResponseEntity<List<PedidoDTO>> listarTodosComItens() {
        List<PedidoDTO> pedidos = pedidoService.listarTodos().getBody();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/buscar/{pedidoId}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long pedidoId) {

        PedidoDTO response = pedidoService.buscarPedidoCompletoPorId(pedidoId).getBody();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/deletar/{idPedido}")
    public void deletarCliente (@PathVariable Long idPedido) {
        this.pedidoService.deletarDados(idPedido);
    }

}
