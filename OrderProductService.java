package sportswear.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sportswear.entities.OrderProduct;
import sportswear.interfaces.OrderProductInterface;
import sportswear.key.OrderProductPK;
import sportswear.repositories.OrderProductRepository;

@Service
public class OrderProductService implements OrderProductInterface {
	
	@Autowired
	OrderProductRepository detailsRepo;

	@Override
	public void add(OrderProductPK oppk, Integer quantity) {
		OrderProduct op = new OrderProduct();
		op.setPk(new OrderProductPK(oppk.getOrder(), oppk.getProduct()));
		op.setQuantity(quantity);
		detailsRepo.save(op);
	}

	@Override
	public OrderProduct create(OrderProduct orderProduct) {
		return detailsRepo.save(orderProduct);
	}

	

}
