package shop.tukoreamyway.back.domain.answercomment.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.answercomment.command.application.AnswerCommentRepository;
import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;

public interface JpaAnswerCommentRepository
        extends AnswerCommentRepository, JpaRepository<AnswerComment, Long> {}
