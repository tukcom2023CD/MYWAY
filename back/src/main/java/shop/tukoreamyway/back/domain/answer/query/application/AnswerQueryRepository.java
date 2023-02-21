package shop.tukoreamyway.back.domain.answer.query.application;

import shop.tukoreamyway.back.domain.answer.entity.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerQueryRepository {
    List<Answer> findAll(Long id);
    Optional<Answer> findById(Long id);
}
