package shop.tukoreamyway.back.support;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;

import shop.tukoreamyway.back.domain.member.command.application.MemberRepository;
import shop.tukoreamyway.back.domain.member.entity.AuthProvider;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.entity.OAuth2Info;
import shop.tukoreamyway.back.domain.member.query.application.AuthService;

import java.util.Random;

import javax.persistence.EntityManager;

@TestExecutionListeners(MockitoTestExecutionListener.class)
public abstract class LoginTest {

    @MockBean AuthService authService;

    @Autowired private MemberRepository memberRepository;
    @Autowired private EntityManager entityManager;

    protected Member loginUser;

    @BeforeEach
    public void setup() {
        Member member =
                new Member(new OAuth2Info(AuthProvider.KAKAO, "1234adsf" + new Random().nextInt()));
        member.setName("loginUser");
        loginUser = memberRepository.save(member);

        when(authService.getLoginUserEntity()).thenReturn(loginUser);
        when(authService.getLoginUserId()).thenReturn(loginUser.getId());
    }
}
