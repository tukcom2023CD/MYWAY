package shop.tukoreamyway.back.member;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.config.security.oauth2.LoginUser;
import shop.tukoreamyway.back.member.domain.Member;

@Service
public class AuthService {
    public Member getLoginUser() {
        return ((LoginUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()))
                .getMember();
    }
}