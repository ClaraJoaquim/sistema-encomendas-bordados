package atividade.sistema_encomenda_bordados.item.repository;

import atividade.sistema_encomenda_bordados.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
