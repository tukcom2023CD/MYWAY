package shop.tukoreamyway.back.member.query.application;

import shop.tukoreamyway.back.member.domain.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberQueryRepository {
    Optional<Member> findByoAuth2InfoSocialId(String socialId);
    Optional<Member> findById(UUID id);
}
