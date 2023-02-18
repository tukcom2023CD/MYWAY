package shop.tukoreamyway.back.config.security.oauth2.attributemapper;

import org.springframework.stereotype.Component;

import shop.tukoreamyway.back.domain.member.entity.AuthProvider;

import java.util.EnumMap;
import java.util.Map;

/**
 * 각 소셜 별로 Mapper을 생성해서 제공하는 Factory
 *
 * @author Hyeonjun Park
 */
@Component
public class AttributeMapperFactory {
    private final Map<AuthProvider, AttributeMappable> mapperMap =
            new EnumMap<>(AuthProvider.class);
    private final GoogleAttributeMapper googleAttributeMapper;
    private final KakaoAttributeMapper kakaoAttributeMapper;
    private final NaverAttributeMapper naverAttributeMapper;

    public AttributeMapperFactory(
            GoogleAttributeMapper googleAttributeMapper,
            KakaoAttributeMapper kakaoAttributeMapper,
            NaverAttributeMapper naverAttributeMapper) {
        this.googleAttributeMapper = googleAttributeMapper;
        this.kakaoAttributeMapper = kakaoAttributeMapper;
        this.naverAttributeMapper = naverAttributeMapper;
        initialize();
    }

    private void initialize() {
        mapperMap.put(AuthProvider.GOOGLE, googleAttributeMapper);
        mapperMap.put(AuthProvider.KAKAO, kakaoAttributeMapper);
        mapperMap.put(AuthProvider.NAVER, naverAttributeMapper);
    }

    public AttributeMappable get(AuthProvider authProvider) {
        return mapperMap.get(authProvider);
    }
}
