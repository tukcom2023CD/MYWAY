package shop.tukoreamyway.back.team.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.member.dto.MemberSummary;

@Getter
@Builder
@AllArgsConstructor
public class TeamResponse {
    private Long id;
    private String name;
    private MemberSummary leader;
    private String industryGroup;
}
