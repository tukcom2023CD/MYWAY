package shop.tukoreamyway.back.config.security.jwt;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

/**
 * Jwt 토큰을 생성하기 위한 키를 설정하는 Bean
 *
 * @author Hyeonjun Park
 */
@Configuration
public class JwtKeyConfig {
  @Value("${jwt.secret}")
  private String secretKey;

  @Bean
  public Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
  }
}
