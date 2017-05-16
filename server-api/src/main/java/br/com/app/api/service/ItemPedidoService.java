package br.com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.app.api.model.ItemPedido;
import br.com.app.api.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
    public ResponseEntity<Iterable<ItemPedido>> getAll() {
        Iterable<ItemPedido> result = itemPedidoRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
	public ResponseEntity<ItemPedido> getById(long id) {
		ItemPedido result = itemPedidoRepository.findOne(id); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<ItemPedido> save(ItemPedido pedido) {
		ItemPedido result = itemPedidoRepository.save(pedido);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<ItemPedido> update(long id, ItemPedido pedido) {
		ResponseEntity<ItemPedido> result = getById(id);

		return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
	}
	
	public void delete(long id){
    	if (!itemPedidoRepository.exists(id))
            throw new ResourceNotFoundException();
    	itemPedidoRepository.delete(id);
	}
}
