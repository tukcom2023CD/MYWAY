package shop.tukoreamyway.back.domain.answercomment.query.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;
import shop.tukoreamyway.back.domain.answercomment.query.application.AnswerCommentQueryRepository;

public interface JpaAnswerCommentQueryRepository extends AnswerCommentQueryRepository, JpaRepository<AnswerComment, Long> {
}
