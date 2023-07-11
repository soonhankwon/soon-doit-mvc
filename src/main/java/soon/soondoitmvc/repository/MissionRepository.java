package soon.soondoitmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soon.soondoitmvc.domain.Mission;
import soon.soondoitmvc.domain.User;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    List<Mission> findAllByUser(User user);
}
