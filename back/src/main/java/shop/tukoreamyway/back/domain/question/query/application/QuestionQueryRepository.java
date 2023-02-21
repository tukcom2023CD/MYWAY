package shop.tukoreamyway.back.domain.question.query.application;

import shop.tukoreamyway.back.domain.question.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionQueryRepository {
    List<Question> findAllQuestions(Long id);
    Optional<Question> findQuestionById(Long id);
}
