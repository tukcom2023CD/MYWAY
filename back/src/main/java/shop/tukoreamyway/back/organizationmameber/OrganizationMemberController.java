package shop.tukoreamyway.back.organization.organizationmameber;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    // 요청온 organization 내역 보기 TODO

    // organization에 속한 사람들 보가 TODO
}
