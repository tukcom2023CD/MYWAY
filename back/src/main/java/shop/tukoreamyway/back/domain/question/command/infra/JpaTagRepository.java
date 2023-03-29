package shop.tukoreamyway.back.domain.question.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.question.command.application.TagRepository;
import shop.tukoreamyway.back.domain.question.entity.Tag;

public interface JpaTagRepository extends TagRepository, JpaRepository<Tag, Long> {}
