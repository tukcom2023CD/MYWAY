package shop.tukoreamyway.back.config.security.oauth2.attributemapper;

import java.util.Map;
import shop.tukoreamyway.back.config.security.oauth2.OAuth2Request;

/**
 * 소셜 로그인시 Attribute 값을 dto로 mapping 하는 interface
 *
 * @author Hyeonjun Park
 */
public interface AttributeMappable {
  OAuth2Request mapToDTO(Map<String, Object> attributes);
}
