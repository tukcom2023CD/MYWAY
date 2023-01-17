package shop.tukoreamyway.back.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.tukoreamyway.back.domain.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {}
