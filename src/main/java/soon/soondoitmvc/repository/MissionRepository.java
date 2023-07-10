package soon.soondoitmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soon.soondoitmvc.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
