package shop.tukoreamyway.back.domain.answercomment.command.application;

import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;

public interface AnswerCommentRepository {
    AnswerComment save(AnswerComment answerComment);
    void deleteById(Long id);
}
