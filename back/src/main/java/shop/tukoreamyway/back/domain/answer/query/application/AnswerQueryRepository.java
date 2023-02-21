package shop.tukoreamyway.back.domain.answer.query.application;

import shop.tukoreamyway.back.domain.answer.entity.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerQueryRepository {
    List<Answer> findAllByQuestionId(Long questionId);
    Optional<Answer> findById(Long id);
}
