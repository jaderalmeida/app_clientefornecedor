package br.com.app.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.app.api.model.ProdutoUsuario;

@RepositoryRestResource(path = "productuser", collectionResourceRel = "productuser")
public interface ProdutoUsuarioRepository extends CrudRepository<ProdutoUsuario, Long>{

}
