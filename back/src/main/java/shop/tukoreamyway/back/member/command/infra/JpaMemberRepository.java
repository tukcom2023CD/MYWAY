package shop.tukoreamyway.back.member.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.member.command.application.MemberRepository;
import shop.tukoreamyway.back.member.domain.Member;

import java.util.UUID;

public interface JpaMemberRepository extends MemberRepository, JpaRepository<Member, UUID> {
}
