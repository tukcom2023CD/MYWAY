package shop.tukoreamyway.back.domain.answer.command.application;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Answer save(Answer answer);

    Optional<Answer> findByWriter(Long id, Member member);
}
