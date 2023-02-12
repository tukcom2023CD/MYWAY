package shop.tukoreamyway.back.staff;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.staff.dto.InviteTeamRequest;
import shop.tukoreamyway.back.staff.dto.InviteResponse;
import shop.tukoreamyway.back.staff.dto.StaffResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("staffs")
public class StaffController {
    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<Void> invite(@RequestBody @Valid InviteTeamRequest dto) {
        staffService.invite(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/accept")
    public ResponseEntity<Void> accept(@PathVariable Long id) {
        staffService.accept(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("auth-user")
    public ResponseEntity<List<InviteResponse>> getInvites() {
        return ResponseEntity.ok(staffService.findLoginUserInvites());
    }

    @GetMapping
    public ResponseEntity<StaffResponse> getByOrganizationId(
            @RequestParam(name = "team-id") Long organizationId) {
        return ResponseEntity.ok(staffService.findByOrganizationId(organizationId));
    }
}
