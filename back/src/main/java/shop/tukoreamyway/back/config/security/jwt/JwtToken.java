package shop.tukoreamyway.back.config.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Jwt Token DTO
 *
 * @author Hyeonjun Park
 */
@Builder
@Getter
@AllArgsConstructor
public class JwtToken {
  private String accessToken;
  private String refreshToken;
  private String grantType;
}
