package shop.tukoreamyway.back.organizationmameber.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.member.dto.MemberSummary;
import shop.tukoreamyway.back.organization.dto.OrganizationSummary;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationMemberResponse {
    private OrganizationSummary organization;
    private List<MemberSummary> members;
}
