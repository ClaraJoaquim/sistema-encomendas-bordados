package atividade.sistema_encomenda_bordados.cliente.service;

import atividade.sistema_encomenda_bordados.cliente.dto.ClienteDTO;
import atividade.sistema_encomenda_bordados.cliente.form.ClienteForm;
import atividade.sistema_encomenda_bordados.cliente.model.Cliente;
import atividade.sistema_encomenda_bordados.cliente.repository.ClienteRepository;
import atividade.sistema_encomenda_bordados.execoes.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<List<ClienteDTO>> buscarTodos() {
        List<Cliente> listaClientes = this.clienteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body((List)listaClientes.stream().map(ClienteDTO::new).collect(Collectors.toList()));
    }

    public ResponseEntity<Cliente> buscarClienteporID(Long id) {
        Cliente cliente = (Cliente)this.clienteRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Cliente", id);
        });
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    public ResponseEntity<ClienteDTO> buscarPrimeiroClienteCadastrado(String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteRepository.findFirstByNomeContainingIgnoreCase(nome));
    }

    @Transactional
    public Cliente cadastrar(ClienteForm clienteForm) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(clienteForm.getNome());
        novoCliente.setEmail(clienteForm.getEmail());
        novoCliente.setTelefone(clienteForm.getTelefone());
        novoCliente.setNascimento(clienteForm.getNascimento());
        novoCliente.setDataCadastro(clienteForm.getDataCadastro());
        return (Cliente)this.clienteRepository.save(novoCliente);
    }

    @Transactional
    public ClienteDTO atualizarDados(Long id, ClienteForm clienteForm) {
        Cliente dadosExistentes = (Cliente)this.buscarClienteporID(id).getBody();
        dadosExistentes.setNome(clienteForm.getNome());
        dadosExistentes.setEmail(clienteForm.getEmail());
        dadosExistentes.setTelefone(clienteForm.getTelefone());
        dadosExistentes.setNascimento(clienteForm.getNascimento());
        dadosExistentes.setDataCadastro(clienteForm.getDataCadastro());
        this.clienteRepository.save(dadosExistentes);
        return new ClienteDTO(dadosExistentes);
    }

    @Transactional
    public void deletarDados(Long id) {
        this.clienteRepository.deleteById(id);
    }

    public ClienteService(final ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
}

