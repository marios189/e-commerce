package sportswear.interfaces;

import sportswear.entities.OrderProduct;
import sportswear.key.OrderProductPK;

public interface OrderProductInterface {
	
	public void add(OrderProductPK oppk, Integer quantity);
	
	 OrderProduct create(OrderProduct orderProduct);

}
