package shop.tukoreamyway.back.config.security.oauth2.attributemapper;

import org.springframework.stereotype.Component;
import shop.tukoreamyway.back.config.security.oauth2.OAuth2Request;
import shop.tukoreamyway.back.member.domain.AuthProvider;

import java.util.Map;


/**
 * @author Hyeonjun Park
 */
@Component
public class GoogleAttributeMapper implements AttributeMappable {
  @Override
  public OAuth2Request mapToDTO(Map<String, Object> attributes) {
    String accountId = (String) attributes.get("sub");
    String name = (String) attributes.get("name");
    String email = (String) attributes.get("email");
    return new OAuth2Request(accountId, name, email, AuthProvider.GOOGLE);
  }
}
