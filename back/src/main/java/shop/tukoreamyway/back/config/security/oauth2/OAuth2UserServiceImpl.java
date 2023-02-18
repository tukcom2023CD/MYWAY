package shop.tukoreamyway.back.config.security.oauth2;

import lombok.RequiredArgsConstructor;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import shop.tukoreamyway.back.config.security.oauth2.attributemapper.AttributeMapper;
import shop.tukoreamyway.back.domain.member.command.application.MemberService;
import shop.tukoreamyway.back.domain.member.entity.AuthProvider;
import shop.tukoreamyway.back.domain.member.entity.Member;

/**
 * User 인증 후 계정이 있으면 그대로 불러오고, 없으면 신규 생성하여 유저를 불러옴
 *
 * @author Hyeonjun Park
 */
@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImpl extends DefaultOAuth2UserService {
    private final AttributeMapper attributeMapper;
    private final MemberService memberService;
    private final LoginUserMapper loginUserMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        AuthProvider authProvider =
                AuthProvider.valueOf(
                        userRequest.getClientRegistration().getClientName().toUpperCase());
        OAuth2User oAuth2User = super.loadUser(userRequest);
        OAuth2Request oAuth2Request =
                attributeMapper.mapToUser(authProvider, oAuth2User.getAttributes());

        Member user = memberService.saveIfNone(oAuth2Request);
        return loginUserMapper.mapToLoginUser(user);
    }
}
