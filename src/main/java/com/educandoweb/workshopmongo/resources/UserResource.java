package com.educandoweb.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshopmongo.DTO.UserDTO;
import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service; // Incluindo o Service no Resource

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
//
//  @GetMapping                                            // Sem incluir o Service no Resource
//	public List<User> findAll() {
//		List<User> list = new ArrayList<>();                
//		User maria = new User("1001", "Maria Brown", "maria@gmail.com");
//		User alex = new User("1002", "Alex Green", "alex@gmail.com");
//   	List<User> list = new ArrayList<>();
//		list.addAll(Arrays.asList(maria, alex));
//      return list;
}
