package shop.tukoreamyway.back.member.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OAuth2Info {
    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider = AuthProvider.NONE;

    @Column(nullable = false, unique = true)
    private String socialId;
}
