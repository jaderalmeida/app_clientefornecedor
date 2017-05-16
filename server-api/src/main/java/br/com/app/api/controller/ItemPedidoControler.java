package br.com.app.api.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.composed.web.Delete;
import org.springframework.composed.web.Get;
import org.springframework.composed.web.Post;
import org.springframework.composed.web.Put;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.api.model.ItemPedido;
import br.com.app.api.service.ItemPedidoService;

@RestController
@RequestMapping(value = "itempedido")
public class ItemPedidoControler {

	@Autowired
	ItemPedidoService itemPedidoService;
	
	@Get
    public ResponseEntity<Iterable<ItemPedido>> getAll(){
    	return itemPedidoService.getAll();
    }
    
    @Get("{id}")
    public ResponseEntity<ItemPedido> getById(@PathVariable(value = "id") Long id) {
    	return itemPedidoService.getById(id);
    }
    
    @Transactional
    @Delete("{id}")
    public void delete(@PathVariable Long id){
    	itemPedidoService.delete(id); 
    }
    
    @Transactional
    @Post
    public ResponseEntity<ItemPedido> create(@RequestBody ItemPedido pedido){
    	return itemPedidoService.save(pedido);
    }
    
    @Transactional
    @Put("{id}")
    public ResponseEntity<ItemPedido> update(@PathVariable long id, @RequestBody ItemPedido pedido){
    	return itemPedidoService.update(id, pedido);
    }
}
