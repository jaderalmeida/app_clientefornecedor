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

import br.com.app.api.model.Usuario;
import br.com.app.api.service.UsuarioService;

@RestController
@RequestMapping(value = "user")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@Get
    public ResponseEntity<Iterable<Usuario>> getAll(){
    	return usuarioService.getAll();
    }
    
    @Get("{id}")
    public ResponseEntity<Usuario> getById(@PathVariable(value = "id") Long id) {
    	return usuarioService.getById(id);
    }
    
    @Transactional
    @Delete("{id}")
    public void delete(@PathVariable Long id){
    	usuarioService.delete(id); 
    }
    
    @Transactional
    @Post
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
    	return usuarioService.save(usuario);
    }
    
    @Transactional
    @Put("{id}")
    public ResponseEntity<Usuario> update(@PathVariable long id, @RequestBody Usuario usuario){
    	return usuarioService.update(id, usuario);
    }

}
