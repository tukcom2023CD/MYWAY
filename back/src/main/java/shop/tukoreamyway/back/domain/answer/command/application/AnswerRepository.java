package shop.tukoreamyway.back.domain.answer.command.application;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.answer.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer save(Answer answer);
}
