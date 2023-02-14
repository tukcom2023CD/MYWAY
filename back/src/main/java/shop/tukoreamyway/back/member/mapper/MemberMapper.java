package shop.tukoreamyway.back.member.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.member.dto.MemberSummary;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberMapper {
    MemberSummary toSummany(Member member);
}
