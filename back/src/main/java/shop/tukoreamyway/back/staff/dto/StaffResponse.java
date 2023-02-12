package shop.tukoreamyway.back.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.member.dto.MemberSummary;
import shop.tukoreamyway.back.team.dto.TeamSummary;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class StaffResponse {
    private TeamSummary team;
    private List<MemberSummary> members;
}
