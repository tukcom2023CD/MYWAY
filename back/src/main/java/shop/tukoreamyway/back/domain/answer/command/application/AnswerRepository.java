package shop.tukoreamyway.back.domain.answer.command.application;

import shop.tukoreamyway.back.domain.answer.entity.Answer;

public interface AnswerRepository {
    Answer save(Answer answer);
}
