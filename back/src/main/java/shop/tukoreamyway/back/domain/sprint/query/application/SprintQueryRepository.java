package shop.tukoreamyway.back.domain.sprint.query.application;

import shop.tukoreamyway.back.domain.sprint.entity.Sprint;

import java.util.List;
import java.util.Optional;

public interface SprintQueryRepository {
    Optional<Sprint> findById(Long id);
    List<Sprint> findAllByProjectId(Long projectId);
}
