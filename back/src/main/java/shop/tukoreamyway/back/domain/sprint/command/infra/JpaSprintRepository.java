package shop.tukoreamyway.back.domain.sprint.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.sprint.command.application.SprintRepository;
import shop.tukoreamyway.back.domain.sprint.entity.Sprint;

public interface JpaSprintRepository extends SprintRepository, JpaRepository<Sprint, Long> {}
