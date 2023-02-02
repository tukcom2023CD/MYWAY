package shop.tukoreamyway.back.member.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.member.command.domain.Member;
import shop.tukoreamyway.back.member.command.domain.MemberId;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, MemberId> {
    Optional<Member> findByoAuth2InfoSocialId(String socialId);
}
