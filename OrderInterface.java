package sportswear.interfaces;

import java.util.List;

import sportswear.entities.Order;
import sportswear.entities.User;

public interface OrderInterface {
	
	public List<String> getAllOrders(String username) ;
	public Order create(Order order, User user);
	
	 void update(Order order);
	
}
