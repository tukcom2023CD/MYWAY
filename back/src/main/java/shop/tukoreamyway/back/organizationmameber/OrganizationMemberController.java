package shop.tukoreamyway.back.organizationmameber;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.organizationmameber.dto.InviteOrganizationRequest;
import shop.tukoreamyway.back.organizationmameber.dto.InviteResponse;
import shop.tukoreamyway.back.organizationmameber.dto.OrganizationMemberResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("organization-members")
public class OrganizationMemberController {
    private final OrganizationMemberService organizationMemberService;

    @PostMapping
    public ResponseEntity<Void> invite(@RequestBody @Valid InviteOrganizationRequest dto) {
        organizationMemberService.invite(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/accept")
    public ResponseEntity<Void> accept(@PathVariable Long id) {
        organizationMemberService.accept(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("auth-user")
    public ResponseEntity<List<InviteResponse>> getInvites() {
        return ResponseEntity.ok(organizationMemberService.findLoginUserInvites());
    }

    @GetMapping
    public ResponseEntity<OrganizationMemberResponse> getByOrganizationId(
            @RequestParam(name = "organization-id") Long organizationId) {
        return ResponseEntity.ok(organizationMemberService.findByOrganizationId(organizationId));
    }
}
