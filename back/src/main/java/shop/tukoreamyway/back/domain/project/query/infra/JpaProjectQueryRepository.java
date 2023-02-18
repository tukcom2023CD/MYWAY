package shop.tukoreamyway.back.domain.project.query.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.project.entity.Project;
import shop.tukoreamyway.back.domain.project.query.application.ProjectQueryRepository;

public interface JpaProjectQueryRepository
        extends ProjectQueryRepository, JpaRepository<Project, Long> {}
