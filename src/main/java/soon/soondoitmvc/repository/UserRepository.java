package soon.soondoitmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soon.soondoitmvc.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByNameAndPassword(String name, String password);

    Optional<User> findUserByName(String name);
}
