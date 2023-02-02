package shop.tukoreamyway.back.config.security.oauth2.attributemapper;

import org.springframework.stereotype.Component;
import shop.tukoreamyway.back.config.security.oauth2.OAuth2Request;
import shop.tukoreamyway.back.member.command.domain.AuthProvider;

import java.util.Map;

/**
 * @author Hyeonjun Park
 */
@Component
public class KakaoAttributeMapper implements AttributeMappable {
  @Override
  public OAuth2Request mapToDTO(Map<String, Object> attributes) {
    String accountId = attributes.get("id").toString();
    String email = (String) attributes.get("email");
    String name = "sample";
    return new OAuth2Request(accountId, name, email, AuthProvider.KAKAO);
  }
}
