package br.com.app.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.app.api.model.Usuario;

@RepositoryRestResource(path = "user", collectionResourceRel = "user")
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
