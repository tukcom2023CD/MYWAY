package shop.tukoreamyway.back.member.command.application;

import shop.tukoreamyway.back.member.domain.Member;

public interface MemberRepository  {
    Member save(Member member);
}
