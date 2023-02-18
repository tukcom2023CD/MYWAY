package shop.tukoreamyway.back.domain.staff.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.staff.dto.StaffResponse;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.team.entity.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StaffMapper {
    Staff toEntity(Team team, Member member);

    StaffResponse toResponse(Staff entity);
}
