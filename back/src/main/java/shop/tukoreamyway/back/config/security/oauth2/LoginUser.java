package shop.tukoreamyway.back.config.security.oauth2;

import io.jsonwebtoken.Claims;

import lombok.Getter;

import java.util.UUID;

/**
 * login 유저정보에 대한 dto
 *
 * @author Hyeonjun Park
 */
@Getter
public class LoginUser {
    private UUID id;
    private String nickname;

    public LoginUser(Claims claims) {
        this.id = UUID.fromString(claims.get("id").toString());
        this.nickname = claims.get("nickname").toString();
    }

    public LoginUser(UUID id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
