package atividade.sistema_encomenda_bordados.cliente.repository;

import atividade.sistema_encomenda_bordados.cliente.dto.ClienteDTO;
import atividade.sistema_encomenda_bordados.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    ClienteDTO findFirstByNomeContainingIgnoreCase(String nome);
}