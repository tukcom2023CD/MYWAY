package shop.tukoreamyway.back.domain.question.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.question.command.application.QuestionTagRepository;
import shop.tukoreamyway.back.domain.question.entity.QuestionTag;

public interface JpaQuestionTagRepository extends QuestionTagRepository, JpaRepository<QuestionTag, Long> {
}
