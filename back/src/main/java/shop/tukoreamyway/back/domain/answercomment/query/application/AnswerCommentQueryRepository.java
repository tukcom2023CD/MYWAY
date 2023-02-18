package shop.tukoreamyway.back.domain.answercomment.query.application;

import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;

import java.util.Optional;

public interface AnswerCommentQueryRepository {
    Optional<AnswerComment> findById(Long id);
}
