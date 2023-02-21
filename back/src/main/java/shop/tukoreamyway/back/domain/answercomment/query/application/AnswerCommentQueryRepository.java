package shop.tukoreamyway.back.domain.answercomment.query.application;

import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;

import java.util.List;
import java.util.Optional;

public interface AnswerCommentQueryRepository {
    List<AnswerComment> findAllByAnswerId(Long answerId);
    Optional<AnswerComment> findById(Long id);
}
