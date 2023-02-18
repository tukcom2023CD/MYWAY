package shop.tukoreamyway.back.domain.member.command.application;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

import shop.tukoreamyway.back.config.security.oauth2.OAuth2Request;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.entity.OAuth2Info;
import shop.tukoreamyway.back.domain.member.query.application.MemberQueryRepository;
import shop.tukoreamyway.back.global.CommandService;

@CommandService
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberQueryRepository memberQueryRepository;

    @Transactional
    public Member saveIfNone(final OAuth2Request oAuth2Request) {
        String socialId = oAuth2Request.getAccountId();
        return memberQueryRepository
                .findByoAuth2InfoSocialId(socialId)
                .orElseGet(() -> memberRepository.save(setUpMember(oAuth2Request)));
    }

    private Member setUpMember(final OAuth2Request req) {
        OAuth2Info oAuth2Info = new OAuth2Info(req.getProvider(), req.getAccountId());
        Member member = Member.builder().oAuth2Info(oAuth2Info).build();
        req.getName().ifPresent(member::setName);
        req.getEmail().ifPresent(member::setEmail);
        return member;
    }
}
