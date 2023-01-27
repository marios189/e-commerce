package sportswear.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sportswear.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findBySize(String size);
}
