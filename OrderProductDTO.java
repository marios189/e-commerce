package sportswear.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sportswear.entities.Product;

@Getter
@Setter
@AllArgsConstructor
public class OrderProductDTO {
	
	private Product product;
    private Integer quantity;

}
