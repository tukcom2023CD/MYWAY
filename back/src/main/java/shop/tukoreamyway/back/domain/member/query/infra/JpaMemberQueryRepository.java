package shop.tukoreamyway.back.domain.member.query.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.query.application.MemberQueryRepository;

import java.util.UUID;

public interface JpaMemberQueryRepository
        extends MemberQueryRepository, JpaRepository<Member, UUID> {}
