package shop.tukoreamyway.back.config.security.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import shop.tukoreamyway.back.domain.authaccount.service.AuthAccountService;

import java.security.Key;
import java.util.Collection;
import java.util.UUID;

/**
 * jwt token을 검증
 *
 * @author Hyeonjun Park
 */
@Component
@RequiredArgsConstructor
public class JwtValidator {
  private final Key key;
  private final AuthAccountService authAccountService;

  public Authentication getAuthentication(String accessToken) {
    Claims claims = getTokenBodyClaims(accessToken);
    Collection<? extends GrantedAuthority> authorities = extractAuthority(claims);
    UserDetails principal = new User(String.valueOf(claims.get("id")), "", authorities);

    return new UsernamePasswordAuthenticationToken(principal, "", authorities);
  }

  /**
   * 토큰 내의 Claim에서 사용자 권한 List 추출
   *
   * @param claims
   * @return Collection<? extends GrantedAuthority>
   * @author Hyeonjun Park
   */
  private Collection<? extends GrantedAuthority> extractAuthority(Claims claims) {
    return authAccountService.getAuthority(parseLong(claims));
  }

  private UUID parseLong(Claims claims) {
    return UUID.fromString(String.valueOf(claims.get("id")));
  }

  private Claims getTokenBodyClaims(String accessToken) {
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
  }
}
