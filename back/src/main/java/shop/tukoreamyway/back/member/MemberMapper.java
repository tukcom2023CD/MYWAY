package shop.tukoreamyway.back.member;

import org.mapstruct.Mapper;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.member.dto.MemberSummary;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberSummary toSummany(Member member);
}
