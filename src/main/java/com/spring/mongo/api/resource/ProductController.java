package com.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.api.model.Product;
import com.spring.mongo.api.respository.ProductRepository;


@RestController // Anotacion que es un controlador
@RequestMapping(value ="/apiTienda/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired 
	private ProductRepository repository;
	
	@PostMapping("/addProduct")
	public String saveProduct(@RequestBody Product producto) {
		repository.save(producto);
		return "Producto Guardado con el Id: "+ producto.getId();
	}
	
	@GetMapping("/listProduct")
	public List<Product> listProduct(){
		//findAll() trae toda la lista
		return repository.findAll();
	}
	
	@GetMapping("/listProduct/{id}")
	public Optional<Product> listProduct(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		repository.deleteById(id);
		return "Producto eliminado con el Id: "+ id;
	}
	
	@PutMapping("/editProduct/{id}")
	public void editProduct(@PathVariable int id) {
		repository.findById(id);
		
	}
	
	
}
