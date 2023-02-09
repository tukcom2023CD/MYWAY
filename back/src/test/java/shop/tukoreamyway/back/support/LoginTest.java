package shop.tukoreamyway.back.support;


import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import shop.tukoreamyway.back.member.AuthService;
import shop.tukoreamyway.back.member.MemberRepository;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;

import static org.mockito.Mockito.when;

@EnableDataBaseTest
public abstract class LoginTest {

    @MockBean protected AuthService authService;

    @Autowired private MemberRepository memberRepository;

    protected Member loginUser;

    @BeforeEach
    private void setup() {
        Member member = null;
        loginUser = memberRepository.save(member);
        when(authService.getLoginUser()).thenReturn(loginUser);
    }
}
