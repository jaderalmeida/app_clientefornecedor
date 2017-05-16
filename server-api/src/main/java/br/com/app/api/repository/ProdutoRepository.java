package br.com.app.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.app.api.model.Produto;

@RepositoryRestResource(path = "product", collectionResourceRel = "product")
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
