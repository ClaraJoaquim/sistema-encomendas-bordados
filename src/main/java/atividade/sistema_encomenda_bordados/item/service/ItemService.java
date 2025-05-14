package atividade.sistema_encomenda_bordados.item.service;

import atividade.sistema_encomenda_bordados.execoes.ResourceNotFoundException;
import atividade.sistema_encomenda_bordados.item.form.ItemForm;
import atividade.sistema_encomenda_bordados.item.dto.ItemDTO;
import atividade.sistema_encomenda_bordados.item.model.Item;
import atividade.sistema_encomenda_bordados.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<List<ItemDTO>> buscarTodos () {
        List<Item> listaItens = itemRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                listaItens.stream()
                        .map(ItemDTO::new)
                        .collect(Collectors.toList())
        );
    }


    public ResponseEntity<Item> buscarItemPorID (Long id) {

        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", id));

        return ResponseEntity.status(HttpStatus.OK).body(item);
    }


    public Item cadastrar (ItemForm itemForm) {

        Item itemNovo = new Item();
        itemNovo.setNome(itemForm.getNome());
        itemNovo.setDescricao(itemForm.getDescricao());
        itemNovo.setPreco(itemForm.getPreco());

        return itemRepository.save(itemNovo);
    }


    public ItemDTO atualizarDados (Long id, ItemForm itemForm) {


        Item dadosExistentes = this.buscarItemPorID(id).getBody();
        dadosExistentes.setNome(itemForm.getNome());
        dadosExistentes.setDescricao(itemForm.getDescricao());
        dadosExistentes.setPreco(itemForm.getPreco());

        itemRepository.save(dadosExistentes);
        return new ItemDTO(dadosExistentes);
    }

    public void deletar (Long id) {
        itemRepository.deleteById(id);
    }
}
