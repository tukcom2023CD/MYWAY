package shop.tukoreamyway.back.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.tukoreamyway.back.config.security.oauth2.OAuth2Request;
import shop.tukoreamyway.back.member.MemberRepository;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.member.domain.OAuth2Info;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member saveIfNone(OAuth2Request oAuth2Request) {
        String socialId = oAuth2Request.getAccountId();
        return memberRepository.findByoAuth2InfoSocialId(socialId)
                .orElseGet(() -> memberRepository.save(setUpMember(oAuth2Request)));
    }
    public Member getEntity(UUID id) {
        return memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    private Member setUpMember(OAuth2Request req) {
        OAuth2Info oAuth2Info = new OAuth2Info(req.getProvider(), req.getAccountId());
        Member member = Member.builder().oAuth2Info(oAuth2Info).build();
        req.getName().ifPresent(member::setName);
        req.getEmail().ifPresent(member::setEmail);
        return member;
    }
}