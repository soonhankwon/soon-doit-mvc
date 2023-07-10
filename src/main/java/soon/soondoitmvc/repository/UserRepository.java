package soon.soondoitmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soon.soondoitmvc.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
