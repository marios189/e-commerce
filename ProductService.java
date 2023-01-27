package sportswear.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sportswear.DTO.ProductDTO;
import sportswear.entities.Product;
import sportswear.exception.ResourceNotFoundException;
import sportswear.interfaces.ProductInterface;
import sportswear.repositories.ProductRepository;

@Service
public class ProductService implements ProductInterface{
	
	@Autowired
	ProductRepository repository;

	@Override
	public List<Product> allProducts() {
		return repository.findAll();
	}

	@Override
	public void newProduct(ProductDTO product) {
		Product p1  = new Product();
		p1.setName(product.getName());
		p1.setPrice(product.getPrice());
		p1.setSize(product.getSize());
		repository.save(p1);
	}
	
	@Override
	public List<Product> findBySize(String size){
		return repository.findBySize(size);
	}

	@Override
	public Product getProduct(long id) {
		 return repository
		          .findById(id)
		          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

}
