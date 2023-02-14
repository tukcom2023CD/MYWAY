package shop.tukoreamyway.back.domain.team.query.application;

import shop.tukoreamyway.back.domain.team.entity.Team;

import java.util.Optional;

public interface TeamQueryRepository {
    Optional<Team> findById(Long id);
}
