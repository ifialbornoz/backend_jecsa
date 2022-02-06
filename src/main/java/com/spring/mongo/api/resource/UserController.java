package com.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.api.model.User;
import com.spring.mongo.api.respository.UserRepository;

@RestController // Anotacion que es un controlador
@RequestMapping(value ="/apiTienda/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserRepository repositorio;
	
	// Metodo para agregar un usuario
	@PostMapping("/addUser")
	public String saveUser(@RequestBody User usuario) {
		repositorio.save(usuario);
		return "Usuario creado con id: "+ usuario.getId();
	}
	
	// Metodo para listar usuarios
	@GetMapping("/listUser")
	public List<User> fynAllUser(){
		return repositorio.findAll();
		
	}
	
	// Metodo para listar un usuario por id
	@GetMapping("/listUser/{id}") 
	public Optional<User> fynAllUser(@PathVariable int id){
		return repositorio.findById(id);
		
	}
	
	
	
	@GetMapping("/deleteUser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		Optional<User> delUser = repositorio.findById(id);
		System.out.print(delUser);
		if (delUser.isPresent()) {
			repositorio.deleteById(id);
			
		}else {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(HttpStatus.OK);
		
	}
	
	
	
	
}
