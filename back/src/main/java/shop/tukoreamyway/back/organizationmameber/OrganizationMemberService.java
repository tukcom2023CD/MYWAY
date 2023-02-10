package shop.tukoreamyway.back.organizationmameber;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.tukoreamyway.back.member.AuthService;
import shop.tukoreamyway.back.member.MemberService;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.organization.OrganizationService;
import shop.tukoreamyway.back.organization.domain.Organization;
import shop.tukoreamyway.back.organizationmameber.dto.InviteOrganizationRequest;
import shop.tukoreamyway.back.organizationmameber.dto.InviteResponse;
import shop.tukoreamyway.back.organizationmameber.dto.OrganizationMemberResponse;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationMemberService {
    private final OrganizationMemberRepository organizationMemberRepository;
    private final OrganizationMemberMapper organizationMemberMapper;
    private final OrganizationService organizationService;
    private final MemberService memberService;
    private final AuthService authService;

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

    public List<InviteResponse> findLoginUserInvites(){
        Member loginUser = authService.getLoginUser();
        return organizationMemberRepository.findAllByMember(loginUser).stream().map(organizationMemberMapper::toInviteResponse).toList();
    }

    public OrganizationMemberResponse findByOrganizationId(Long organizationId) {
        Organization organization = organizationService.getEntity(organizationId);
        List<Member> members = organizationMemberRepository.findAllByOrganizationId(organizationId).stream().map(OrganizationMember::getMember).toList();
        organizationMemberMapper.toResponse(organization, members);
        return  organizationMemberMapper.toResponse(organization, members);
    }
}
