package shop.tukoreamyway.back.domain.member.query.application;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.config.security.oauth2.LoginUser;
import shop.tukoreamyway.back.domain.member.entity.Member;

@Service
public class AuthService {
    public Member getLoginUser() {
        return ((LoginUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()))
                .getMember();
    }
}