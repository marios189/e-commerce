package sportswear.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sportswear.entities.Order;
import sportswear.key.OrderProductPK;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderProductPK> {
	
	@Query(value = "SELECT orders.id, product.name, orders.date_created FROM orders, user, order_product op, product "
			+ "where user.username =:username " 
			+ "and user.id = orders.user_id "
			+ "and op.order_id = orders.id "
			+ "and product.id = op.product_id",nativeQuery = true)
	public List<String> getOrdersByUser(@Param("username") String username);
	
	

}