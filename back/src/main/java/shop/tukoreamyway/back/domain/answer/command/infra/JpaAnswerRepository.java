package shop.tukoreamyway.back.domain.answer.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.answer.command.application.AnswerRepository;
import shop.tukoreamyway.back.domain.answer.entity.Answer;

public interface JpaAnswerRepository extends AnswerRepository, JpaRepository<Answer, Long> {}
