package shop.tukoreamyway.back.support;


import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import shop.tukoreamyway.back.domain.member.query.application.AuthService;
import shop.tukoreamyway.back.domain.member.command.application.MemberRepository;
import shop.tukoreamyway.back.domain.member.entity.AuthProvider;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.entity.OAuth2Info;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;

import static org.mockito.Mockito.when;

@EnableDataBaseTest
public abstract class LoginTest {

    @MockBean protected AuthService authService;

    @Autowired private MemberRepository memberRepository;

    protected Member loginUser;

    @BeforeEach
    private void setup() {
        Member member = new Member(new OAuth2Info(AuthProvider.KAKAO, "1234adsf"));
        loginUser = memberRepository.save(member);
        when(authService.getLoginUser()).thenReturn(loginUser);
    }
}
