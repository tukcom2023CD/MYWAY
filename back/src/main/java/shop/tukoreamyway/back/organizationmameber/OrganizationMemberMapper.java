package shop.tukoreamyway.back.organizationmameber;

import org.mapstruct.Mapper;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.organization.domain.Organization;
import shop.tukoreamyway.back.organizationmameber.dto.InviteResponse;
import shop.tukoreamyway.back.organizationmameber.dto.OrganizationMemberResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMemberMapper {
    InviteResponse toInviteResponse(OrganizationMember entity);
    OrganizationMemberResponse toResponse(Organization organization, List<Member> members);
}
