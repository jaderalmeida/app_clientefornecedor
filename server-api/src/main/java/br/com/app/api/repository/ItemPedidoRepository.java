package br.com.app.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.app.api.model.ItemPedido;

@RepositoryRestResource(path = "itempedido", collectionResourceRel = "itempedido")
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long>{

}
