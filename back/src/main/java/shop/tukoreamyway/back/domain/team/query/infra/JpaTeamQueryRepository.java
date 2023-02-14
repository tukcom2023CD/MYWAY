package shop.tukoreamyway.back.domain.team.query.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.domain.team.query.application.TeamQueryRepository;

public interface JpaTeamQueryRepository extends TeamQueryRepository, JpaRepository<Team, Long> {
}
