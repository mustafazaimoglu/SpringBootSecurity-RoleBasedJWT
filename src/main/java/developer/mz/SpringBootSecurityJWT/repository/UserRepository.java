package developer.mz.SpringBootSecurityJWT.repository;

import developer.mz.SpringBootSecurityJWT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
