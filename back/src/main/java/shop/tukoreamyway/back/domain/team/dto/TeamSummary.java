package shop.tukoreamyway.back.domain.team.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TeamSummary {
    private final Long id;
    private final String name;
    private final String industryGroup;
}
