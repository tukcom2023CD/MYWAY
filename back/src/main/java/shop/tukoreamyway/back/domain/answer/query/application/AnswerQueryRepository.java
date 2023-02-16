package shop.tukoreamyway.back.domain.answer.query.application;

import shop.tukoreamyway.back.domain.answer.entity.Answer;

import java.util.Optional;

public interface AnswerQueryRepository {
    Optional<Answer> findById(Long id);
}
