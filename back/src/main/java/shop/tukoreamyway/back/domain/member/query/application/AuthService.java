package shop.tukoreamyway.back.domain.member.query.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import shop.tukoreamyway.back.config.security.oauth2.LoginUser;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.global.service.QueryService;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@QueryService
@RequiredArgsConstructor
public class AuthService {
    private final MemberQueryRepository memberQueryRepository;

    public UUID getLoginUserId() {
        return ((LoginUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()))
                .getMemberId();
    }

    public Member getLoginUserEntity() {
        return memberQueryRepository
                .findById(getLoginUserId())
                .orElseThrow(EntityNotFoundException::new);
    }
}
