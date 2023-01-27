package sportswear.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserInterface {
	
	public boolean esiste(String username);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}