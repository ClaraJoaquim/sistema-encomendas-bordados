package atividade.sistema_encomenda_bordados.cliente.controller;

import atividade.sistema_encomenda_bordados.cliente.dto.ClienteDTO;
import atividade.sistema_encomenda_bordados.cliente.form.ClienteForm;
import atividade.sistema_encomenda_bordados.cliente.model.Cliente;
import atividade.sistema_encomenda_bordados.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/cliente"})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    public ClienteController() {
    }

    @GetMapping(
            path = {"/buscar"}
    )
    public ResponseEntity<List<ClienteDTO>> buscarTodosClientes() {
        return this.clienteService.buscarTodos();
    }

    @GetMapping(
            path = {"/buscar/{id}"}
    )
    public ResponseEntity<Cliente> buscarTodosClientes(@PathVariable Long id) {
        return this.clienteService.buscarClienteporID(id);
    }

    @GetMapping(
            path = {"/buscar-primeiro-cliente"}
    )
    public ResponseEntity<ClienteDTO> buscarPrimeiroClienteCadastrado(@RequestParam("nome") String nome) {
        return this.clienteService.buscarPrimeiroClienteCadastrado(nome);
    }

    @PostMapping(
            path = {"/cadastrar"}
    )
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteForm clienteForm) {
        ClienteDTO clienteSalvo = new ClienteDTO(this.clienteService.cadastrar(clienteForm));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @PutMapping(
            path = {"/atualizar/{id}"}
    )
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteForm clienteForm) {
        ClienteDTO clienteAtualizado = this.clienteService.atualizarDados(id, clienteForm);
        return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);
    }

    @DeleteMapping(
            path = {"/deletar/{id}"}
    )
    public void deletarCliente(@PathVariable Long id) {
        this.clienteService.deletarDados(id);
    }
}
