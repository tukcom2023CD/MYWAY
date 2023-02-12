package shop.tukoreamyway.back.staff;

import org.mapstruct.Mapper;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.staff.dto.StaffResponse;
import shop.tukoreamyway.back.team.domain.Team;
import shop.tukoreamyway.back.staff.dto.InviteResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    InviteResponse toInviteResponse(Staff entity);
    StaffResponse toResponse(Team team, List<Member> members);
}
