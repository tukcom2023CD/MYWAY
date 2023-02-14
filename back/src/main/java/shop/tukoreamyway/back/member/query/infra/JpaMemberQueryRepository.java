package shop.tukoreamyway.back.member.query.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.member.query.application.MemberQueryRepository;
import shop.tukoreamyway.back.member.domain.Member;

import java.util.UUID;

public interface JpaMemberQueryRepository extends MemberQueryRepository, JpaRepository<Member, UUID> {
}
