package sportswear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sportswear.entities.User;
import sportswear.services.JwtUserDetailsService;

@Controller
@RequestMapping("/profile")
public class UserController {
	
	@Autowired
	JwtUserDetailsService service;
	
	
	
	@GetMapping("/{username}")
	public ResponseEntity<List<User>> getDetails(@PathVariable String username){
		return ResponseEntity.ok(service.getUserDetails(username));
	}
}
