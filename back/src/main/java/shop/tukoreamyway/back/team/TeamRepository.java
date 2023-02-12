package shop.tukoreamyway.back.team;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.team.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
