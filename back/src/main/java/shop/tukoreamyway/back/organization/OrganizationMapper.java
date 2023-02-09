package shop.tukoreamyway.back.organization;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.organization.domain.Organization;
import shop.tukoreamyway.back.organization.dto.OrganizationRequest;
import shop.tukoreamyway.back.organization.dto.OrganizationResponse;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    @Mapping(target = "name", source = "dto.name")
    Organization toEntity(OrganizationRequest dto, Member owner);
    OrganizationResponse toResponse(Organization entity);
}
