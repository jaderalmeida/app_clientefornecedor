package br.com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.app.api.model.Pedido;
import br.com.app.api.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
    public ResponseEntity<Iterable<Pedido>> getAll() {
        Iterable<Pedido> result = pedidoRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
	public ResponseEntity<Pedido> getById(long id) {
		Pedido result = pedidoRepository.findOne(id); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<Pedido> save(Pedido pedido) {
		Pedido result = pedidoRepository.save(pedido);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<Pedido> update(long id, Pedido pedido) {
		ResponseEntity<Pedido> result = getById(id);

		return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
	}
	
	public void delete(long id){
    	if (!pedidoRepository.exists(id))
            throw new ResourceNotFoundException();
    	pedidoRepository.delete(id);
	}
}
