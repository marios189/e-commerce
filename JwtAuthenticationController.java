package sportswear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sportswear.DTO.UserDTO;
import sportswear.authentication.JwtRequest;
import sportswear.authentication.JwtResponse;
import sportswear.authentication.JwtTokenUtil;
import sportswear.services.JwtUserDetailsService;

@Controller
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception{
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?>  createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
			try{
				authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
				final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
				final String token = jwtTokenUtil.generateToken(userDetails);
				
				return ResponseEntity.ok(new JwtResponse(token));
			}catch(Exception e) {
				return null;
			}
	}
	
	@GetMapping("/utenti")
	public ResponseEntity<Object> getUsers(){
		return ResponseEntity.ok(userDetailsService.find());
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
