package shop.tukoreamyway.back.domain.question.command.application;

import shop.tukoreamyway.back.domain.question.entity.Question;

public interface QuestionRepository {
    Question save(Question question);
    void deleteById(Long id);
}
