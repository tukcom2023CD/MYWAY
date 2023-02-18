package shop.tukoreamyway.back.domain.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import shop.tukoreamyway.back.domain.member.dto.MemberSummary;
import shop.tukoreamyway.back.domain.team.dto.TeamSummary;

@Getter
@Builder
@AllArgsConstructor
public class StaffResponse {
    private Long id;
    private String nickname;
    private String rank;
    private Boolean isAcceptMember;
    private Boolean isAcceptTeam;
    private MemberSummary member;
    private TeamSummary team;
}
