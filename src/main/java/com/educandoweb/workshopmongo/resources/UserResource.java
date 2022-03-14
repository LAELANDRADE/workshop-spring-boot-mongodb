package com.educandoweb.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;            //                    Incluindo o Service no Resource

	@RequestMapping(method = RequestMethod.GET)
	// ou pode usar também 
	// @GetMapping
	public ResponseEntity<List<User>> findAll() {
//		List<User> list = new ArrayList<>();          Mudanças ->  Incluindo o Service no Resource
//		User maria = new User("1001", "Maria Brown", "maria@gmail.com");
//		User alex = new User("1002", "Alex Green", "alex@gmail.com");
//		list.addAll(Arrays.asList(maria, alex));
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
