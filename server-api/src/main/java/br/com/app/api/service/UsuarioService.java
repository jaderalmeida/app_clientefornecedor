package br.com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.app.api.model.Usuario;
import br.com.app.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
    public ResponseEntity<Iterable<Usuario>> getAll() {
        Iterable<Usuario> result = usuarioRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
	public ResponseEntity<Usuario> getById(long id) {
		Usuario result = usuarioRepository.findOne(id); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<Usuario> save(Usuario usuario) {
		Usuario result = usuarioRepository.save(usuario);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<Usuario> update(long id, Usuario usuario) {
		ResponseEntity<Usuario> result = getById(id);
        if (usuario.getNome() != null)
        	result.getBody().setNome(usuario.getNome());

		return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
	}
	
	public void delete(long id){
    	if (!usuarioRepository.exists(id))
            throw new ResourceNotFoundException();
    	usuarioRepository.delete(id);
	}

}
