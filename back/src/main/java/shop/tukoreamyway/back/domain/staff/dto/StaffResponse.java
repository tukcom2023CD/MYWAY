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
    private final Long id;
    private final String nickname;
    private final String rank;
    private final Boolean isAcceptMember;
    private final Boolean isAcceptTeam;
    private final MemberSummary member;
    private final TeamSummary team;
}
