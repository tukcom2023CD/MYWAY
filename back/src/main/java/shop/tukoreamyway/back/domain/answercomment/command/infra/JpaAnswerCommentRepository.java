package shop.tukoreamyway.back.domain.answercomment.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answercomment.command.application.AnswerCommentRepository;

public interface JpaAnswerCommentRepository
        extends AnswerCommentRepository, JpaRepository<Answer, Long> {}
