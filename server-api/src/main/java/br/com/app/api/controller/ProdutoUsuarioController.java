package br.com.app.api.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.composed.web.Get;
import org.springframework.composed.web.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.api.model.ProdutoUsuario;
import br.com.app.api.service.ProdutoUsuarioService;

@RestController
@RequestMapping(value = "productuser")
public class ProdutoUsuarioController {
	
	@Autowired
	ProdutoUsuarioService produtoUsuarioService;
	
    @Get("{id}")
    public ResponseEntity<ProdutoUsuario> getById(@PathVariable(value = "id") Long id) {
    	return produtoUsuarioService.getById(id);
    }
    
    @Transactional
    @Post
    public ResponseEntity<ProdutoUsuario> create(@RequestBody ProdutoUsuario produtoUsuario){
    	return produtoUsuarioService.save(produtoUsuario);
    }

}
