package shop.tukoreamyway.back.member;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.member.domain.MemberId;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, MemberId> {
    Optional<Member> findByoAuth2InfoSocialId(String socialId);
}
