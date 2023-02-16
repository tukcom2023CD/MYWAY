package shop.tukoreamyway.back.domain.question.query.application;

import shop.tukoreamyway.back.domain.question.entity.Question;

import java.util.Optional;

public interface QuestionQueryRepository {
    Optional<Question> findById(Long id);
}
