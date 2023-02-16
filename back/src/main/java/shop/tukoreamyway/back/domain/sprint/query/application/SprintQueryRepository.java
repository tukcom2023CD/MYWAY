package shop.tukoreamyway.back.domain.sprint.query.application;

import shop.tukoreamyway.back.domain.sprint.entity.Sprint;

import java.util.Optional;

public interface SprintQueryRepository {
    Optional<Sprint> findById(Long id);
}
