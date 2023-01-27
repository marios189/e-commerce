package sportswear.interfaces;

import java.util.List;

import sportswear.DTO.ProductDTO;
import sportswear.entities.Product;

public interface ProductInterface {
	
	public List<Product> allProducts();
	
	public void newProduct(ProductDTO product);

	List<Product> findBySize(String size);
	
	Product getProduct(long id);

}
