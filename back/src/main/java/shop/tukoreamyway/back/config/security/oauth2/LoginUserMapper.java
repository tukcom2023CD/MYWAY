package shop.tukoreamyway.back.config.security.oauth2;

import org.springframework.stereotype.Component;
import shop.tukoreamyway.back.member.domain.Member;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginUserMapper {
    public LoginUser mapToLoginUser(Member user) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", user.getId());
        return new LoginUser(user.getId(), attributes, user.getRole());
    }
}
