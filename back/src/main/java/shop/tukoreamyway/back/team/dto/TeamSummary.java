package shop.tukoreamyway.back.team.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TeamSummary {
    private Long id;
    private String name;
    private String industryGroup;

}
