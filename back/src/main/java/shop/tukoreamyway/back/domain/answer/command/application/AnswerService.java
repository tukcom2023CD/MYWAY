package shop.tukoreamyway.back.domain.answer.command.application;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import shop.tukoreamyway.back.config.security.oauth2.OAuth2Request;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryRepository;
import shop.tukoreamyway.back.domain.member.command.application.MemberRepository;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.entity.OAuth2Info;
import shop.tukoreamyway.back.domain.member.query.application.MemberQueryRepository;
import shop.tukoreamyway.back.global.CommandService;

@CommandService
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository memberRepository;
    private final AnswerQueryRepository memberQueryRepository;

    public Answer CreateQuestion(Long writer) {
        Answer answer = new Answer();
        this.writer = writer;
    }

    public Answer DeleteQuestion(Long id) {

    }

    public Answer ModifyQuestion(Long id) {

    }

}
