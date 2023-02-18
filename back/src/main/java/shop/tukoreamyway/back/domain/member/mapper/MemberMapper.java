package shop.tukoreamyway.back.domain.member.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import shop.tukoreamyway.back.domain.member.dto.MemberSummary;
import shop.tukoreamyway.back.domain.member.entity.Member;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberMapper {
    MemberSummary toSummany(Member member);
}
