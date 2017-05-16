package br.com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.app.api.model.Produto;
import br.com.app.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
    public ResponseEntity<Iterable<Produto>> getAll() {
        Iterable<Produto> result = produtoRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
	public ResponseEntity<Produto> getById(long id) {
		Produto result = produtoRepository.findOne(id); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<Produto> save(Produto produto) {
		Produto result = produtoRepository.save(produto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<Produto> update(long id, Produto produto) {
		ResponseEntity<Produto> result = getById(id);
        if (produto.getNome() != null)
        	result.getBody().setNome(produto.getNome());

		return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
	}
	
	public void delete(long id){
    	if (!produtoRepository.exists(id))
            throw new ResourceNotFoundException();
    	produtoRepository.delete(id);
	}
}
