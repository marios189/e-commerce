package sportswear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sportswear.entities.Product;
import sportswear.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	//visualizzare tutti i prodotti
	@GetMapping("/all") 
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(service.allProducts());
	}
	
	@GetMapping("/{size}")
	public ResponseEntity<List<Product>> getProductBySize(@PathVariable String size){
		return ResponseEntity.ok(service.findBySize(size));
	}
	
	
	

}
