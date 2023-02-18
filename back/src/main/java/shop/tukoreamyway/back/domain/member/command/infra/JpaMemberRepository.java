package shop.tukoreamyway.back.domain.member.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.member.command.application.MemberRepository;
import shop.tukoreamyway.back.domain.member.entity.Member;

import java.util.UUID;

public interface JpaMemberRepository extends MemberRepository, JpaRepository<Member, UUID> {}
