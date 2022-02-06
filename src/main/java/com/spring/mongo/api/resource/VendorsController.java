package com.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import com.spring.mongo.api.model.Vendors;
import com.spring.mongo.api.respository.VendorsRepository;

@RestController
@CrossOrigin(origins="*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(value="/apiTienda/vendors")
public class VendorsController {
	
	@Autowired
	private VendorsRepository repository;
	
	/*
	@PostMapping("/addVendors")
	public Vendors create (@Validated @RequestBody Vendors p) {
		return repository.insert(p);
	}*/
	
	@PostMapping("/addVendors")
	public ResponseEntity<Vendors> saveCliente(@RequestBody Vendors vendor) {
		Vendors objVendors = repository.save(vendor);
		return new ResponseEntity<Vendors>(objVendors, HttpStatus.OK);
	}
	
	@GetMapping("/listVendors")
	public List<Vendors> readAll(){
		return repository.findAll();
	}
	
	@GetMapping("/vendors/{id}")
	public Optional<Vendors> listVendor(@PathVariable int id){
		return repository.findById(id);
	}
	
	@PutMapping("/vendors/{id}")
	public Vendors update(@PathVariable String id, @Validated @RequestBody Vendors p){
		return repository.save(p);
	}
	
	@DeleteMapping("/deleteVendors/{id}")
	public String deleteVendors(@PathVariable int id) {
		repository.deleteById(id);
		return "Producto eliminado con el Id: "+ id;
	}

	/*@GetMapping("/deleteVendors/{id}")
	public ResponseEntity<Vendors> deleteClient(@PathVariable int id) {
		Optional<Vendors> delVendor = repository.findById(id);
		System.out.print(delVendor);
		if (delVendor.isPresent()) {
			repository.deleteById(id);
			
		}else {
			return new ResponseEntity<Vendors>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Vendors>(HttpStatus.OK);
		
	}*/
	


}
