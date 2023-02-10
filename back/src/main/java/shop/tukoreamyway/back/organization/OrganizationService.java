package shop.tukoreamyway.back.organization;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.member.AuthService;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.organization.domain.Organization;
import shop.tukoreamyway.back.organization.dto.OrganizationRequest;
import shop.tukoreamyway.back.organization.dto.OrganizationResponse;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    private final AuthService authService;

    public OrganizationResponse create(OrganizationRequest dto) {
        Member loginUser = authService.getLoginUser();
        Organization organization = organizationRepository.save(organizationMapper.toEntity(dto, loginUser));
        return organizationMapper.toResponse(organization);
    }

    public Organization getEntity(Long id) {
        return organizationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
