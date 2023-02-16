package shop.tukoreamyway.back.domain.sprint.query.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.domain.sprint.query.application.SprintQueryRepository;

public interface JpaSprintQueryRepository extends SprintQueryRepository, JpaRepository<Sprint, Long> {
}
