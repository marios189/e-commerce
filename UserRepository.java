package sportswear.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sportswear.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	@Query(value="SELECT * FROM `e-commerce`.user where username =:username", nativeQuery = true)
	public List<User> getUserDetails(@Param("username")String username);
}