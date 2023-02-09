package shop.tukoreamyway.back.config.security.oauth2.attributemapper;

import org.springframework.stereotype.Component;
import shop.tukoreamyway.back.config.security.oauth2.OAuth2Request;
import shop.tukoreamyway.back.member.domain.AuthProvider;

import java.util.Map;

/**
 * @author Hyeonjun Park
 */
@Component
public class NaverAttributeMapper implements AttributeMappable {
  @Override
  public OAuth2Request mapToDTO(Map<String, Object> attributes) {

    Map<String, Object> response = (Map<String, Object>) attributes.get("response");

    String accountId = (String) response.get("id");
    String name = (String) response.get("name");
    String email = (String) response.get("email");
    return new OAuth2Request(accountId, name, email, AuthProvider.NAVER);
  }
}
