package sportswear.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sportswear.entities.OrderProduct;
import sportswear.key.OrderProductPK;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
	

}
