package shop.tukoreamyway.back.domain.question.query.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryRepository;

public interface JpaQuestionQueryRepository extends QuestionQueryRepository, JpaRepository<Question, Long> {
}
