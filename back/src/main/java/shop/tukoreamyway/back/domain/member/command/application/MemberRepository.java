package shop.tukoreamyway.back.domain.member.command.application;

import shop.tukoreamyway.back.domain.member.entity.Member;

public interface MemberRepository {
    Member save(Member member);
}
