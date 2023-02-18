package shop.tukoreamyway.back.domain.answer.query.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryRepository;

public interface JpaAnswerQueryRepository
        extends AnswerQueryRepository, JpaRepository<Answer, Long> {}
