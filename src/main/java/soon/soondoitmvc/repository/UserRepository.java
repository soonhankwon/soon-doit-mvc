package soon.soondoitmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soon.soondoitmvc.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByName(String name);
}
