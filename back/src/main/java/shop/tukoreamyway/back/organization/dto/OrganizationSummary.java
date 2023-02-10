package shop.tukoreamyway.back.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationSummary {
    private Long id;
    private String name;
    private String industryGroup;

}
