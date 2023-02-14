package shop.tukoreamyway.back.config.security.oauth2;

import org.springframework.stereotype.Component;
import shop.tukoreamyway.back.domain.member.entity.Member;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginUserMapper {
    public LoginUser mapToLoginUser(Member user) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", user.getId());
        return new LoginUser(user, attributes, user.getRole());
    }
}
