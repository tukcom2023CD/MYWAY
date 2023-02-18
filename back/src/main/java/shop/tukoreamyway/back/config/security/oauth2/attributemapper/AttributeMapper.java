package shop.tukoreamyway.back.config.security.oauth2.attributemapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import shop.tukoreamyway.back.config.security.oauth2.OAuth2Request;
import shop.tukoreamyway.back.domain.member.entity.AuthProvider;

import java.util.Map;

/**
 * attribute값을 dto로, user을 attribute로 변환해주는 클래스
 *
 * @author Hyeonjun Park
 */
@Component
@RequiredArgsConstructor
public class AttributeMapper {

    private final AttributeMapperFactory attributeMapperFactory;

    public OAuth2Request mapToUser(AuthProvider provider, Map<String, Object> attributes) {
        return attributeMapperFactory.get(provider).mapToDTO(attributes);
    }
}
