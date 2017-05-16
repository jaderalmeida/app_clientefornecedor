package br.com.app.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.app.api.model.Pedido;

@RepositoryRestResource(path = "pedido", collectionResourceRel = "pedido")
public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
