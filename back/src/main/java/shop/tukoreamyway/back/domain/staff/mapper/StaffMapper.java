package shop.tukoreamyway.back.domain.staff.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.staff.dto.TeamLeaderRequest;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.team.entity.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StaffMapper {
    @Mapping(target = "name", source = "dto.name")
    Staff toEntity(TeamLeaderRequest dto, Team team, Member member);
}
