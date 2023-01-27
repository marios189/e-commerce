package sportswear.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sportswear.DTO.UserDTO;
import sportswear.entities.User;
import sportswear.repositories.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public List<User> getUserDetails(String username) {
		return userDao.getUserDetails(username);
	}
	
	
	public User save(UserDTO user) {
		User newUser = new User();
		User u1 = userDao.findByUsername(user.getUsername());
		if(u1==null) {
			newUser.setUsername(user.getUsername());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setNome(user.getNome());
			newUser.setCognome(user.getCognome());
			newUser.setDataDiNascita(user.getDataDiNascita());
			newUser.setIndirizzo(user.getIndirizzo());
			return userDao.save(newUser);
		}else {
			System.out.println("Utente con username " + user.getUsername() + " utilizzato da un altro utente");
			return null;
		}
		
	}
	
	public boolean esiste(String username) {
		return userDao.findByUsername(username)!= null;
	}

	public Object find() {
		return userDao.findAll();
	}
}