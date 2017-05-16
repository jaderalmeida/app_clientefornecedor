package br.com.app.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.app.api.model.Status;

@RepositoryRestResource(path = "status", collectionResourceRel = "status")
public interface StatusRepository extends CrudRepository<Status, Long>{

}
