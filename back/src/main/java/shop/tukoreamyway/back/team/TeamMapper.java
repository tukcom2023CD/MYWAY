package shop.tukoreamyway.back.team;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.team.domain.Team;
import shop.tukoreamyway.back.team.dto.*;
import shop.tukoreamyway.back.staff.StaffSummary;
import shop.tukoreamyway.back.staff.domain.Staff;

import java.util.List;

@Mapper(componentModel =  MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {
    @Mapping(target = "name", source = "dto.name")
    Team toEntity(TeamRequest dto, Member leader);

    TeamResponse toResponse(Team entity, List<Staff> staffs);
    TeamSummary toSummary(Team entity);
    InviteResponse toInviteResponse(Staff entity);

    @Mapping(target = "name" , source = "member.name")
    StaffSummary toStaffSummary(Staff entity);
}
