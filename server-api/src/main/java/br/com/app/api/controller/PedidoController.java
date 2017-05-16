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

import br.com.app.api.model.Pedido;
import br.com.app.api.service.PedidoService;

@RestController
@RequestMapping(value = "pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@Get
    public ResponseEntity<Iterable<Pedido>> getAll(){
    	return pedidoService.getAll();
    }
    
    @Get("{id}")
    public ResponseEntity<Pedido> getById(@PathVariable(value = "id") Long id) {
    	return pedidoService.getById(id);
    }
    
    @Transactional
    @Delete("{id}")
    public void delete(@PathVariable Long id){
    	pedidoService.delete(id); 
    }
    
    @Transactional
    @Post
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido){
    	return pedidoService.save(pedido);
    }
    
    @Transactional
    @Put("{id}")
    public ResponseEntity<Pedido> update(@PathVariable long id, @RequestBody Pedido pedido){
    	return pedidoService.update(id, pedido);
    }
}
