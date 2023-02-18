package shop.tukoreamyway.back.config.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import shop.tukoreamyway.back.config.security.oauth2.LoginUser;

import javax.servlet.http.HttpServletResponse;

/**
 * Client의 cookie로 token을 설정
 *
 * @author Hyeonjun Park
 */
@Service
public class JwtSetupService {
    private final JwtProvider jwtProvider;

    @Value("${client.host}")
    private String clientHost;

    @Value("${jwt.access-header}")
    private String accessTokenHeaderTag;

    @Value("${jwt.refresh-header}")
    private String refreshTokenHeaderTag;

    public JwtSetupService(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    /**
     * 인증 login 값을 통해 token을 생성한 다음 클라이언트 쿠키에 저장
     *
     * @param response
     * @param loginUser
     * @author Hyeonjun Park
     */
    public void addJwtTokensInCookie(HttpServletResponse response, LoginUser loginUser) {
        JwtToken jwtToken = jwtProvider.createJWTTokens(loginUser);
        ResponseCookie accessTokenCookie =
                setCookie(accessTokenHeaderTag, jwtToken.getAccessToken());
        response.addHeader("Set-Cookie", accessTokenCookie.toString());
        ResponseCookie refreshTokenCookie =
                setCookie(refreshTokenHeaderTag, jwtToken.getRefreshToken());
        response.addHeader("Set-Cookie", refreshTokenCookie.toString());
    }

    private ResponseCookie setCookie(String key, String value) {
        return ResponseCookie.from(key, value).path("/").httpOnly(true).domain(clientHost).build();
    }
}
