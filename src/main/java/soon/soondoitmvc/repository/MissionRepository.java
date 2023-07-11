package soon.soondoitmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soon.soondoitmvc.domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
}
