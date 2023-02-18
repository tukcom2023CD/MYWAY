package shop.tukoreamyway.back.domain.question.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.question.command.application.QuestionRepository;
import shop.tukoreamyway.back.domain.question.entity.Question;

public interface JpaQuestionRepository extends QuestionRepository, JpaRepository<Question, Long> {}
