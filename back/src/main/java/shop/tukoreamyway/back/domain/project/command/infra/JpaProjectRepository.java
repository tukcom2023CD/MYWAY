package shop.tukoreamyway.back.domain.project.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.project.command.application.ProjectRepository;
import shop.tukoreamyway.back.domain.project.entity.Project;

public interface JpaProjectRepository extends ProjectRepository, JpaRepository<Project, Long> {
}
