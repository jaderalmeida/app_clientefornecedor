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

import br.com.app.api.model.Status;
import br.com.app.api.service.StatusService;

@RestController
@RequestMapping(value = "status")
public class StatusController {
	
	@Autowired
	StatusService statusService;
	
	@Get
    public ResponseEntity<Iterable<Status>> getAll(){
    	return statusService.getAll();
    }
    
    @Get("{id}")
    public ResponseEntity<Status> getById(@PathVariable(value = "id") Long id) {
    	return statusService.getById(id);
    }
    
    @Transactional
    @Delete("{id}")
    public void delete(@PathVariable Long id){
    	statusService.delete(id); 
    }
    
    @Transactional
    @Post
    public ResponseEntity<Status> create(@RequestBody Status status){
    	return statusService.save(status);
    }
    
    @Transactional
    @Put("{id}")
    public ResponseEntity<Status> update(@PathVariable long id, @RequestBody Status status){
    	return statusService.update(id, status);
    }

}
