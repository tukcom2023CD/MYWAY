package shop.tukoreamyway.back.support.fixture;

import shop.tukoreamyway.back.domain.member.entity.AuthProvider;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.entity.OAuth2Info;

public enum MemberFixture {
    M1(AuthProvider.KAKAO, "asdfqwer"),
    M2(AuthProvider.GOOGLE, "kjlkjljk"),
    M3(AuthProvider.NAVER, "hjhjhjhj");

    private final AuthProvider authProvider;
    private final String socialId;

    MemberFixture(AuthProvider authProvider, String socialId) {
        this.authProvider = authProvider;
        this.socialId = socialId;
    }

    public Member toEntity() {
        return new Member(new OAuth2Info(authProvider, socialId));
    }
}
