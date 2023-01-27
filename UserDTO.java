package sportswear.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Integer id;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private String indirizzo;
}
