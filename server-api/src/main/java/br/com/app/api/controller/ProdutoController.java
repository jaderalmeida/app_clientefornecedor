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

import br.com.app.api.model.Produto;
import br.com.app.api.service.ProdutoService;

@RestController
@RequestMapping(value = "product")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@Get
    public ResponseEntity<Iterable<Produto>> getAll(){
    	return produtoService.getAll();
    }
    
    @Get("{id}")
    public ResponseEntity<Produto> getById(@PathVariable(value = "id") Long id) {
    	return produtoService.getById(id);
    }
    
    @Transactional
    @Delete("{id}")
    public void delete(@PathVariable Long id){
    	produtoService.delete(id); 
    }
    
    @Transactional
    @Post
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
    	return produtoService.save(produto);
    }
    
    @Transactional
    @Put("{id}")
    public ResponseEntity<Produto> update(@PathVariable long id, @RequestBody Produto produto){
    	return produtoService.update(id, produto);
    }
}
