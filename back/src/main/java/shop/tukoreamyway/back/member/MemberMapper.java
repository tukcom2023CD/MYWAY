package shop.tukoreamyway.back.member;

import org.mapstruct.Mapper;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.member.dto.MemberSummany;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberSummany toSummany(Member member);
}
