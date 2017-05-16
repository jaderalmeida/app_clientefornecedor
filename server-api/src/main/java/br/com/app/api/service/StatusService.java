package br.com.app.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.app.api.model.Status;
import br.com.app.api.repository.StatusRepository;

@Service
public class StatusService {
	
	@Autowired
	StatusRepository statusRepository;
	
	public ResponseEntity<Iterable<Status>> getAll() {
        Iterable<Status> result = statusRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
	public ResponseEntity<Status> getById(long id) {
		Status result = statusRepository.findOne(id); 
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<Status> save(Status status) {
		Status result = statusRepository.save(status);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	public ResponseEntity<Status> update(long id, Status status) {
		ResponseEntity<Status> result = getById(id);
        if (status.getNome() != null)
        	result.getBody().setNome(status.getNome());

		return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
	}
	
	public void delete(long id){
    	if (!statusRepository.exists(id))
            throw new ResourceNotFoundException();
    	statusRepository.delete(id);
	}
}
