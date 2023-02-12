package shop.tukoreamyway.back.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.team.dto.TeamSummary;

@Getter
@Builder
@AllArgsConstructor
public class InviteResponse {
    private Long id;
    private TeamSummary team;
}

