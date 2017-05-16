package br.com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.app.api.model.ProdutoUsuario;
import br.com.app.api.repository.ProdutoUsuarioRepository;

@Service
public class ProdutoUsuarioService {
	
	@Autowired
	ProdutoUsuarioRepository produtoUsuarioRepository;
	
    /*public ResponseEntity<Iterable<ProdutoUsuario>> getAll() {
        Iterable<ProdutoUsuario> result = produtoUsuarioRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }*/
    
	public ResponseEntity<ProdutoUsuario> getById(long id) {
		ProdutoUsuario result = produtoUsuarioRepository.findOne(id); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<ProdutoUsuario> save(ProdutoUsuario prodUsuario) {
		ProdutoUsuario result = produtoUsuarioRepository.save(prodUsuario);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/*public ResponseEntity<ProdutoUsuario> update(long id, Usuario usuario) {
		ResponseEntity<ProdutoUsuario> result = getById(id);
        if (usuario.getNome() != null)
        	result.getBody().setNome(usuario.getNome());

		return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
	}
	
	public void delete(long id){
    	if (!usuarioRepository.exists(id))
            throw new ResourceNotFoundException();
    	usuarioRepository.delete(id);
	}*/

}
