package shop.tukoreamyway.back.config.security.oauth2;

import lombok.Getter;

import shop.tukoreamyway.back.domain.member.entity.AuthProvider;

import java.util.Optional;

/** Oauth2 로그인 시 받아올 수 있는 */
@Getter
public class OAuth2Request {
    private String accountId;
    private Optional<String> name;
    private Optional<String> email;
    private AuthProvider provider;

    public OAuth2Request(String accountId, String name, String email, AuthProvider provider) {
        this.accountId = accountId;
        this.name = Optional.ofNullable(name);
        this.email = Optional.ofNullable(email);
        this.provider = provider;
    }
}
