package shop.tukoreamyway.back.config.security.jwt;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.config.security.oauth2.LoginUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Client의 cookie로 token을 설정
 *
 * @author Hyeonjun Park
 */
@Slf4j
@Service
public class JwtSetupService {
  private final JwtProvider jwtProvider;

  private final String accessTokenHeaderTag;
  private final String refreshTokenHeaderTag;

  public JwtSetupService(
      JwtProvider jwtProvider,
      @Value("${jwt.access-header}") String accessTokenHeaderTag,
      @Value("${jwt.refresh-header}") String refreshTokenHeaderTag) {
    this.jwtProvider = jwtProvider;
    this.accessTokenHeaderTag = accessTokenHeaderTag;
    this.refreshTokenHeaderTag = refreshTokenHeaderTag;
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
    Cookie accessTokenCookie = setCookie(accessTokenHeaderTag, jwtToken.getAccessToken());
    response.addCookie(accessTokenCookie);

    Cookie refreshTokenCookie = setCookie(refreshTokenHeaderTag, jwtToken.getRefreshToken());
    response.addCookie(refreshTokenCookie);
  }

  private Cookie setCookie(String key, String value) {
    Cookie cookie = new Cookie(key, value);
    cookie.setPath("/");
    cookie.setHttpOnly(true);
    return cookie;
  }
}
