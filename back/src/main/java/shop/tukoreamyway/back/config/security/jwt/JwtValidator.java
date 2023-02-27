package shop.tukoreamyway.back.config.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import shop.tukoreamyway.back.config.security.oauth2.LoginUser;
import shop.tukoreamyway.back.config.security.oauth2.LoginUserMapper;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.global.service.EntityQueryService;

import java.security.Key;
import java.util.UUID;

/**
 * jwt token을 검증
 *
 * @author Hyeonjun Park
 */
@Component
@RequiredArgsConstructor
public final class JwtValidator {
    private final Key key;
    private final EntityQueryService<Member, UUID> memberQueryService;
    private final LoginUserMapper loginUserMapper;

    public Authentication getAuthentication(String accessToken) {
        Claims claims = getTokenBodyClaims(accessToken);
        Member member = memberQueryService.getEntity(extractUUID(claims));
        LoginUser loginUser = loginUserMapper.mapToLoginUser(member);

        return new UsernamePasswordAuthenticationToken(loginUser, "", loginUser.getAuthorities());
    }

    private UUID extractUUID(Claims claims) {
        return UUID.fromString(claims.get("id", String.class));
    }

    private Claims getTokenBodyClaims(String accessToken) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
    }
}
