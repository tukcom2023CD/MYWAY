package shop.tukoreamyway.back.member.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import shop.tukoreamyway.back.config.security.oauth2.OAuth2Request;
import shop.tukoreamyway.back.member.MemberRepository;
import shop.tukoreamyway.back.member.domain.AuthProvider;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;



@EnableDataBaseTest
@DisplayName("MemberService 에서")
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Nested
    @DisplayName("saveIfNone 호출 시")
    class CallSaveIfNone {
        @Test
        @DisplayName("저장을 수행하는가")
        void successSave() {
            //given
            OAuth2Request req = new OAuth2Request("aaaaaaaa", "홍길동", "aa@bb.com", AuthProvider.GOOGLE);
            //when
            Member member = memberService.saveIfNone(req);
            Optional<Member> findMember = memberRepository.findById(member.getId());
            //then
            assertThat(member.getName()).isEqualTo(req.getName().get());
            assertThat(member.getEmail()).isEqualTo(req.getEmail().get());
            assertThat(member.getId()).isEqualTo(findMember.get().getId());
            assertThat(member.getOAuth2Info()).isEqualTo(findMember.get().getOAuth2Info());
        }

        @Test
        @DisplayName("이미 저장되어있으면 저장을 수행 안하는가")
        void notSaveIfExist() {
            //given
            OAuth2Request req = new OAuth2Request("aaaaaaaa", "홍길동", "aa@bb.com", AuthProvider.GOOGLE);
            //when
            memberService.saveIfNone(req);
            memberService.saveIfNone(req);
            memberService.saveIfNone(req);
            int size = memberRepository.findAll().size();

            //then
            assertThat(size).isEqualTo(1);
        }
    }
}