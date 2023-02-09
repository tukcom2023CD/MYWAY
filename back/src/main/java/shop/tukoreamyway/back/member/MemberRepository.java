package shop.tukoreamyway.back.member;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.member.domain.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findByoAuth2InfoSocialId(String socialId);
}
