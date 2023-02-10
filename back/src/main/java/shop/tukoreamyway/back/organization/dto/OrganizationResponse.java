package shop.tukoreamyway.back.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.member.dto.MemberSummary;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationResponse {
    private Long id;
    private String name;
    private MemberSummary owner;
    private String industryGroup;
}
