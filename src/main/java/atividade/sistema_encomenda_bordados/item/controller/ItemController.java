package atividade.sistema_encomenda_bordados.item.controller;

import atividade.sistema_encomenda_bordados.item.form.ItemForm;
import atividade.sistema_encomenda_bordados.item.dto.ItemDTO;
import atividade.sistema_encomenda_bordados.item.model.Item;
import atividade.sistema_encomenda_bordados.item.service.ItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/buscar")
    public ResponseEntity<List<ItemDTO>> buscarTodosItens () {
        return itemService.buscarTodos();
    }


    @GetMapping(path = "/buscar/{itemId}")
    public ResponseEntity<Item> buscarTodosItens (@PathVariable Long itemId) {
        return itemService.buscarItemPorID(itemId);
    }

    @Transactional
    @PostMapping(path = "/cadastrar")
    public ResponseEntity<ItemDTO> cadastrarItem (@RequestBody ItemForm itemForm) {
        ItemDTO itemNovo = new ItemDTO(this.itemService.cadastrar(itemForm));
        return ResponseEntity.status(HttpStatus.CREATED).body(itemNovo);

    }


    @Transactional
    @PutMapping(path = "/atualizar/{id}")
    public ResponseEntity<ItemDTO> atualizarItens (@PathVariable Long id, @RequestBody ItemForm itemForm) {
        return ResponseEntity.status(HttpStatus.OK).body(
                itemService.atualizarDados(id, itemForm)
        );
    }


    @DeleteMapping(path = "/deletar/{id}")
    public void deletarItens(@PathVariable Long id) {
        itemService.deletar(id);
    }
}
