package shop.tukoreamyway.back.organizationmameber.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.organization.dto.OrganizationSummary;

@Getter
@Builder
@AllArgsConstructor
public class InviteResponse {
    private Long id;
    private OrganizationSummary organization;
}
