package sportswear.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sportswear.entities.Order;
import sportswear.entities.User;
import sportswear.interfaces.OrderInterface;
import sportswear.repositories.OrderRepository;
import sportswear.repositories.UserRepository;

@Service
public class OrderService implements OrderInterface{
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	UserRepository userRepository;


	@Override
	public List<String> getAllOrders(String username) {
		return repository.getOrdersByUser(username);
	}

	@Override
    public Order create(Order order,User user) {
        order.setDateCreated(LocalDate.now());
        order.setUser(userRepository.findByUsername(user.getUsername()));
        return repository.save(order);
    }

    @Override
    public void update(Order order) {
        repository.save(order);
    }
}
