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

import com.spring.mongo.api.model.Client;
import com.spring.mongo.api.respository.ClientRepository;

@RestController // Anotacion que es un controlador
@RequestMapping(value ="/apiTienda/client")
@CrossOrigin("*")
public class ClientControlller {
	
	// Creamos un objeto de tipo repository de cliente
	@Autowired
	private ClientRepository repositorio;
	
	/*
	@PostMapping("/addClient")
	public String saveCliente(@RequestBody Client client) {
		repositorio.save(client);
		return "Cliente Guardado con el Id: "+ client.getId();
	}
	
	@GetMapping("/listClient")
	public List<Client> ListClient(){ // No se reciben paremetros porq lista todos lo clientes
		return repositorio.findAll();
	}
	
	@GetMapping("/listClient/{id}")
	public Optional<Client> ListClient(@PathVariable int id){
		return repositorio.findById(id);
	}
	
	@DeleteMapping("/deleteClient/{id}")
	public String deleteClient(@PathVariable int id) {
		repositorio.deleteById(id);
		return "Cliente eliminado con el Id: "+ id;
	}
	*/
	
	@PostMapping("/addClient")
	public ResponseEntity<Client> saveCliente(@RequestBody Client client) {
		Client objClient = repositorio.save(client);
		return new ResponseEntity<Client>(objClient, HttpStatus.OK);
	}
	
	@GetMapping("/listClient")
	public List<Client> ListClient(){ // No se reciben paremetros porq lista todos lo clientes
		return repositorio.findAll();
	}
	
	@GetMapping("/listClient/{id}")
	public Optional<Client> ListClient(@PathVariable int id){
		return repositorio.findById(id);
	}
	
	@GetMapping("/deleteClient/{id}")
	public ResponseEntity<Client> deleteClient(@PathVariable int id) {
		Optional<Client> delClient = repositorio.findById(id);
		System.out.print(delClient);
		if (delClient.isPresent()) {
			repositorio.deleteById(id);
			
		}else {
			return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Client>(HttpStatus.OK);
		
	}
	
	
}
