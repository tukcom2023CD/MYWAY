package shop.tukoreamyway.back.organization.organizationmameber;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.tukoreamyway.back.member.MemberService;
import shop.tukoreamyway.back.organization.OrganizationService;
import shop.tukoreamyway.back.organization.domain.Organization;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationMemberService {
    private final OrganizationMemberRepository organizationMemberRepository;
    private final OrganizationService organizationService;
    private final MemberService memberService;

    @Transactional
    public void invite(InviteOrganizationRequest dto) {
        Organization organization = organizationService.getEntity(dto.getOrganizationId());
        dto.getMembers().stream()
                .map(memberService::getEntity)
                .map(member -> new OrganizationMember(organization, member))
                .forEach(organizationMemberRepository::save);
    }

    @Transactional
    public void accept(Long id) {
        getEntity(id).accept();
    }

    public OrganizationMember getEntity(Long id) {
        return organizationMemberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<OrganizationMember> findByMemberId(UUID memberId){
        return organizationMemberRepository.findAllByMemberId(memberId);
    }

    public  List<OrganizationMember> findByOrganizationId(Long organizationId) {
        return  organizationMemberRepository.findAllByOrganizationId(organizationId);
    }
}
